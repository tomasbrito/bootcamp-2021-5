package junit.lvazquez;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataCincoTest {
    @Test
    public void test1() {
        assertEquals("Lew", KataCinco.declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Lew"));
    }

    @Test
    public void test2() {
        assertEquals("Harry", KataCinco.declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Harry"));
    }

    @Test
    public void test3() {
        assertEquals("Harald", KataCinco.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));

    }

    @Test
    public void test4() {
        assertEquals("Harald", KataCinco.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
    }

    @Test
    public void test5() {
        assertEquals("Harald", KataCinco.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
    }

    @Test
    public void test6() {
        assertEquals("Harald", KataCinco.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }
}