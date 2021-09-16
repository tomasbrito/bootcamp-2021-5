package pom.grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo4.base.TestBase;
import pom.grupo4.pages.VFAlojamientosPage;

public class atc010_reservarAlojamiento extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles";
    final String URL_FINAL = "https://www.viajesfalabella.cl/checkout/";

    @Test
    public void atc010() throws InterruptedException {
        System.out.println("atc 010");
        VFAlojamientosPage alojamientosPage = new VFAlojamientosPage(driver);
        alojamientosPage.goToUrl(BASE_URL);
        alojamientosPage.goToUrl(HOTELES_URL);
        Assert.assertEquals(HOTELES_URL, alojamientosPage.getUrl());
        alojamientosPage.ingresarDatosDestino();
        alojamientosPage.clickearInputFecha();
        alojamientosPage.clickearFechaIdaTC012();
        alojamientosPage.clickearFechaVueltaTC012();
        alojamientosPage.clickearBotonHabitaciones();
        alojamientosPage.clickearBotonAñadirAdulto();
        alojamientosPage.clickearBotonAñadirMenor();
        alojamientosPage.clickearBotonBuscar();
        alojamientosPage.clickearBotonVerDetallePrimerHotel();
        alojamientosPage.clickearBotonVerHabitaciones();
        alojamientosPage.clickearBotonReservarAhora();
        alojamientosPage.clickearBotonSiguiente();
        Assert.assertTrue(URL_FINAL, alojamientosPage.urlContiene(alojamientosPage.getUrl()));
    }
}
