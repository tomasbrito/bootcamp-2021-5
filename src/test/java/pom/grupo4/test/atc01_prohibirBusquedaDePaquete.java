package pom.grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo4.base.TestBase;
import pom.grupo4.pages.VFPaquetesPage;

public class atc01_prohibirBusquedaDePaquete extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String PAQUETES_URL = "https://www.viajesfalabella.cl/paquetes/";
    final String entradaMsg = "Ingresa una fecha de partida.";
    final String salidaMsg = "Ingresa una fecha de regreso.";


    @Test
    public void atc01() throws InterruptedException {
        System.out.println("atc01");
        VFPaquetesPage homePage = new VFPaquetesPage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irAPaquetes();
        homePage.ingresarDatosOrigen();
        homePage.ingresarDatosDestino();
        homePage.realizarBusqueda();
        Assert.assertEquals(entradaMsg,homePage.obtenerMensajeFechaEntrada());
        Assert.assertEquals(salidaMsg,homePage.obtenerMensajeFechaSalida());

    }


}
