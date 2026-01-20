package unitTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
class BankAccountDependencyInjectionTest {

    @Test
    @DisplayName("Deposit 500 into account with initial balance 0")
    void testDeposit(BankAccount account) {
        account.deposit(500.0);
        assertEquals(500.0, account.getBalance());
    }
}
