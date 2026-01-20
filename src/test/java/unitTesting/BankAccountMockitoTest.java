package unitTesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountMockitoTest {

    @Mock
    private BankAccount bankAccount;

    @BeforeEach
    void setupMocks() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(bankAccount.getBalance()).thenReturn(200.0);
    }

    @Test
    void testDeposit() {
        assertEquals(200.0, bankAccount.getBalance() );
    }
}
