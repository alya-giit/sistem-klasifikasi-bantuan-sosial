import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Kriteria {
    private int idKriteria;
    private String namaKriteria;
    private float bobot;
    private LocalDateTime tanggalBuat;
    private LocalDateTime tanggalUbah;

    private static final List<Kriteria> DAFTAR_KRITERIA = new ArrayList<>();

    public Kriteria() {
    }

    public Kriteria(int idKriteria, String namaKriteria, float bobot,
                    LocalDateTime tanggalBuat, LocalDateTime tanggalUbah) {
        this.idKriteria = idKriteria;
        this.namaKriteria = namaKriteria;
        this.bobot = bobot;
        this.tanggalBuat = tanggalBuat;
        this.tanggalUbah = tanggalUbah;
    }

    public boolean tambahKriteria() {
        this.tanggalBuat = LocalDateTime.now();
        this.tanggalUbah = LocalDateTime.now();
        return DAFTAR_KRITERIA.add(this);
    }

    public boolean ubahKriteria(String namaKriteriaBaru, float bobotBaru) {
        this.namaKriteria = namaKriteriaBaru;
        this.bobot = bobotBaru;
        this.tanggalUbah = LocalDateTime.now();
        return true;
    }

    public boolean hapusKriteria() {
        return DAFTAR_KRITERIA.remove(this);
    }

    public List<Kriteria> ambilSemua() {
        return new ArrayList<>(DAFTAR_KRITERIA);
    }

    public int getIdKriteria() {
        return idKriteria;
    }

    public String getNamaKriteria() {
        return namaKriteria;
    }

    public float getBobot() {
        return bobot;
    }
}
