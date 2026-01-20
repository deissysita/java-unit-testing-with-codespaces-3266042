package unitTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
class BankAccountParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Deposit various amounts into account with initial balance 0")
    void testDeposit(int amount, BankAccount account) {
        account.deposit(amount);
        assertEquals(amount, account.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
            "100.0, Alice",
            "250.5, Bob",
            "300.75, Charlie"
    })
    @DisplayName("Deposit amount and set holder name")
    void testDepositAndName(double amount, String name, BankAccount account) {
    account.deposit(amount);
    account.setHolderName(name);
    assertEquals(amount, account.getBalance());
    assertEquals(name, account.getHolderName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/details.csv")
    @DisplayName("Deposit amount and set holder name from file")
    void testDepositAndNameFromFile(double amount, String name, BankAccount account) {
        account.deposit(amount);
        account.setHolderName(name);
        assertEquals(amount, account.getBalance());
        assertEquals(name, account.getHolderName());
    }
}
