package pom.grupo1.test.alojamientos;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo1.Pages.VFAlojamientosPage;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo1.base.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class atc04_confirmacionDePago extends TestBase {

    final String DESTINO = "santiago";
    final String YEAR_MONTH = "2021-10"; // aaaa-mm
    final String ENTRADA_DAY = "1";
    final String SALIDA_DAY = "15";
    final String HOTEL_DETAILS_URL = "www.viajesfalabella.cl/accommodations/detail";
    final String TRIPS_URL = "www.viajesfalabella.cl/trips";
    final String CHECKOUT_URL = "www.viajesfalabella.cl/checkout";
    final String CHECKOUT_MSG = "¡Falta poco! Completa tus datos y finaliza tu compra";


    @Test
    public void atc04()  {
        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToAlojamientos();

        VFAlojamientosPage alojamientos = new VFAlojamientosPage(driver);
        alojamientos.selectDestino(DESTINO);
        alojamientos.selectEntradaDates(YEAR_MONTH, ENTRADA_DAY, SALIDA_DAY);

        alojamientos.makeSearch();
        alojamientos.waitForResultsPage(DESTINO);

        String firstHotelName = alojamientos.getFirstHotelName();
        alojamientos.selectFirstHotel();

        alojamientos.switchToHotelTab(HOTEL_DETAILS_URL);

        String hotelPageTitle = alojamientos.getHotelTitle();
        assertEquals(firstHotelName, hotelPageTitle);

        alojamientos.bookFirstVacant(TRIPS_URL);

        alojamientos.reviewAndConfirmHotel(CHECKOUT_MSG, CHECKOUT_URL);
    }
}
