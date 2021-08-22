package junit.ebalcaldi;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Kata1Test {


    // TODO: Replace examples and use TDD development by writing your own tests
    @Test
    public void test1() {
        assertEquals("aloh 321", Kata1.reverseWords("hola 123"));

    }
    @Test public void test2(){
        assertEquals("elppa", Kata1.reverseWords("apple"));

    }
    @Test public void test3(){
        assertEquals("a b c d", Kata1.reverseWords("a b c d"));
    }
    @Test public void test4(){
        assertEquals("elbuod  decaps  sdrow", Kata1.reverseWords("double  spaced  words"));
    }
}

