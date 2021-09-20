package pom.grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo4.base.TestBase;
import pom.grupo4.pages.VFPaquetesPage;

public class atc03_reservarPaqueteConAlojamientoEnOtraCiudad extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String PAQUETES_URL = "https://www.viajesfalabella.cl/paquetes/";
   @Test
    public void atc03() throws InterruptedException {
        System.out.println("atc03");
        VFPaquetesPage paquetesPage = new VFPaquetesPage(driver);
        paquetesPage.goToUrl(BASE_URL);
        paquetesPage.irAPaquetes();
        paquetesPage.ingresarDatosOrigen("Puerto Montt");
        paquetesPage.ingresarDatosDestino("Santiago");
        paquetesPage.ingresarFechas();
        paquetesPage.clickearBotonOpcionesAvanzadas();
        paquetesPage.ingresarAlojamientoEnOtraCiudad("Viña del mar");
        paquetesPage.realizarBusqueda();
        paquetesPage.seleccionarHotel();
        paquetesPage.reservarHotel();
        paquetesPage.seleccionarVuelo();
        paquetesPage.clickearBotonVerViaje();
    }
}
