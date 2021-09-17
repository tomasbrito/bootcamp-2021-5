package pom.grupo3.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFHomePage;
import pom.grupo3.pages.VFPaquetesPage;

public class TC_006_FiltrarPorEstrellas extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String DESDE = "Buenos aires";
    final String HASTA = "Mendoza";
    final String RESULTADO = "El alojamiento ofrece";
    final int cantEstrellas = 5;

    @Test
    public void test006(){
        System.out.println("tc-006: Filtrar por estrellas");
        //una pagina
        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irAPaquetes();

        VFPaquetesPage paquetesPage = new VFPaquetesPage(driver);
        paquetesPage.llenarFieldDesde(DESDE);
        paquetesPage.llenarFieldHasta(HASTA);
        paquetesPage.seleccionarFechasYBuscar();

        paquetesPage.filtrarPorEstrellas();
        if(cantEstrellas == 5)
            Assert.assertEquals(cantEstrellas, paquetesPage.CantEstrellasLista());
        else //si es 4 estrellas
        {
            if (paquetesPage.CantEstrellasLista()==5){
                Assert.fail();
            } else {
                Assert.assertTrue(true);
            }
        }





    }
}
