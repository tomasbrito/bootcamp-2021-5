package pom.grupo3.test;

import org.junit.Test;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFHomePage;
import pom.grupo3.pages.VFTrasladosPage;

import static org.junit.Assert.assertEquals;

public class TC_009 extends TestBase {

    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String DESDE = "Buenos aires";
    final String HASTA = "Mendoza";
    final String RESULTADO = "US$";


    @Test
    public void test009(){
        System.out.println("test 012");
        //una pagina
        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irATraslado();

        VFTrasladosPage trasladosPage = new VFTrasladosPage(driver);
        trasladosPage.llenarFieldDesde(DESDE);
        trasladosPage.llenarFieldHasta(HASTA);

        trasladosPage.seleccionarFechaYBuscar();
        trasladosPage.cambiarMonedaADolares();

        assertEquals(RESULTADO, trasladosPage.obtenerMoneda());


    }
}
