package junit.lkelly;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class KataZooTest {

    @Test
    public void example() {
        final String input = "fox,bug,chicken,grass,sheep";
        final String[] expected = 	{
                "fox,bug,chicken,grass,sheep",
                "chicken eats bug",
                "fox eats chicken",
                "sheep eats grass",
                "fox eats sheep",
                "fox"};
        assertArrayEquals(expected, KataZoo.whoEatsWho(input));
    }
    @Test
    public void example2() {
        final String input = "cow,bear,bicycle";
        final String[] expected = 	{
                "cow,bear,bicycle",
                "bear eats cow",
                "bear,bicycle"};
        assertArrayEquals(expected, KataZoo.whoEatsWho(input));
    }
    @Test
    public void example3() {
        final String input = "sheep,antelope,bug";
        final String[] expected = 	{
                "sheep,antelope,bug"};
        assertArrayEquals(expected, KataZoo.whoEatsWho(input));
    }

    @Test
    public void example4() {
        final String input = "big-fish,chicken,antelope,bug,bear";
        final String[] expected = 	{
                        "big-fish,chicken,antelope,bug,bear",
                        "bear eats bug" ,
                        "big-fish,chicken,antelope,bear"};
        assertArrayEquals(expected, KataZoo.whoEatsWho(input));
    }


}