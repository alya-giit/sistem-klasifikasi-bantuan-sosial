import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BantuanSosial {
    private int idBantuan;
    private String jenisBantuan;
    private String deskripsi;
    private LocalDateTime tanggalBuat;
    private LocalDateTime tanggalUbah;

    // Relasi: 1 BantuanSosial mencakup 0..* CalonPenerima
    private List<CalonPenerima> daftarCalonPenerima = new ArrayList<>();

    public BantuanSosial() {
    }

    public BantuanSosial(int idBantuan, String jenisBantuan, String deskripsi,
                         LocalDateTime tanggalBuat, LocalDateTime tanggalUbah) {
        this.idBantuan = idBantuan;
        this.jenisBantuan = jenisBantuan;
        this.deskripsi = deskripsi;
        this.tanggalBuat = tanggalBuat;
        this.tanggalUbah = tanggalUbah;
    }

    public boolean tambahBantuan() {
        this.tanggalBuat = LocalDateTime.now();
        this.tanggalUbah = LocalDateTime.now();
        return true;
    }

    public boolean ubahBantuan(String jenisBantuanBaru, String deskripsiBaru) {
        this.jenisBantuan = jenisBantuanBaru;
        this.deskripsi = deskripsiBaru;
        this.tanggalUbah = LocalDateTime.now();
        return true;
    }

    public boolean hapusBantuan() {
        daftarCalonPenerima.clear();
        return true;
    }

    public List<CalonPenerima> ambilSemua() {
        return daftarCalonPenerima;
    }

    public int getIdBantuan() {
        return idBantuan;
    }

    public String getJenisBantuan() {
        return jenisBantuan;
    }
}