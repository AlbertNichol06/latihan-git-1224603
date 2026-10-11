import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void saldoAwalNol() {
        BankAccount account = new BankAccount();

        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void depositMenambahSaldo() {
        BankAccount account = new BankAccount();

        account.deposit(100000);

        assertEquals(100000, account.getBalance(), 0.001);
    }

    @Test
    void depositNolTidakMengubahSaldo() {
        BankAccount account = new BankAccount();

        account.deposit(0);

        assertEquals(0, account.getBalance(), 0.001);
    }

    @Test
    void depositNegatifDitolak() {
        BankAccount account = new BankAccount();

        assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(-1000)
        );
    }

    @Test
    void withdrawMengurangiSaldo() {
        BankAccount account = new BankAccount();
        account.deposit(100000);

        account.withdraw(30000);

        assertEquals(70000, account.getBalance(), 0.001);
    }

    @Test
    void withdrawMelebihiSaldoDitolak() {
        BankAccount account = new BankAccount();
        account.deposit(50000);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(60000)
        );

        assertEquals(50000, account.getBalance(), 0.001);
    }

    @Test
    void withdrawNegatifDitolak() {
        BankAccount account = new BankAccount();
        account.deposit(50000);

        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(-1000)
        );
    }

    @Test
    void withdrawSeluruhSaldoDiperbolehkan() {
        BankAccount account = new BankAccount();
        account.deposit(50000);

        account.withdraw(50000);

        assertEquals(0, account.getBalance(), 0.001);
    }
}