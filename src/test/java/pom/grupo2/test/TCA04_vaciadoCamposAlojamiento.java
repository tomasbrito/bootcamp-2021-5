package pom.grupo2.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo2.base.TestBase;
import pom.grupo2.pages.VFAlojamientoPage;
import pom.grupo2.pages.VFHomePage;

public class TCA04_vaciadoCamposAlojamiento extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String formularioMsg = "";

    @Test
    public void tca04() throws InterruptedException {
        VFHomePage homePage = new VFHomePage(driver);
        VFAlojamientoPage alojamientoPage= new VFAlojamientoPage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irAlojamiento();
        alojamientoPage.escribirEnOrigenYSeleccionar("San Martin de los Andes");
        alojamientoPage.seleccionarFechas();
        alojamientoPage.modificarPersonas();
        alojamientoPage.selectEdadMenor("11");
        alojamientoPage.buscar();
        alojamientoPage.navegadorBack();

        Assert.assertEquals(formularioMsg, alojamientoPage.obtenerOrigen());
        Assert.assertEquals(formularioMsg, alojamientoPage.obtenerFechaEntrada());
        Assert.assertEquals(formularioMsg, alojamientoPage.obtenerFechaSalida());
    }
}
