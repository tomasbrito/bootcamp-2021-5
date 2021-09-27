package pruebaTbrito.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo3.pages.VFAlojamientoG3;
import pruebaTbrito.Pages.MLHomePage;
import pruebaTbrito.base.TestBase;

import static org.junit.Assert.assertEquals;

public class TC_002_HistorialPublicacionesVistas extends TestBase {

    //variables
    final String BASE_URL = "https://www.mercadolibre.com.ar/";
    final String textoABuscar = "notebook";

    @Test
    public void test01(){
        MLHomePage home = new MLHomePage(driver);
        home.goToUrl(BASE_URL);
        home.realizarBusqueda(textoABuscar);
        String publicacion = home.abrirPublicacionYObtenerTexto();
        String publicacionHistorial = home.primerPublicacionHistorial();

        Assert.assertEquals(publicacion, publicacionHistorial );

    }
}
