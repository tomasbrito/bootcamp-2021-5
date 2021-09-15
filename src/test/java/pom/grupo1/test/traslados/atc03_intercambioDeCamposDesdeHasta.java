package pom.grupo1.test.traslados;

import org.junit.Test;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo1.Pages.VFTrasladosPage;
import pom.grupo1.base.TestBase;

public class atc03_intercambioDeCamposDesdeHasta extends TestBase {

    final String DESTINO = "santiago";
    final String HOTEL = "hotel";

    @Test
    public void atc03() {
        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToTraslados();

        VFTrasladosPage traslados = new VFTrasladosPage(driver);
        traslados.setAirportAndHotel(DESTINO, HOTEL);
        traslados.setDirection("Hacia el aeropuerto");
        traslados.setDirection("Desde el aeropuerto");
    }
}
