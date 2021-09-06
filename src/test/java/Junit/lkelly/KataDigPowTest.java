package junit.lkelly;

import static org.junit.Assert.*;
import org.junit.Test;

public class KataDigPowTest {

    @Test
    public void Test1() {
        assertEquals(1, KataDigPow.digPow(89, 1));
    }

    @Test
    public void Test2() {
        assertEquals(-1, KataDigPow.digPow(92, 1));
    }

    @Test
    public void Test3() {
        assertEquals(51, KataDigPow.digPow(46288, 3));
    }

}


