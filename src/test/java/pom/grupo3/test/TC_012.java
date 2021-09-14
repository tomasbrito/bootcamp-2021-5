package pom.grupo3.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFHomePage;

public class TC_012 extends TestBase {

    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final String DESDE = "Buenos aires";
    final String HASTA = "Mendoza";
    final String RESULTADO = "Salida desde el punto que elegiste:";


    @Test
    public void test012(){
        System.out.println("test 012");
        //una pagina
        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irATraslado();
        homePage.llenarFieldDesde(DESDE);
        homePage.llenarFieldHasta(HASTA);
        homePage.clickCheckbox();
        homePage.seleccionarFechasYBuscar();
        homePage.validar(RESULTADO);


    }
}
