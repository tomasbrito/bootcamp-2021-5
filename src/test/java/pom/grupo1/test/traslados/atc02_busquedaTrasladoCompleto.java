package pom.grupo1.test.traslados;

import org.junit.Test;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo1.Pages.VFTrasladosPage;
import pom.grupo1.base.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class atc02_busquedaTrasladoCompleto extends TestBase {

    final String PERSONS_NUM = "2";
    final String DESTINO = "santiago";
    final String HOTEL = "hotel w santiago";
    final String YEAR_MONTH = "2021-10"; // aaaa-mm
    final String ARRIBO_DAY = "1";
    final String PARTIDA_DAY = "15";
    final String RESULTADO_BUSQUEDA_URL = "www.viajesfalabella.cl/transfer/shopping/#!/search/roundtrip/airport/";
    final String AIRPORT_NAME = "Aeropuerto Arturo Merino Benitez";
    final String HOTEL_NAME = "Hotel W Santiago";
    final String TRASLADO_HOUR = "08:00";
    final String CHILD_AGE = "10";

    @Test
    public void atc02() {
        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToTraslados();

        VFTrasladosPage traslados = new VFTrasladosPage(driver);
        traslados.checkAgregarRegreso();
        traslados.selectDesde(DESTINO);
        traslados.selectHasta(HOTEL);

        traslados.selectHoursAndDates(TRASLADO_HOUR, YEAR_MONTH, ARRIBO_DAY, PARTIDA_DAY);

        traslados.addChild(CHILD_AGE);

        traslados.makeSearch();
        traslados.waitForResultsPage(RESULTADO_BUSQUEDA_URL);

        boolean isDataCorrect = traslados.isDestinoInfoCorrect(AIRPORT_NAME, HOTEL_NAME) &&
                traslados.isHourAndPersonsInfoCorrect(TRASLADO_HOUR, PERSONS_NUM);

        assertTrue(isDataCorrect);
    }
}
