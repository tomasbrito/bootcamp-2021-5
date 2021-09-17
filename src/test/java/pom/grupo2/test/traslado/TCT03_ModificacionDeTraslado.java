package pom.grupo2.test.traslado;

import org.junit.Test;
import pom.grupo2.base.TestBase;
import pom.grupo2.pages.VFHomePage;
import pom.grupo2.pages.VFTrasladoPage;

public class TCT03_ModificacionDeTraslado extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";

    @Test
    public void tct01() throws InterruptedException {
        VFHomePage homePage = new VFHomePage(driver);
        VFTrasladoPage trasladoPage = new VFTrasladoPage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irTraslado();
        trasladoPage.escribirEnOrigenYSeleccionar("Santiago");
        trasladoPage.escribirEnDestinoYSeleccionarMiramar("Sheraton");
        trasladoPage.clickEnCheck();
        trasladoPage.seleccionarFechas();
        trasladoPage.seleccionarHoras("180","180");
        trasladoPage.buscar();

        trasladoPage.verificarModificaciones();
    }
}
