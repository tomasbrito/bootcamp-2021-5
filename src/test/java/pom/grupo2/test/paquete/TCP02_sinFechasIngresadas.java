package pom.grupo2.test.paquete;

import org.junit.Test;
import pom.grupo2.base.TestBase;
import pom.grupo2.pages.VFHomePage;

public class TCP02_sinFechasIngresadas extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String fechaPartidaMsg = "Ingresa una fecha de partida.";
    final String fechaRegresoMsg = "Ingresa una fecha de regreso.";

    @Test
    public void tcp02() {
        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irVueloAuto();
        homePage.escribirEnOrigenYSeleccionar("cordoba");
        homePage.escribirEnDestinoYSeleccionar("rosario");
        homePage.buscar();

        homePage.validacionMensajFechas(fechaPartidaMsg,fechaRegresoMsg);
    }
}