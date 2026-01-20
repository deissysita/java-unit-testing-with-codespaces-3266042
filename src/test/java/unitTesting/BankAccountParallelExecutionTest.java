package unitTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
class BankAccountParallelExecutionTest {

    @Test
    @DisplayName("Deposit 100 into account with initial balance 0 - Test 1")
    void testDeposit1(BankAccount account) {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    @DisplayName("Deposit 200 into account with initial balance 0 - Test 2")
    void testDeposit2(BankAccount account) {
        account.deposit(200.0);
        assertEquals(200.0, account.getBalance());
    }

    @Test
    @DisplayName("Deposit 300 into account with initial balance 0 - Test 3")
    void testDeposit3(BankAccount account) {
        account.deposit(300.0);
        assertEquals(300.0, account.getBalance());
    }
}
