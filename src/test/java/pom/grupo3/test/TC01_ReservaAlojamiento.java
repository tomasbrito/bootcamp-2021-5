package pom.grupo3.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFAlojamientoG3;

public class TC01_ReservaAlojamiento extends TestBase {

    final String DESTINO = "miami";
    final String YEAR_MONTH = "2021-10"; // aaaa-mm
    final String ENTRADA_DAY = "5";
    final String SALIDA_DAY = "20";
    final int ROOM = 2;
    final int MANYADULT = 2;
    final int MANYCHILDREN = 1;
    final String CHILDREN_AGE = "9";


    @Test
    public void atc01(){
        System.out.println("tc_01");

        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToAlojamientos();

        VFAlojamientoG3 alojamientos = new VFAlojamientoG3(driver);
        alojamientos.selectDestino(DESTINO);
        alojamientos.selectDate(YEAR_MONTH, ENTRADA_DAY, SALIDA_DAY);
        alojamientos.addRoom(ROOM);
        alojamientos.addAdult(MANYADULT);
        alojamientos.addkid(MANYCHILDREN);
        alojamientos.setAgeKid(CHILDREN_AGE, ROOM);
        alojamientos.search();

        alojamientos.selectFirstElement();
        alojamientos.seeRoom();
        int priceForNight = alojamientos.getPriceForNight();




        //Assert.assertEquals( , );
    }
}
