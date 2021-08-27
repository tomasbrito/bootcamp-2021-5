package junit.gozimisa;
import org.junit.Test;

import static junit.gozimisa.KataTres.*;
import static org.junit.Assert.assertArrayEquals;

public class KataTresTest {
    @Test
    public void test1() {
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void test2() {
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, nbMonths(12000, 8000, 1000, 1.5));
    }

}
