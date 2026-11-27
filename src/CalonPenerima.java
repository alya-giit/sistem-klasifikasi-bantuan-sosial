import java.time.LocalDateTime;

public class CalonPenerima {
    private int idCalon;
    private int idPengguna;
    private int idBantuan;
    private String nik;
    private String namaLengkap;
    private String alamat;
    private float penghasilan;
    private int tanggungan;
    private String statusPermohonan;
    private LocalDateTime tanggalBuat;

    // Relasi: diajukan oleh User dan mencakup BantuanSosial
    private User pengguna;
    private BantuanSosial bantuanSosial;

    public CalonPenerima() {
    }

    public CalonPenerima(int idCalon, int idPengguna, int idBantuan, String nik,~
                         String namaLengkap, String alamat, float penghasilan,
                         int tanggungan, String statusPermohonan, LocalDateTime tanggalBuat,
                         User pengguna, BantuanSosial bantuanSosial) {
        this.idCalon = idCalon;
        this.idPengguna = idPengguna;
        this.idBantuan = idBantuan;
        this.nik = nik;
        this.namaLengkap = namaLengkap;
        this.alamat = alamat;
        this.penghasilan = penghasilan;
        this.tanggungan = tanggungan;
        this.statusPermohonan = statusPermohonan;
        this.tanggalBuat = tanggalBuat;
        this.pengguna = pengguna;
        this.bantuanSosial = bantuanSosial;
    }

    public void ajukanPermohonan() {
        this.statusPermohonan = "Menunggu Verifikasi";
        this.tanggalBuat = LocalDateTime.now();
    }

    public String cekStatus() {
        return this.statusPermohonan;
    }

    public CalonPenerima ambilDataPenerima() {
        return this;
    }

    public int getIdCalon() {
        return idCalon;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public float getPenghasilan() {
        return penghasilan;
    }

    public int getTanggungan() {
        return tanggungan;
    }

    public BantuanSosial getBantuanSosial() {
        return bantuanSosial;
    }
}