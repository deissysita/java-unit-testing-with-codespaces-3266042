package unitTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class BankAccountAssumptionsTest {

    @Test
    @DisplayName("Check if account is active with assumption")
    void testActive() {
        BankAccount account = new BankAccount(100.0, 50.0);
        assumeTrue(Objects.nonNull(account), "Account should not be null");
        boolean activeStatus = account.isActive();
    }

    //if the assumption fails, the test is aborted and marked as skipped
    @Test
    @DisplayName("Check if account is active with null account")
    void testActiveIsNull() {
        BankAccount account = new BankAccount(100.0, 50.0);
        assumeTrue(Objects.isNull(account), "Account is null");
        boolean activeStatus = account.isActive();
    }

    @Test
    @DisplayName("Check if account is active with assumingThat")
    void testActiveWithAssumption() {
        BankAccount account = new BankAccount(100.0, 50.0);
        assumingThat(Objects.nonNull(account), () ->
                assumeTrue(account.isActive()));
    }
}
