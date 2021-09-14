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
    final String CHILDREN_AGE = "10";
    final int ROOM_AMOUNT = 2;

    @Test
    public void atc03() {
        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToTraslados();

        VFTrasladosPage traslados = new VFTrasladosPage(driver);
        traslados.checkAgregarRegreso();
        traslados.selectDesde(DESTINO);
        traslados.selectHasta(HOTEL);

        traslados.selectDates(YEAR_MONTH, ARRIBO_DAY, PARTIDA_DAY);

//
//        alojamientos.addRoom(ROOM_AMOUNT - 1);
//        alojamientos.selectOneAdultPerRoom(ROOM_AMOUNT);
//        alojamientos.selectOneChildPerRoom(ROOM_AMOUNT);
//        alojamientos.setChildrenAge(CHILDREN_AGE, ROOM_AMOUNT);
//
//        alojamientos.makeSearch();
//        alojamientos.waitForResultsPage(DESTINO);
//
//        Assert.assertEquals(ROOM_AMOUNT, alojamientos.getRoomsAmount());
    }
}
