package junit.imiguez;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class KataUnoTest {


// TODO: Replace examples and use TDD development by writing your own tests

    @Test
    public void KataUnoTest1() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", KataUno.reverseWords("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void KataUnoTest2() {
        assertEquals("elppa", KataUno.reverseWords("apple"));
    }

    @Test
    public void KataUnoTest3() {
        assertEquals("a b c d", KataUno.reverseWords("a b c d"));
    }

    @Test
    public void KataUnoTest4() {
        assertEquals("elbuod  decaps  sdrow", KataUno.reverseWords("double  spaced  words"));
    }

    @Test
    public void KataUnoTest5() {
        assertEquals("", KataUno.reverseWords(""));
    }

    @Test
    public void KataUnoTest6() {
        assertEquals(" ", KataUno.reverseWords(" "));
    }

    @Test
    public void KataUnoTest7() {
        assertEquals(" 1  2   3 ", KataUno.reverseWords(" 1  2   3 "));
    }
}
