package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;
import java.util.List;

public class tc_paquete {

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
    public void TC_P01() throws InterruptedException{

        WebDriverWait wait=new WebDriverWait(driver,20);
        //1.Cargar HOME
        driver.get("https://www.viajesfalabella.cl/");

        //2.Seleccionar paquete "Cancun saliendo de Santiago de Chile" en carrousel
        WebElement Cancun = driver.findElement(By.xpath("//span[contains(text(),'PAQUETES')]"))
                .findElement(By.xpath("//h3[text()='Cancún saliendo de Santiago de Chile']"));
        Cancun.click();

        //3.Esperar carga de resultados
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("results-items-wrapper")));

        //4.Click en boton SIGUIENTE del primer resultado
        WebElement btnSiguiente = driver.findElement(By.xpath("//em[@class='btn-text' and text()='Siguiente']"));
        btnSiguiente.click();
        Thread.sleep(2000);

        // Cambio de pestaña
        for (String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'comentarios')]")));

        //5.Click en ver comentarios
        WebElement verComentarios = driver.findElement(By.xpath("//a[contains(text(),'comentarios')]"));
        verComentarios.click();

        //6.Click en Ordenar POR y seleccionar menor puntaje
        WebElement ordenarPor = driver.findElement(By.xpath("//select[@id='jr-eva-select']"));
        Select s = new Select(ordenarPor);
        s.selectByVisibleText("Menor puntaje");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='eva-3-rating -md -bad']")));

        //VALIDACION -> Deben mostrarse primero los puntajes de menor valor

        String valor = driver.findElement(By.xpath("//span[@class='eva-3-rating -md -bad']")).getText();
        Double valorMenor = Double.parseDouble (valor);
        System.out.println(valorMenor);

        //GUARDAR ELEMENTOS EN ARRAY Y ORDENARLO

    }

    @Test
    public void TC_P04 () throws InterruptedException{

        WebDriverWait wait=new WebDriverWait(driver,3);

        //1.Cargar HOME
        driver.get("https://www.viajesfalabella.cl/");

        //2.Seleccionar Vuelo + Auto
        WebElement VueloAuto = driver.findElement(By.xpath("//input[@type ='radio' and @value ='va']"));
        VueloAuto.click();

        //3.Click en ORIGEN
        WebElement Origen = driver.findElement(By.xpath("//input[contains(@class, 'sbox-places-first')]"));
        Origen.click();

        //4.Ingresar "La Rioja"
        Origen.sendKeys("La Rioja");
        Thread.sleep(2000);

        //5.Seleccionar 1er Resultado
        Origen.sendKeys(Keys.ENTER);

        //6.Click en Destino
        WebElement Destino = driver.findElement(By.xpath("//input[contains(@class, 'sbox-destination sbox-secondary')]"));
        Destino.click();

        //7.Ingresar "Santiago"
        Destino.sendKeys("Santiago");
        Thread.sleep(2000);

        //8. Seleccionar 1er Resultado
        Destino.sendKeys(Keys.ENTER);

        //9. Click en Fechas
        WebElement Fechas = driver.findElement(By.xpath("//input[@placeholder = 'Ida']"));
        Fechas.click();

        //10.Desplazarse a Noviembre
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--controls-next']")));
        List <WebElement> btnNext = driver.findElements(By.xpath("//div[@class='_dpmg2--controls-next']"));

        //11. Seleccionar 10 de Noviembre

        //12. Seleccionar hasta 24 de Noviembre

        //13. Click en Aplicar
        //14. click en Pasajeros
        //15. Click en + agregar pasajero adulto
        //16. Click Aplicar
        //17. Click en Buscar
        //18. Esperar Busqueda

        //VALIDACION -> Se debe visualizar el siguiente mensaje:
        //"Lo sentimos, no pudimos hallar ningún resultado. Intenta hacer la búsqueda nuevamente."

    }

    @Test
    public void TC_P002 (){

        //1. El sistema debe mostrar la duracion del vuelo en la pestaña de informacion de vuelo,
        //2. La misma debe estar expresada en formato "h mm" (horas y minutos)

        //1. Escribir en el campo Origen "Chile"
        //2. Seleccionar "Santiago de Chile, Santiago, Chile"
        //3. Escribir en el campo Destino "Magallanes"
        //4. Seleccionar "Puerto Natales, Magallanes, Chile"
        //5. Seleccionar el campo "IDA" en Fechas
        //6. Selecionar cualquier fecha disponible de IDA
        //7. Seleccionar cualquier fecha disponible de VUELTA
        //8. Click en Aplicar
        //9. Seleccionar el Campo HASTA
        //10. Seleccionar cualquier fecha disponible
        //11. Click en Aplicar
        //12. Escribir en el campo SEGUNDO DESTINO "puerto"
        //13. Seleccionar "Puerto Varas, Los Lagos, Chile"
        //14. Seleccionar boton Buscar
        //15. Esperar que cargue la pagina
        //16. Click sobre la primera barra de Vuelo para desplegar la pestaña de informacion de VUELO

    }

    @Test
    public void TC_P004 (){

        //El sistema permite mediante el boton "Ver resumen" desplegar la pestaña de Resumen de Paquete

        //1. Escribir en el campo Origen "Chile"
        //2. Seleccionar "Santiago de Chile, Santiago, Chile"
        //3. Escribir en el campo Destino "Magallanes"
        //4. Seleccionar "Puerto Natales, Magallanes, Chile"
        //5. Seleccionar el campo "IDA" en Fechas
        //6. Selecionar cualquier fecha disponible de IDA
        //7. Seleccionar cualquier fecha disponible de VUELTA
        //8. Click en Aplicar
        //9. Seleccionar el Campo HASTA
        //10. Seleccionar cualquier fecha disponible
        //11. Click en Aplicar
        //12. Escribir en el campo SEGUNDO DESTINO "puerto"
        //13. Seleccionar "Puerto Varas, Los Lagos, Chile"
        //14. Seleccionar boton Buscar
        //15. Esperar que cargue la pagina
        //16. Click en Siguiente sobre el 1er elemento de Vuelo
        //17. Click en Siguiente sobre el 1er elemento de Alojamiento
        //18. Click en Siguiente sobre el 1er elemento de Habitacion
        //19. Click en Siguiente sobre el 1er elemento de Alojamiento
        //20. Click en Siguiente sobre el 1er elemento de Habitacion
        //21. Click en "Ver resumen"


    }
/*
    @After
    public void close() {

        if (driver != null) {
            driver.close();
        }

    }*/
}
