package pom.grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pom.grupo4.base.TestBase;
import pom.grupo4.pages.VFAlojamientosPage;

public class atc012_filtrarAlquileresVacacionales extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final String valorEsperado = "26";

    @Test
    public void atc012() throws InterruptedException {
        System.out.println("atc 012");
        VFAlojamientosPage alojamientosPage = new VFAlojamientosPage(driver);
        alojamientosPage.goToUrl(BASE_URL);
        alojamientosPage.goToUrl(HOTELES_URL);
        alojamientosPage.ingresarDatosDestino();
        alojamientosPage.clickearInputFecha();
        alojamientosPage.clickearFechaIdaTC012();
        alojamientosPage.clickearFechaVueltaTC012();
        alojamientosPage.clickearBotonHabitaciones();
        alojamientosPage.clickearAñadirHabitacion();
        alojamientosPage.clickearBotonAplicar();
        alojamientosPage.clickearBotonBuscar();
        alojamientosPage.clickearBotonAlquileresVacacionales();

        for(WebElement we: alojamientosPage.getListaResultados()){
            Assert.assertEquals("Alquiler vacacional", we.getText());
        }






    }
}
