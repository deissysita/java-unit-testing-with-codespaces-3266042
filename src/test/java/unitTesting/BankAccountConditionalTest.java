package unitTesting;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class BankAccountConditionalTest {

    @Test
    @EnabledOnOs({OS.MAC})
    void testMac() {}

    @Test
    @EnabledOnOs({OS.WINDOWS})
    void testWindows() {}

    @Test
    @EnabledOnJre({JRE.JAVA_17})
    void testJRE17() {}

    @Test
    @DisabledOnJre({JRE.JAVA_17})
    void testNoJRE17() {}

    @Test
    @Disabled("Disabled until bug #123 is fixed")
    void tesDisabled() {}
}
