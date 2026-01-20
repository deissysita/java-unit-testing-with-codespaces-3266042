package unitTesting;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BankAccountOrderedExecutionTest {

    static BankAccount account = new BankAccount(0, 0);

    @Test
    @Order(2)
    void testWithdraw() {
        account.withdraw(300.0);
        assertEquals(200.0,  account.getBalance());
    }

    @Test
    @Order(1)
    void testDeposit() {
        account.deposit(500.0);
        assertEquals(500.0, account.getBalance());
    }
}
