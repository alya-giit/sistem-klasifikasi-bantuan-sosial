import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDateTime sekarang = LocalDateTime.now();

        // 1. Buat User & login
        User user = new User(1, "3275010101010001", "Budi Santoso",
                "budi@example.com", "123456", "Petugas", "081234567890",
                sekarang, sekarang);
        boolean loginBerhasil = user.login("budi@example.com", "123456");
        System.out.println("Login berhasil: " + loginBerhasil);

        // 2. Buat jenis bantuan & kriteria
        BantuanSosial bansos = new BantuanSosial(1, "Bantuan Tunai",
                "Bantuan sosial berbasis kelayakan ekonomi", sekarang, sekarang);
        bansos.tambahBantuan();

        Kriteria k1 = new Kriteria(1, "Penghasilan", 0.6f, sekarang, sekarang);
        Kriteria k2 = new Kriteria(2, "Tanggungan", 0.4f, sekarang, sekarang);
        k1.tambahKriteria();
        k2.tambahKriteria();
        List<Kriteria> daftarKriteria = k1.ambilSemua();

        // 3. Buat calon penerima & ajukan permohonan
        CalonPenerima calon = new CalonPenerima(1, 1, 1, "3275010202020002",
                "Siti Aminah", "Jl. Jatiasih No. 10", 1500000f, 3,
                "Baru", sekarang, user, bansos);
        calon.ajukanPermohonan();
        System.out.println("Status permohonan: " + calon.cekStatus());

        // 4. Hitung klasifikasi & cetak laporan
        HasilKlasifikasi hasil = new HasilKlasifikasi(1, calon.getIdCalon(), calon, daftarKriteria);
        hasil.hitungNaiveBayes();
        hasil.berikanPersetujuan();
        hasil.simpanHasil();
        hasil.cetakLaporan();
    }
}