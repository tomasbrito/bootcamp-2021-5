package pom.grupo2.test.alojamiento;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo2.pages.VFAlojamientoPage;
import pom.grupo2.pages.VFHomePage;
import pom.grupo2.base.TestBase;


public class TCA01_sugerenciaNoDisponible extends TestBase {

    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String ventanaMsg = "Ingresa al menos 3 letras, y aguarda los resultados";

    @Test
    public void tca01() throws InterruptedException {
    VFHomePage homePage = new VFHomePage(driver);
    VFAlojamientoPage alojamientoPage= new VFAlojamientoPage(driver);
    homePage.goToUrl(BASE_URL);
    homePage.irAlojamiento();
    alojamientoPage.escribirEnOrigen("la");
    Assert.assertEquals(ventanaMsg, alojamientoPage.obtenerMensajeListaSugeridaOrigen());
    }
}
