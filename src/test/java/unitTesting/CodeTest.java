package unitTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CodeTest {

    @Test
    void testSayHello() {
        Code code = new Code();
        Assertions.assertEquals("Hello, World!", code.sayHello());
    }

}