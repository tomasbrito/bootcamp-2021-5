package pom.grupo3.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFHomePage;
import pom.grupo3.pages.VFPaquetesPage;

import static org.junit.Assert.assertEquals;

public class tc_008 extends TestBase {

    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String DESDE = "Buenos aires";
    final String HASTA = "Mendoza";
    final String RESULTADO = "El alojamiento ofrece";


    @Test
    public void test008(){
        System.out.println("test 012");
        //una pagina
        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irAPaquetes();

        VFPaquetesPage paquetesPage = new VFPaquetesPage(driver);
        paquetesPage.llenarFieldDesde(DESDE);
        paquetesPage.llenarFieldHasta(HASTA);
        paquetesPage.seleccionarFechasYBuscar();
        paquetesPage.elegirHotelYMostrarDetalle();

        Assert.assertEquals(RESULTADO, paquetesPage.obtenerTextoVentanaDetalle());




    }
}
