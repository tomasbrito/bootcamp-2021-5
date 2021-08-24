package junit.gozimisa;
import org.junit.Test;
import static org.junit.Assert.*;

public class KataCincoTest {
    @Test
    public void test() {
        assertArrayEquals(new int[]{8, 8, 9, 9, 10, 10}, KataCinco.sort(new int[]{8, 8, 9, 9, 10, 10}));
        assertArrayEquals(new int[]{4, 1, 3, 2}, KataCinco.sort(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{9, 999, 99}, KataCinco.sort(new int[]{9, 99, 999}));
    }
}
