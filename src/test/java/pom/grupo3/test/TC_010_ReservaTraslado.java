package pom.grupo3.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFHomePage;
import pom.grupo3.pages.VFTrasladosPage;

public class TC_010_ReservaTraslado extends TestBase {

    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final String DESDE = "Buenos aires";
    final String HASTA = "Mendoza";


    @Test
    public void test012_ReservaTraslado(){
        System.out.println("test 012");
        //una pagina
        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irATraslado();

        VFTrasladosPage trasladosPage = new VFTrasladosPage(driver);

        trasladosPage.llenarFieldDesde(DESDE);
        trasladosPage.llenarFieldHasta(HASTA);
        trasladosPage.seleccionarFechaYBuscar();
        trasladosPage.seleccionarAutoYComprar();

        if (trasladosPage.comparar(DESDE,HASTA)){
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }


    }
}
