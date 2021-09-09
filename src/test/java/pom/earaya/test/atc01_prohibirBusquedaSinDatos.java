package pom.earaya.test;

import org.junit.Assert;
import org.junit.Test;
import pom.earaya.base.TestBase;
import pom.earaya.pages.VFHomePage;

public class atc01_prohibirBusquedaSinDatos extends TestBase {

    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final String entradaMsg = "Ingresa una fecha de entrada.";
    final String salidaMsg = "Ingresa una fecha de salida.";

    @Test
    public void atc01(){
        System.out.println("atc01");
        //una pagina
        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irAAlojamiento();
        Assert.assertEquals(entradaMsg,homePage.obtenerMensajeFechaEntrada());
        Assert.assertEquals(salidaMsg,homePage.obtenerMensajeFechaSalida());
    }
}
