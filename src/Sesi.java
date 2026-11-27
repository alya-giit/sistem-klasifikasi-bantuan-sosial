import java.time.LocalDateTime;

public class Sesi {
    private int idSesi;
    private int idPengguna;
    private String token;
    private LocalDateTime waktuMasuk;
    private LocalDateTime waktuKedaluwarsa;

    // Relasi ke pemilik sesi
    private User pengguna;

    public Sesi(int idSesi, int idPengguna, String token,
                LocalDateTime waktuMasuk, LocalDateTime waktuKedaluwarsa, User pengguna) {
        this.idSesi = idSesi;
        this.idPengguna = idPengguna;
        this.token = token;
        this.waktuMasuk = waktuMasuk;
        this.waktuKedaluwarsa = waktuKedaluwarsa;
        this.pengguna = pengguna;
    }

    public void logout() {
        this.waktuKedaluwarsa = LocalDateTime.now();
        this.token = null;
    }

    public int getIdSesi() {
        return idSesi;
    }

    public String getToken() {
        return token;
    }

    public User getPengguna() {
        return pengguna;
    }
}