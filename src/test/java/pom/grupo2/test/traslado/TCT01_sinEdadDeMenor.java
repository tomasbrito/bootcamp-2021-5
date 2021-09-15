package pom.grupo2.test.traslado;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo2.base.TestBase;
import pom.grupo2.pages.VFHomePage;
import pom.grupo2.pages.VFTrasladoPage;

public class TCT01_sinEdadDeMenor extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String cuadroMsg ="Ingresa la edad del menor";

    @Test
    public void tct01() throws InterruptedException {
        VFHomePage homePage = new VFHomePage(driver);
        VFTrasladoPage trasladoPage = new VFTrasladoPage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irTraslado();
        trasladoPage.agregarMenorEnPasajeros();
        trasladoPage.buscar();

        trasladoPage.validacionMensajeEdadDeMenor(cuadroMsg);
    }
}
