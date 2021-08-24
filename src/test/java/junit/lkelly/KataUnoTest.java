package junit.lkelly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD development by writing your own tests

public class KataUnoTest {
    @Test
    public void test1() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", KataUno.reverseWords("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void test2() {
        assertEquals("elppa", KataUno.reverseWords("apple"));
    }

    @Test
    public void test3() {
        assertEquals("a b c d", KataUno.reverseWords("a b c d"));
    }

    @Test
    public void test4() {
        assertEquals("elbuod  decaps  sdrow", KataUno.reverseWords("double  spaced  words"));
    }

}
