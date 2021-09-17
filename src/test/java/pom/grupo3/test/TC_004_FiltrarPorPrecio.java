package pom.grupo3.test;

import org.junit.Test;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFAlojamientoG3;

public class TC_004_FiltrarPorPrecio extends TestBase {

    final String DESTINO = "Buenos";
    final String DIA_ENTRADA = "5";
    final String DIA_SALIDA = "20";
    final String YEAR_MONTH = "2021-10";
    final int CANT_ADULT = 2;
    final int CANT_HIJOS = 1;
    final String EDAD_HIJO = "9 años";
    final String URLHotel = "accommodations/detail";
    final String precioDesde = "1.500.000";
    final String precioHasta = "3.000.000";



    @Test
    public void test04() {
        System.out.println("tc-004: Filtrar alojamientos por precio");

        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToAlojamientos();

        VFAlojamientoG3 alojamientos = new VFAlojamientoG3(driver);
        alojamientos.selectDestino(DESTINO);
        alojamientos.selecFecha(YEAR_MONTH, DIA_ENTRADA, DIA_SALIDA);
        alojamientos.addAdult(CANT_ADULT);
        alojamientos.addkid(CANT_HIJOS);
        alojamientos.edadMenor(EDAD_HIJO);
        alojamientos.busqueda();

        alojamientos.waitForResultsPage(DESTINO);
        //filtrar
        alojamientos.filtrarPorPrecio(precioDesde, precioHasta);

    }
}
