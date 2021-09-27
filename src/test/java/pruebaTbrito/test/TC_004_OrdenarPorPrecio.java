package pruebaTbrito.test;

import org.junit.Assert;
import org.junit.Test;
import pruebaTbrito.Pages.MLHomePage;
import pruebaTbrito.base.TestBase;

public class TC_004_OrdenarPorPrecio extends TestBase {

    //variables
    final String BASE_URL = "https://www.mercadolibre.com.ar/";
    final String PRECIO = "12000";
    final String textoABuscar = "notebook";

    @Test
    public void test01(){
        MLHomePage home = new MLHomePage(driver);
        home.goToUrl(BASE_URL);
        home.realizarBusqueda(textoABuscar);
        home.ordenar();

        if (home.compararPrecios()){
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }
}
