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
import java.util.List;

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
    public void TC_T02 () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        //1.Cargar HOME
        driver.get("https://www.viajesfalabella.cl/");

        //2.Click en "Traslados"
        String Traslado_url = "https://www.viajesfalabella.cl/traslados/";
        WebElement btnTraslado = driver.findElement(By.xpath("//a[@title='Traslados']"));
        btnTraslado.click();
        Assert.assertEquals(Traslado_url, driver.getCurrentUrl());

        //3. Ingresar en Desde Aeropuerto "Ezeiza"
        WebElement ingresarAeropuerto = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Ingresa un aeropuerto']"));
        ingresarAeropuerto.click();
        ingresarAeropuerto.sendKeys("Ezeiza");

        //4. Presionar tecla Enter
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-text']")));
        ingresarAeropuerto.sendKeys(Keys.ENTER);

        //5. Ingresar en Hasta Holte "Sheraton"
        WebElement ingresarHotel = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Ingresa un hotel o dirección adónde quieras ir']"));
        ingresarHotel.click();
        ingresarHotel.sendKeys("Sheraton");

        //6. Presionar tecla Enter
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Sheraton Pilar Hotel & Convention Center, Pilar, Provincia de Buenos Aires, Argentina')]")));
        ingresarHotel.sendKeys(Keys.ENTER);

        //7. Click en apartado fecha
        WebElement arribo = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Arribo']"));
        arribo.click();

        //8. Seleccionar 28 de septiembre MANEJO CALENDARIO
        //1ro busca el elemento que va a contener la Lista, en este caso MES ACTUAL

        WebElement MesActual = driver.findElement(By.xpath("//div[@data-month='2021-09']"));
        //2do se define la lista cuyo xpath va a ser de tipo span para que recorra cada uno y extraiga el texto
        List <WebElement> listaDias = MesActual.findElements(By.xpath("//span[@class='_dpmg2--date _dpmg2--available']"));

        //3ro cada span es recorrido para extraer el texto
        for (WebElement day : listaDias) {
            if (day.getText().equals("28")) {
                day.click();
                break;
            }
        }
        //9. Click en Aplicar
        WebElement AplicarFecha = driver.findElement(By.xpath("//button[@ class='_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary']"));
        AplicarFecha.click();

        //10. Click en Hora y seleccionar 10:00
        WebElement horaLlegada = driver.findElement(By.xpath("//select[@class='select-tag sbox-time-arrival']"));
        Select s = new Select(horaLlegada);
        s.selectByValue("600");

        //11. Click en Buscar
        WebElement btnBuscar = driver.findElement(By.xpath("//div[@class='sbox-button'] "));
        btnBuscar.click();

        //En el banner de google maps, se deben visualizar el Aeropuerto y el Hotel seleccionados previamente
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='eva-3-row flex-desktop']")));
        WebElement contenedorMaps = driver.findElement(By.xpath("//div[@class='eva-3-row flex-desktop']"));

        //VALIDACION
        String Aeropuerto = "Aeropuerto Buenos Aires Ministro Pistarini Ezeiza";
        String Hotel = "Sheraton Pilar Hotel & Convention Center";

        List<WebElement> AeropuertoHotel = driver.findElements(By.xpath("//div[@class='text-container'] //span[@class='ng-binding']"));
        Assert.assertEquals(Aeropuerto, AeropuertoHotel.get(0).getText());
        Assert.assertEquals(Hotel, AeropuertoHotel.get(1).getText());
    }

    @Test
    public void TC_T04 (){

        WebDriverWait wait = new WebDriverWait(driver, 5);

        //1.Cargar HOME
        driver.get("https://www.viajesfalabella.cl/");

        //2.Seleccionar Traslados
        String Traslado_url = "https://www.viajesfalabella.cl/traslados/";
        WebElement btnTraslado = driver.findElement(By.xpath("//a[@title='Traslados']"));
        btnTraslado.click();
        Assert.assertEquals(Traslado_url, driver.getCurrentUrl());

        //3.Seleccionar "Hacia el aeropuerto"
        List <WebElement> btnDesdeHacia = driver.findElements(By.xpath("//i[@class='radio-circle sbox-radio-circle']"));
        btnDesdeHacia.get(1).click();

        //4.Click en DESDE
        WebElement ingresarOrigen = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Ingresa un hotel o dirección adónde quieras ir']"));
        ingresarOrigen.click();

        //5.Ingresar "Sheraton Mar del Plata"
        ingresarOrigen.sendKeys("Sheraton Mar del Plata");

        //6.Seleccionar Primera Opcion
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Sheraton, Leandro N. Alem, Mar del Plata, Provinci')]")));
        WebElement resultado_1 = driver.findElement(By.xpath("//span[contains(text(),'Sheraton, Leandro N. Alem, Mar del Plata, Provinci')]"));
        resultado_1.click();

        //7.Click en HASTA
        WebElement ingresarDestino = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Ingresa un aeropuerto']"));
        ingresarDestino.click();

        //8.Ingresar "EZEIZA"
        ingresarDestino.sendKeys("EZEIZA");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='item-text']")));

        //9.Seleccionar Unica Opcion
        ingresarDestino.sendKeys(Keys.ENTER);

        //10.Click en Fecha
        WebElement fecha = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Partida']"));
        fecha.click();

        //11. Seleccionar 21 de Septiembre
        WebElement MesActual = driver.findElement(By.xpath("//div[@data-month='2021-09']"));
        List <WebElement> listaDias = MesActual.findElements(By.xpath("//span[@class='_dpmg2--date _dpmg2--available']"));

        for (WebElement day : listaDias) {
            if (day.getText().equals("21")) {
                day.click();
                break;
            }
        }

        //12. Click en Aplicar
        WebElement AplicarFecha = driver.findElement(By.xpath("//button[@ class='_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary']"));
        AplicarFecha.click();

        //13.Click en Hora y seleccionar 12:00
        WebElement horaPartida = driver.findElement(By.xpath("//select[@class='select-tag sbox-time-departure']"));
        Select s = new Select(horaPartida);
        s.selectByVisibleText("12:00");

        //14.Click Buscar
        WebElement btnBuscar = driver.findElement(By.xpath("//div[@class='sbox-button'] "));
        btnBuscar.click();

        //15.Seleccionar Moneda
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='currency-select']")));
        WebElement selecMoneda = driver.findElement(By.xpath("//select[@id='currency-select']"));

        //16. Elegir Dolares
        Select moneda = new Select(selecMoneda);
        moneda.selectByValue("string:USD");

        //El valor mostrado en DESDE coincide con el valor minimo de los resultados obtenidos

        List <WebElement> precioDesde = driver.findElements(By.xpath("//p[@ng-show='model.lowestPrice.private'] //span[@class='ng-binding']"));
        List <WebElement> precio = driver.findElements(By.xpath("//span[@class='pricebox-big-text ng-binding']"));
        //Elemento 5, corresponde al primer resultado mostrado
        Assert.assertEquals(precioDesde.get(1).getText(), precio.get(5).getText());
    }

    @After
    public void close() {

        if (driver != null) {
            driver.close();
        }

    }


}
