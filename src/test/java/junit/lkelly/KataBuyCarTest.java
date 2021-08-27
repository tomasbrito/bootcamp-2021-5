package junit.lkelly;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class KataBuyCarTest {
    @Test
    public void test1() {
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, KataBuyCar.nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void test2() {
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, KataBuyCar.nbMonths(12000, 8000, 1000, 1.5));
    }

    @Test
    public void test3() {
        int[] r = new int[] { 0, 0 };
        assertArrayEquals(r, KataBuyCar.nbMonths(8000, 8000, 1000, 1.5));
    }




}
