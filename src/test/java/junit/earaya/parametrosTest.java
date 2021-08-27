package junit.earaya;

import org.junit.Test;

public class parametrosTest {

    @Test(expected = ArithmeticException.class )
    public void testException(){
        int numero1 = 20;
        int numero2 = 0;
        int divCero = numero1/numero2;
    }

    @Test(timeout = 1000)
    public void testconTiempoLimite(){
        try {
            Thread.sleep(800);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
