package junit.gozimisa;
import static org.junit.Assert.*;
import org.junit.Test;

public class KataSieteTest {
    @Test
    public void Test1() {
        assertEquals(1, KataSiete.digPow(89, 1));
    }
    @Test
    public void Test2() {
        assertEquals(-1, KataSiete.digPow(92, 1));
    }
    @Test
    public void Test3() {
        assertEquals(51, KataSiete.digPow(46288, 3));
    }
}
