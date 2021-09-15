package pom.grupo2.test;

import org.junit.Test;
import pom.grupo2.base.TestBase;
import pom.grupo2.pages.VFHomePage;

public class TCP03_modificacionTraslado extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String destinoMsg = "El destino debe ser diferente del origen.";
    @Test
    public void tcp03(){
        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irVuelo2Alojamientos();
        homePage.escribirEnOrigenYSeleccionar("Chile");
        homePage.escribirEnDestinoYSeleccionar("Chile");
        homePage.seleccionarFechas();
        homePage.escribirEnDestino2YSeleccionar("Chile");
        homePage.selecionarFechaIntermedia();
        homePage.buscar();
        homePage.validacionMensajeDestino(destinoMsg);
    }
}
