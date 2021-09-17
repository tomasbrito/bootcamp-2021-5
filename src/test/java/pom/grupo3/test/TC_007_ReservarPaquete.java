package pom.grupo3.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFHomePage;
import pom.grupo3.pages.VFPaquetesPage;

public class TC_007_ReservarPaquete extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String DESDE = "Buenos aires";
    final String HASTA = "Mendoza";
    final String NOCHES = "1";


    @Test

    public void test007(){
        System.out.println("tc-007: Reservar paquete");

        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irAPaquetes();

        VFPaquetesPage paquetesPage = new VFPaquetesPage(driver);
        paquetesPage.llenarFieldDesde(DESDE);
        paquetesPage.llenarFieldHasta(HASTA);
        paquetesPage.seleccionarFechasYBuscar();
        paquetesPage.elegirHotel();
        paquetesPage.aceptarHabitacionYVuelo();
        if (paquetesPage.comparar(DESDE,HASTA,NOCHES)){
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }





    }
}
