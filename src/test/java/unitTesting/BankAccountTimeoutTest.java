package unitTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@ExtendWith(BankAccountParameterResolver.class)
class BankAccountTimeoutTest {

    //takes the full method time to execute
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testDepositTimeoutAnnotation(BankAccount account) throws InterruptedException {
        Thread.sleep(300);
        account.deposit(1000.0);
        assertEquals(1000.0, account.getBalance());
    }

    // only the code inside assertTimeout is measured, the assertion
    @Test
    void testDepositTimeout(BankAccount account) throws InterruptedException {
        Thread.sleep(300);
        account.deposit(1000.0);
        assertEquals(1000.0, account.getBalance());
        assertTimeout(Duration.ofMillis(500), () -> {;
            Thread.sleep(100);
        });
    }
}
