package pom.grupo1.test.traslados;

import org.junit.Test;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo1.Pages.VFTrasladosPage;
import pom.grupo1.base.TestBase;

public class atc04_denegarCompraSinTerminosYCondicionesAceptados extends TestBase {

    final String DESTINATION = "santiago";
    final String HOTEL = "hotel";
    final String YEAR_MONTH = "2021-10"; // aaaa-mm
    final String ARRIVE_DAY = "1";
    final String HOUR = "930"; // 15:30 pasado a minutos
    final String NAME = "Juan";
    final String LASTNAME = "Perez";
    final String RUITNUMBER = "004340922";
    final String ADDRES = "San Martin";
    final String AIRLINE = "Aerolinea";
    final String FLIGHTNUMBER = "1";
    final String EMAIL = "juan@gmail.com";
    final String AREACODE = "42";
    final String PHONE = "32414";

    @Test
    public void atc04() {
        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToTraslados();

        VFTrasladosPage traslados = new VFTrasladosPage(driver);
        traslados.setAirportAndHotel(DESTINATION, HOTEL);
        traslados.setArriboDate(YEAR_MONTH, ARRIVE_DAY);
        traslados.setHour(HOUR);
        traslados.makeSearch();
        traslados.selectFirstVehicleOption();
        traslados.selectTransferMethod();
        traslados.setProofOfPayment(NAME, RUITNUMBER, ADDRES);
        traslados.setWhoTravels(NAME, LASTNAME);
        traslados.setAditionalInformation(AIRLINE, FLIGHTNUMBER);
        traslados.setEmailVouchers(EMAIL);
        traslados.setPhoneNumberAndBuy(AREACODE, PHONE);

    }

}
