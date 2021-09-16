package pom.grupo1.test.vuelos;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo1.Pages.VFVuelosPage;
import pom.grupo1.base.TestBase;

import static org.junit.Assert.assertEquals;

public class atc03_reseteoFechaDeIdaPorIncongruencia extends TestBase {

    @Test
    public void atc03() {
        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToVuelos();

        VFVuelosPage vuelos = new VFVuelosPage(driver);
        vuelos.setDatesFromToday(3, 2, "");

    }

}
