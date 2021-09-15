package pom.grupo1.test.vuelos;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo1.Pages.VFVuelosPage;
import pom.grupo1.base.TestBase;

public class atc01_rechazoCompraVuelo extends TestBase {

    final String ORIGIN = "Santiago";
    final String DESTINATION = "México";
    final String VUELOS_URL = "https://www.viajesfalabella.cl/vuelos/";

    @Test
    public void atc01() {
        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToVuelos();

        VFVuelosPage vuelos = new VFVuelosPage(driver);
        Assert.assertEquals(VUELOS_URL, vuelos.getCurrentUrl());
        vuelos.setOriginAndDestination(ORIGIN, DESTINATION);
        vuelos.dontSetDates();
        vuelos.selectTheFirstOption();
        vuelos.clickBuyButtonAndValidateAllToolTips();
    }


}
