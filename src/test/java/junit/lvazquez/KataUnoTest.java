package junit.lvazquez;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD development by writing your own tests

public class KataUnoTest {
    @Test
    public void doubleSpacedWords() {
        assertEquals("elbuod  decaps  sdrow", KataUno.reverseWords("double  spaced  words"));
    }

    @Test
    public void longString() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", KataUno.reverseWords("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void singleWord(){
        assertEquals("elppa", KataUno.reverseWords("apple"));
    }

    @Test
    public void spaceBetween(){
        assertEquals("a b c d", KataUno.reverseWords("a b c d"));
    }

    @Test
    public void allSpaces(){
        assertEquals("   ", KataUno.reverseWords("   "));
    }
}
