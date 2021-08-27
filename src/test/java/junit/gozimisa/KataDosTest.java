package junit.gozimisa;
import org.junit.Test;

import static org.junit.Assert.*;

public class KataDosTest {
    @Test
    public void exampleCases0() {
        assertEquals("hello world", KataDos.toAlternativeString("HELLO WORLD"));
    }

    @Test
    public void exampleCases1() {
        assertEquals("HELLO WORLD", KataDos.toAlternativeString("hello world"));
    }

    @Test
    public void exampleCases2() {
        assertEquals("HeLlO wOrLd", KataDos.toAlternativeString("hElLo WoRlD"));
    }

    @Test
    public void exampleCases3() {
        assertEquals("12345", KataDos.toAlternativeString("12345"));
    }

    @Test
    public void exampleCases4() {
        assertEquals("12A34b5...", KataDos.toAlternativeString("12a34B5..."));
    }
}
