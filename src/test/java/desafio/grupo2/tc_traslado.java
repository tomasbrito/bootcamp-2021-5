package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tc_traslado {

    WebDriver driver;

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_T02 (){

        //En el banner de google maps, se deben visualizar el Aeropuerto y el Hotel seleccionados previamente

        //1.Cargar HOME
        //2.Click en "Traslados"
        //3. Ingresar en Desde Aeropuerto "Ezeiza"
        //4. Presionar tecla Enter
        //5. Ingresar en Hasta Holte "Sheraton"
        //6. Presionar tecla Enter
        //7. Click en apartado fecha
        //8. Seleccionar 14 de septiembre
        //9. Click en Aplicar
        //10. Click en Hora
        //11. Seleccionar 10:00
        //12. Click en Buscar

    }

    @Test
    public void TC_T04 (){

        //El valor mostrado en DESDE coincide con el valor minimo de los resultados obtenidos

        //1.Cargar HOME
        //2.Seleccionar Traslados
        //3.Seleccionar "Hacia el aeropuerto"
        //4.Click en DESDE
        //5.Ingresar "Sheraton Mar del Plata"
        //6.Seleccionar Primera Opcion
        //7.Click en HASTA
        //8.Ingresar "EZEIZA"
        //9.Seleccionar Unica Opcion
        //10.Click en Fecha
        //11. Seleccionar 21 de Septiembre
        //12. Click en Aplicar
        //13.Click en Hora
        //14. Seleccionar 12:00
        //15.Click Buscar
        //16.Seleccionar Moneda
        //17. Elegir Dolares


    }

    @After
    public void close() {

        if (driver != null) {
            driver.close();
        }

    }


}
