package junit.gozimisa;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

// TODO: Replace examples and use TDD development by writing your own tests

public class KataUnoTest {
    @Test
    public void exampleCases0() {
        assertEquals("elbuod  secaps", KataUno.reverseWords("double  spaces"));
    }

    @Test
    public void exampleCases1() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", KataUno.reverseWords("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void exampleCases2() {
        assertEquals("elppa", KataUno.reverseWords("apple"));
    }

    @Test
    public void exampleCases3() {
        assertEquals("a b c d", KataUno.reverseWords("a b c d"));
    }

    @Test
    public void exampleCases4() {
        assertEquals("elbuod  decaps  sdrow", KataUno.reverseWords("double  spaced  words"));
    }
}