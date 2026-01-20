package unitTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountBeforeAfterTest {

    static BankAccount account;

    // only once before all test cases
    @BeforeAll
    static void setUp() {
        account = new BankAccount(400.0, 0);
    }

    @Test
    void testWithdraw() {
        account.withdraw(200.0);
        assertEquals(200.0, account.getBalance());
    }

    // for each test case
    @AfterEach
    void tearDown() {
        System.out.println("Done testing BankAccountBeforeAfterTest");
    }
}
