package pom.grupo4.test;

import org.junit.Test;
import pom.grupo4.base.TestBase;
import pom.grupo4.pages.VFPaquetesPage;

public class atc04_reservarPaqueteConDosAlojamientos extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String PAQUETES_URL = "https://www.viajesfalabella.cl/paquetes/";
   // @Test

    //TODO NO ANDA CAMBIAR PESTAÑAS
 /*   public void atc04() throws InterruptedException {
        System.out.println("atc04");
        VFPaquetesPage paquetesPage = new VFPaquetesPage(driver);
        paquetesPage.goToUrl(BASE_URL);
        paquetesPage.irAPaquetes();
        paquetesPage.clickearBotonDosAlojamientos();
        paquetesPage.ingresarOrigenDosAlojamientos("Puerto Montt");
        paquetesPage.ingresarDestinoDosAlojamientos("Santiago");
        paquetesPage.ingresarFechasDosAlojamientos();
        paquetesPage.ingresarFechaPrimerDestino();
        paquetesPage.ingresarSegundoDestino("Viña del Mar");
        paquetesPage.realizarBusqueda();
        paquetesPage.seleccionarVuelo();
        paquetesPage.seleccionarHotel();
        paquetesPage.reservarHotel();
    }*/
}
