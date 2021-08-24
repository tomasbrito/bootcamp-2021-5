package junit.imiguez;

import org.junit.Test;

import static junit.imiguez.KataTres.nbMonths;
import static org.junit.Assert.assertArrayEquals;

public class KataTresTest {

    int[] expected = new int [2];


    @Test
    public void KataTresTest1() {
        this.expected[0] = 6;
        this.expected[1] = 766;
        assertArrayEquals(expected, nbMonths(2000, 8000, 1000, 1.5));
    }

    @Test
    public void KataTresTest2() {
        this.expected[0] = 0;
        this.expected[1] = 4000;
        assertArrayEquals(expected, nbMonths(12000, 8000, 1000, 1.5));
    }

    @Test
    public void KataTresTest3() {
        this.expected[0] = 0;
        this.expected[1] = 0;
        assertArrayEquals(expected, nbMonths(8000, 8000, 1000, 1.5));
    }

}
