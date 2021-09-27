package pruebaTbrito.test;

import org.junit.Assert;
import org.junit.Test;
import pruebaTbrito.Pages.MLHomePage;
import pruebaTbrito.base.TestBase;

public class TC_003_CalcularEnvioPorCP extends TestBase {

    //variables
    final String BASE_URL = "https://www.mercadolibre.com.ar/";
    final String CP = "1416";
    final String textoABuscar = "Metegol libro";

    @Test
    public void test01(){
        MLHomePage home = new MLHomePage(driver);
        home.goToUrl(BASE_URL);
        home.cambiarCP(CP);
        home.realizarBusqueda(textoABuscar);
        home.abrirPublicacion();



        if(home.obtenerCPactual().contains(CP)){
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }
}
