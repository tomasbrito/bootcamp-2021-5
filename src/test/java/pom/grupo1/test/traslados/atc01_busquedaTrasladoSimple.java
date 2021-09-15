package pom.grupo1.test.traslados;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo1.Pages.VFTrasladosPage;
import pom.grupo1.base.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class atc01_busquedaTrasladoSimple extends TestBase {

    final String DESTINO = "santiago";
    final String HOTEL = "hotel w santiago";
    final String YEAR_MONTH = "2021-10"; // aaaa-mm
    final String ARRIBO_DAY = "1";
    final String PARTIDA_DAY = "15";
    final String RESULTADO_BUSQUEDA_URL = "www.viajesfalabella.cl/transfer/shopping/#!/search/roundtrip/airport/";
    final String AIRPORT_NAME = "Aeropuerto Arturo Merino Benitez";
    final String HOTEL_NAME = "Hotel W Santiago";


    @Test
    public void atc01() {
        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToTraslados();

        VFTrasladosPage traslados = new VFTrasladosPage(driver);
        traslados.checkAgregarRegreso();
        traslados.selectDesde(DESTINO);
        traslados.selectHasta(HOTEL);

        traslados.selectDates(YEAR_MONTH, ARRIBO_DAY, PARTIDA_DAY);
        traslados.makeSearch();
        traslados.waitForResultsPage(RESULTADO_BUSQUEDA_URL);

        assertTrue(traslados.isTrasladoInfoCorrect(AIRPORT_NAME, HOTEL_NAME));
    }
}
