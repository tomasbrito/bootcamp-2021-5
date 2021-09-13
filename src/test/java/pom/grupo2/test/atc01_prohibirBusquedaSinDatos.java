package pom.grupo2.test;

import org.junit.Test;
import pom.grupo2.pages.VFHomePage;
import pom.grupo2.base.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class atc01_prohibirBusquedaSinDatos extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String ALOJAMIENTOS_URL = "https://www.viajesfalabella.cl/hoteles/";
    final String entradaMsg = "Ingresa una fecha de entrada.";
    final String salidaMsg = "Ingresa una fecha de salida.";

    @Test
    public void atc01() {

        VFHomePage alojamientos = new VFHomePage(driver);
        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irAlojamiento();

        assertEquals(entradaMsg, homePage.obtenerMensajeFechaEntrada());
        assertEquals(salidaMsg, homePage.obtenerMensajeFechaSalida());
    }
}