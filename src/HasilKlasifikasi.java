import java.time.LocalDateTime;
import java.util.List;

public class HasilKlasifikasi {
    private int idKlasifikasi;
    private int idCalon;
    private float nilaiProbabilitas;
    private String statusKelayakan;
    private String statusPersetujuan;
    private LocalDateTime tanggalBuat;

    // Relasi: dihasilkan dari 1 CalonPenerima dan menggunakan Kriteria
    private CalonPenerima calonPenerima;
    private List<Kriteria> daftarKriteria;

    public HasilKlasifikasi() {
    }

    public HasilKlasifikasi(int idKlasifikasi, int idCalon, CalonPenerima calonPenerima,
                           List<Kriteria> daftarKriteria) {
        this.idKlasifikasi = idKlasifikasi;
        this.idCalon = idCalon;
        this.calonPenerima = calonPenerima;
        this.daftarKriteria = daftarKriteria;
        this.tanggalBuat = LocalDateTime.now();
    }

    public float hitungNaiveBayes() {
        float skor = 0.0f;
        float totalBobot = 0.0f;

        if (daftarKriteria != null && !daftarKriteria.isEmpty() && calonPenerima != null) {
            for (Kriteria kriteria : daftarKriteria) {
                totalBobot += kriteria.getBobot();
                // Contoh perhitungan kontribusi fitur berdasarkan penghasilan & tanggungan
                float faktorPendukung = Math.max(0.0f,
                        1.0f - (calonPenerima.getPenghasilan() / 10000000.0f))
                        + (calonPenerima.getTanggungan() * 0.1f);
                skor += kriteria.getBobot() * Math.min(1.0f, faktorPendukung);
            }
        }

        this.nilaiProbabilitas = totalBobot > 0 ? (skor / totalBobot) : 0.0f;
        this.statusKelayakan = this.nilaiProbabilitas >= 0.5f ? "Layak" : "Tidak Layak";
        return this.nilaiProbabilitas;
    }

    public boolean simpanHasil() {
        this.tanggalBuat = LocalDateTime.now();
        return true;
    }

    public void cetakLaporan() {
        System.out.println("=== LAPORAN HASIL KLASIFIKASI ===");
        System.out.println("ID Klasifikasi   : " + idKlasifikasi);
        System.out.println("ID Calon         : " + idCalon);
        System.out.println("Nilai Probabilitas: " + nilaiProbabilitas);
        System.out.println("Status Kelayakan : " + statusKelayakan);
        System.out.println("Status Persetujuan: " + statusPersetujuan);
    }

    public boolean berikanPersetujuan() {
        this.statusPersetujuan = "Disetujui";
        return true;
    }

    public float getNilaiProbabilitas() {
        return nilaiProbabilitas;
    }

    public String getStatusKelayakan() {
        return statusKelayakan;
    }
}