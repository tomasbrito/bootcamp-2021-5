package pom.grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pom.grupo4.base.TestBase;
import pom.grupo4.pages.VFAlojamientosPage;

public class atc011_modificarFechaDeIdaYVuelta extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final String URL_FINAL = "https://www.viajesfalabella.cl/checkout/";

    @Test
    public void atc011() throws InterruptedException {
        System.out.println("atc 011");
        VFAlojamientosPage alojamientosPage = new VFAlojamientosPage(driver);
        alojamientosPage.goToUrl(BASE_URL);
        alojamientosPage.goToUrl(HOTELES_URL);
        alojamientosPage.ingresarDatosDestino();
        alojamientosPage.clickearInputFecha();
        alojamientosPage.clickearFechaIdaTC012();
        alojamientosPage.clickearFechaVueltaTC012();
        alojamientosPage.clickearBotonBuscar();
        alojamientosPage.clickearBotonVerDetallePrimerHotel();
        alojamientosPage.modificarFecha();
        alojamientosPage.clickearBotonVerDetalleHotelFechaModificada();
        alojamientosPage.clickearBotonVerHabitaciones();
        //alojamientosPage.ordenarReseñasHabitaciones();
        alojamientosPage.clickearBotonReservarAhora();
        alojamientosPage.clickearBotonSiguiente();
        Assert.assertTrue(URL_FINAL, alojamientosPage.urlContiene(alojamientosPage.getUrl()));
    }
}
