package pom.grupo3.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo1.Pages.VFHomePage;
import pom.grupo3.base.TestBase;
import pom.grupo3.pages.VFAlojamientoG3;

public class TC_003_ErrorFaltaDeEdad extends TestBase {

    final String DESTINO = "miami";
    final String YEAR_MONTH = "2021-10"; // aaaa-mm
    final String ENTRADA_DAY = "5";
    final String SALIDA_DAY = "20";
    final int CANT_ADULT = 2;
    final int CANT_HIJOS = 1;
    final String EDAD_HIJO = "9 años";
    final String MENSAJEESPERADO = "Ingresa la edad del menor";


    @Test
    public void test03() {
        System.out.println("tc-003: Error por falta de edad");

        VFHomePage home = new VFHomePage(driver);
        home.goToHome();
        home.goToAlojamientos();

        VFAlojamientoG3 alojamientos = new VFAlojamientoG3(driver);
        alojamientos.addAdult(CANT_ADULT);
        alojamientos.addkid(CANT_HIJOS);
        alojamientos.aplicarHabitaciones();
        String mensajeACtual = alojamientos.obtenerMensajeErrorEdad();

        //validaciones
        Assert.assertEquals(MENSAJEESPERADO, mensajeACtual);



    }
}
