package unitTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankAccountNestedTest {

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

    @Test
    @DisplayName("Withdraw not stuck at zero when minimum balance is negative")
    void testWithdrawNotStuckAtZero() {
        BankAccount account = new BankAccount(100.0, -300.0);
        double newBalance = account.withdraw(200.0);
        assertNotEquals(0.0, newBalance);
        assertNotEquals(0.0, account.getBalance());
    }

    @Test
    @DisplayName("Check if account is active")
    void testActive() {
        BankAccount account = new BankAccount(100.0, 50.0);
        boolean activeStatus = account.isActive();
        assertTrue(activeStatus);
    }

    @Test
    @DisplayName("Set and get holder name")
    void testHolderNameSetAndGet() {
        BankAccount account = new BankAccount(100.0, 50.0);
        account.setHolderName("John Doe");
        assertNotNull(account.getHolderName());
        assertEquals("John Doe", account.getHolderName());
    }

    @Test
    @DisplayName("Withdraw and deposit without exception")
    void testWithdrawAndDepositWithoutException() {
        BankAccount account = new BankAccount(100.0, 50.0);
        assertAll(()->account.deposit(50.0),
                  ()->account.withdraw(10.0));
        assertEquals(140.0, account.getBalance());
    }

    @Test
    @DisplayName("Deposit operation should complete within timeout")
    void testDepositTimeout() {
        BankAccount account = new BankAccount(100.0, 50.0);
        assertTimeout(Duration.ofNanos(10), () -> account.deposit(50));
    }

    @Nested
    class WhenBalanceEqualsZero {

        @Test
        @DisplayName("Withdraw with minimum balance as 0 should throw exception")
        void testWithdrawMinimumBalanceIs0() {
            BankAccount account = new BankAccount(0.0, 0.0);
            assertThrows(IllegalArgumentException.class, () -> {
                account.withdraw(500.0);
            });
        }

        @Test
        @DisplayName("Withdraw with negative minimum balance should allow withdrawal")
        void testWithdrawMinimumBalanceIsNegative() {
            BankAccount account = new BankAccount(0.0, -100);
            account.withdraw(50);
            assertEquals(-50.0, account.getBalance());
        }
    }
}
