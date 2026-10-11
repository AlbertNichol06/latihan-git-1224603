import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PendaftaranTest {

    private final Pendaftaran pendaftaran = new Pendaftaran();

    @Test
    void namaKosong() {
        assertEquals(
            "Nama harus diisi",
            pendaftaran.validasiPendaftaran(
                "", 20, "gilbert@email.com", true
            )
        );
    }

    @Test
    void umurDiBawah17() {
        assertEquals(
            "Umur minimal 17 tahun",
            pendaftaran.validasiPendaftaran(
                "Gilbert", 16, "gilbert@email.com", true
            )
        );
    }

    @Test
    void emailTidakValid() {
        assertEquals(
            "Email tidak valid",
            pendaftaran.validasiPendaftaran(
                "Gilbert", 20, "gibertemail.com", true
            )
        );
    }

    @Test
    void belumSetujuSyarat() {
        assertEquals(
            "Harus menyetujui syarat dan ketentuan",
            pendaftaran.validasiPendaftaran(
                "Gilbert", 20, "gilbert@email.com", false
            )
        );
    }

    @Test
    void pendaftaranBerhasil() {
        assertEquals(
            "Pendaftaran berhasil",
            pendaftaran.validasiPendaftaran(
                "Gilbert", 20, "gilbert@email.com", true
            )
        );
    }
}