package pom.grupo3.test;

import org.junit.Test;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFAlojamientoG3;

import static org.junit.Assert.assertEquals;

public class TC_001_ReservaAlojamiento extends TestBase {

    final String DESTINO = "Buenos";
    final String YEAR_MONTH = "2021-10"; // aaaa-mm
    final String ENTRADA_DAY = "5";
    final String SALIDA_DAY = "20";
    final int CANT_ADULT = 2;
    final int CANT_HIJOS = 1;
    final String EDAD_HIJO = "9 años";
    final String URLHotel = "accommodations/detail";



    @Test
    public void test01(){
        System.out.println("tc-001: Reservar alojamiento");

        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToAlojamientos();

        VFAlojamientoG3 alojamientos = new VFAlojamientoG3(driver);
        alojamientos.selectDestino(DESTINO);
        alojamientos.selecFecha(YEAR_MONTH, ENTRADA_DAY, SALIDA_DAY);
        alojamientos.addAdult(CANT_ADULT);
        alojamientos.addkid(CANT_HIJOS);
        alojamientos.edadMenor(EDAD_HIJO);
        alojamientos.busqueda();

        alojamientos.waitForResultsPage(DESTINO);
        String nombreHotelEsperado = alojamientos.nombrePrimerHotel();
        alojamientos.switchToHotelTab(URLHotel);
        String precioEsperado = alojamientos.ReservarPimerElemento();

        //validaciones
        String HotelHotelActual = alojamientos.obtenerNombreHotel();
        assertEquals(nombreHotelEsperado, HotelHotelActual);
        assertEquals(precioEsperado, alojamientos.precioFinal());
    }


}
