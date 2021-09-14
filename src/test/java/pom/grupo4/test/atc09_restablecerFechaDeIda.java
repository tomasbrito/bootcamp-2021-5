package pom.grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo4.base.TestBase;
import pom.grupo4.pages.VFAlojamientosPage;

public class atc09_restablecerFechaDeIda extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final String valorEsperado = "26";

    @Test
    public void atc09() throws InterruptedException {
        System.out.println("atc 09");
        VFAlojamientosPage alojamientosPage = new VFAlojamientosPage(driver);
        alojamientosPage.goToUrl(BASE_URL);
        alojamientosPage.goToUrl(HOTELES_URL);
        alojamientosPage.clickearInputFecha();
        alojamientosPage.clickearFechaIdaTC009();
        alojamientosPage.clickearFechaVueltaTC009();
        Assert.assertEquals(valorEsperado, alojamientosPage.getFechaVueltaValue());






    }
}
