package pom.grupo3.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFHomePage;
import pom.grupo3.pages.VFTrasladosPage;

public class TC_011_CheckTerminosYCondiciones extends TestBase {

    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final String DESDE = "Buenos aires";
    final String HASTA = "Mendoza";
    final String RESULTADO = "Acepta los términos y condiciones";


    @Test
    public void test011_CheckTerminosYCondiciones(){
        //una pagina
        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irATraslado();

        VFTrasladosPage trasladosPage = new VFTrasladosPage(driver);

        trasladosPage.llenarFieldDesde(DESDE);
        trasladosPage.llenarFieldHasta(HASTA);
        trasladosPage.seleccionarFechaYBuscar();
        trasladosPage.seleccionarAutoYComprar();

        Assert.assertEquals(RESULTADO, trasladosPage.confirmarCompra());


    }
}
