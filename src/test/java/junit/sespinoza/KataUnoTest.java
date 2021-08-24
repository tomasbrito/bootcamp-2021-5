package junit.sespinoza;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class KataUnoTest {
    @Test
    public void test0(){assertEquals("   ",KataUno.reverseWords("   "));}

    @Test
    public void test1() {
        assertEquals("The quick brown fox jumps over the lazy dog.", KataUno.reverseWords("ehT kciuq nworb xof spmuj revo eht yzal .god"));
    }

    @Test
    public void test2() {
        assertEquals("apple", KataUno.reverseWords("elppa"));
    }

    @Test
    public void test3() {
        assertEquals("a b c d", KataUno.reverseWords("a b c d"));
    }

    @Test
    public void test4() {
        assertEquals("double  spaced  words", KataUno.reverseWords("elbuod  decaps  sdrow"));
    }

    @Test
    public void test5(){assertEquals("Fras1e co2n nume3ros", KataUno.reverseWords("e1sarF n2oc sor3emun"));}

    @Test
    public void test6(){assertEquals("",KataUno.reverseWords(""));}
}