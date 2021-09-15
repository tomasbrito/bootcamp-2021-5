package pom.grupo1.test.alojamientos;

import org.junit.Test;
import pom.grupo1.Pages.VFAlojamientosPage;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo1.base.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class atc02_precioUsd extends TestBase {

    final String DESTINO = "santiago";
    final String CURRENCY_VALUE = "USD";
    final String CURRENCY_TEXT = "US$";


    @Test
    public void atc02() {
        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToAlojamientos();

        VFAlojamientosPage alojamientos = new VFAlojamientosPage(driver);
        alojamientos.selectDestino(DESTINO);
        alojamientos.checkNoHeDecididoFecha();
        alojamientos.makeSearch();

        alojamientos.waitForResultsPage(DESTINO);

        alojamientos.selectCurrencyType(CURRENCY_VALUE);
        alojamientos.waitResultsRefresh();

        assertTrue(alojamientos.isCurrencyIn(CURRENCY_TEXT));
    }
}
