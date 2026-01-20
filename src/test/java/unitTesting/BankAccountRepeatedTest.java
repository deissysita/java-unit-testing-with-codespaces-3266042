package unitTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(BankAccountParameterResolver.class)
class BankAccountRepeatedTest {

    @RepeatedTest(5)
    @DisplayName("Deposit 500 into account with initial balance 0")
    void testDeposit(BankAccount account, RepetitionInfo repetitionInfo) {
        account.deposit(500.0);
        assertEquals(500.0, account.getBalance());
        System.out.println("Number:" + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(5)
    @DisplayName("Set and get holder name")
    void testHolderNameSetAndGet(BankAccount account) {
        account.setHolderName("John Doe");
        assertNotNull(account.getHolderName());
        assertEquals("John Doe", account.getHolderName());
    }
}
