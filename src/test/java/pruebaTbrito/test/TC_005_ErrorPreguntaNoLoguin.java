package pruebaTbrito.test;

import org.junit.Assert;
import org.junit.Test;
import pruebaTbrito.Pages.MLHomePage;
import pruebaTbrito.base.TestBase;

public class TC_005_ErrorPreguntaNoLoguin extends TestBase {

    //variables
    final String BASE_URL = "https://www.mercadolibre.com.ar/";
    final String textoABuscar = "notebook";
    final String textoPregunta = "11111";

    @Test
    public void test004(){
        MLHomePage home = new MLHomePage(driver);
        home.goToUrl(BASE_URL);
        home.realizarBusqueda(textoABuscar);
        home.abrirPublicacion();
        home.realizarPregunta(textoPregunta);

        System.out.println(home.urlActual());
        if (home.urlActual().contains("login")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }
}
