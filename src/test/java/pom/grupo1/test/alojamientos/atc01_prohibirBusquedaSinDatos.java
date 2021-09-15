package pom.grupo1.test.alojamientos;

import org.junit.Test;
import pom.grupo1.Pages.VFAlojamientosPage;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo1.base.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class atc01_prohibirBusquedaSinDatos extends TestBase {

    final String ENTRADA_TOOLTIP_MSG = "Ingresa una fecha de entrada.";
    final String SALIDA_TOOLTIP_MSG = "Ingresa una fecha de salida.";

    @Test
    public void atc01() {
        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToAlojamientos();

        VFAlojamientosPage alojamientos = new VFAlojamientosPage(driver);
        alojamientos.makeSearch();
        List<String> tooltipMsgs = alojamientos.getFechasTooltipsMsgs();

        assertEquals(ENTRADA_TOOLTIP_MSG, tooltipMsgs.get(0));
        assertEquals(SALIDA_TOOLTIP_MSG, tooltipMsgs.get(1));
    }
}
