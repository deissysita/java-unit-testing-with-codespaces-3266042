package unitTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Tests for BankAccount class")
class BankAccountTest {

    @Test
    @DisplayName("Withdraw below minimum balance should throw exception")
    void testWithdrawBelowMinimumBalance() {
        BankAccount account = new BankAccount(100.0, 50.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(60.0);
        });
        assertEquals("Withdrawal would breach minimum balance", exception.getMessage());
    }

    @Test
    @DisplayName("Successful withdraw should update balance correctly")
    void testSuccessfulWithdraw() {
        BankAccount account = new BankAccount(100.0, 50.0);
        double newBalance = account.withdraw(30.0);
        assertEquals(70.0, newBalance);
        assertEquals(70.0, account.getBalance());
    }

    @Test
    @DisplayName("Deposit should update balance correctly")
    void testDeposit() {
        BankAccount account = new BankAccount(100.0, 50.0);
        double newBalance = account.deposit(50.0);
        assertEquals(150.0, newBalance);
        assertEquals(150.0, account.getBalance());
    }
}