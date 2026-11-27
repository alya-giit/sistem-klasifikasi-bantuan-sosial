import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int idUser;
    private String nik;
    private String nama;
    private String email;
    private String password;
    private String hakAkses;
    private String noTelepon;
    private LocalDateTime tanggalBuat;
    private LocalDateTime tanggalUbah;

    // Relasi: 1 User memiliki 0..* Sesi dan mengajukan 0..* CalonPenerima
    private List<Sesi> daftarSesi = new ArrayList<>();
    private List<CalonPenerima> daftarPengajuan = new ArrayList<>();

    public User() {
    }

    public User(int idUser, String nik, String nama, String email, String password,
                String hakAkses, String noTelepon, LocalDateTime tanggalBuat, LocalDateTime tanggalUbah) {
        this.idUser = idUser;
        this.nik = nik;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.hakAkses = hakAkses;
        this.noTelepon = noTelepon;
        this.tanggalBuat = tanggalBuat;
        this.tanggalUbah = tanggalUbah;
    }

    public boolean register() {
        this.tanggalBuat = LocalDateTime.now();
        this.tanggalUbah = LocalDateTime.now();
        return true;
    }

    public boolean login(String email, String password) {
        return this.email != null && this.email.equals(email)
                && this.password != null && this.password.equals(password);
    }

    public void ubahProfile(String namaBaru, String noTeleponBaru) {
        this.nama = namaBaru;
        this.noTelepon = noTeleponBaru;
        this.tanggalUbah = LocalDateTime.now();
    }

    public void logout() {
        // Proses mengakhiri sesi aktif pengguna
    }

    public int getIdUser() {
        return idUser;
    }

    public String getNama() {
        return nama;
    }

    public List<Sesi> getDaftarSesi() {
        return daftarSesi;
    }

    public List<CalonPenerima> getDaftarPengajuan() {
        return daftarPengajuan;
    }
}