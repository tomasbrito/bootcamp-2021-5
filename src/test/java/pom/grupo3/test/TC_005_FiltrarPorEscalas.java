package pom.grupo3.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFHomePage;
import pom.grupo3.pages.VFPaquetesPage;

public class TC_005_FiltrarPorEscalas extends TestBase {

    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String DESDE = "Buenos aires";
    final String HASTA = "miami";


    @Test
    public void test005() {
        System.out.println("tc-005: Filtrar por escalas");
        //una pagina
        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irAPaquetes();

        VFPaquetesPage paquetesPage = new VFPaquetesPage(driver);
        paquetesPage.llenarFieldDesde(DESDE);
        paquetesPage.llenarFieldHasta(HASTA);
        paquetesPage.seleccionarFechasYBuscar();

        String escalaPaquete = paquetesPage.elegirHotelYFiltrar();
        String cantEscala = "Directo";
        Assert.assertEquals(cantEscala, escalaPaquete);


    }
}
