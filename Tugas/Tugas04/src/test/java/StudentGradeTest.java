import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeTest {

    private final StudentGrade studentGrade = new StudentGrade();

    @Test
    void nilaiA() {
        assertEquals("A", studentGrade.calculateGrade(80));
    }

    @Test
    void nilaiB() {
        assertEquals("B", studentGrade.calculateGrade(70));
    }

    @Test
    void nilaiC() {
        assertEquals("C", studentGrade.calculateGrade(60));
    }

    @Test
    void nilaiD() {
        assertEquals("D", studentGrade.calculateGrade(50));
    }

    @Test
    void nilaiE() {
        assertEquals("E", studentGrade.calculateGrade(40));
    }

    @Test
    void nilaiDiBawahNolDitolak() {
        assertThrows(
            IllegalArgumentException.class,
            () -> studentGrade.calculateGrade(-1)
        );
    }

    @Test
    void nilaiDiAtasSeratusDitolak() {
        assertThrows(
            IllegalArgumentException.class,
            () -> studentGrade.calculateGrade(101)
        );
    }

    @Test
    void nilai60DinyatakanLulus() {
        assertTrue(studentGrade.isPassed(60));
    }

    @Test
    void nilai59DinyatakanTidakLulus() {
        assertFalse(studentGrade.isPassed(59));
    }

    @Test
    void nilaiTidakValidDitolakSaatMemeriksaKelulusan() {
        assertThrows(
            IllegalArgumentException.class,
            () -> studentGrade.isPassed(101)
        );
    }
}