package desafio.grupo4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Alojamiento {
    static final String url = "https://www.viajesfalabella.cl/";
    WebDriver driver;
    @BeforeClass
    public static void init(){
        WebDriverManager.edgedriver().setup();

    }

    @Before
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @After
    public void close(){
        System.out.println("After");
        if(driver !=null){
           // driver.close();
        }
    }

    @Test //TODO TC-009
    public void restablecerFechaDeIda(){
        //atributos
        WebDriverWait exwait = new WebDriverWait(driver, 10);

        //atributos Localizadores
        By btnAlojamientos = By.xpath("//*[contains(@class, 'HOTELS')]");
        By botonFechaIda = By.xpath("//body[1]/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
        By campoFechaIda = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[30]/span[1]");
        By campoFechaVuelta = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[26]/span[1]");


        //navego al home
        driver.get(url);

        //navego hasta la página de traslados
        driver.findElement(btnAlojamientos).click();

        //Valido que esté en la URL correcta
        exwait.until(ExpectedConditions.urlContains("/hoteles"));
        Assert.assertEquals("https://www.viajesfalabella.cl/hoteles/", driver.getCurrentUrl());

        //Clickeo el botón de fecha de ida
        driver.findElement(botonFechaIda).click();
        //Espero a que el botón sea clickeable, y lo clickeo
        exwait.until(ExpectedConditions.elementToBeClickable(campoFechaIda)).click();
        exwait.until(ExpectedConditions.elementToBeClickable(campoFechaVuelta)).click();

        //Valido que el campo de fecha de ida esté vacío
        Assert.assertEquals("", driver.findElement(campoFechaIda).getText());

    }
    @Test //TODO TC 012
    public void filtrarPorAlquileresVacacionales() throws InterruptedException {
        //atributos
        WebDriverWait exwait = new WebDriverWait(driver, 10);
        String urlObjetivo = "https://www.viajesfalabella.cl/accommodations/results/";


        //atributos Localizadores
        By btnAlojamientos = By.xpath("//*[contains(@class, 'HOTELS')]");
        By botonFechaIda = By.xpath("//body[1]/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
        By campoFechaIda = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[27]/span[1]");
        By campoFechaVuelta = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[30]/span[1]");
        By inputDestino = By.xpath("//*[contains(@class, 'input-tag sbox-main-focus sbox-destination sbox-primary')]");
        By opcionAElegir = By.xpath("//body/div[14]/div[1]/div[1]/ul[1]/li[1]/span[1]");
        By botonHabitaciones = By.xpath("//body[1]/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]");
        By botonAñadirHabitacion = By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/a[2]");
        By botonAplicar = By.xpath("//body/div[2]/div[1]/div[2]/a[1]");
        By botonBuscar = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/a[1]");
        By botonAlquileresVacacionales = By.xpath("//body/aloha-app-root[1]/aloha-results[1]/div[1]/div[1]/div[1]/div[2]/div[2]/aloha-list-view-container[1]/aloha-results-toolbar[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/ul[1]/aloha-tooltip-coachmark[1]/div[1]/li[1]");

        //navego al home
        driver.get(url);

        //navego hasta la página de traslados
        driver.findElement(btnAlojamientos).click();

        //Valido que esté en la URL correcta
        exwait.until(ExpectedConditions.urlContains("/hoteles"));
        Assert.assertEquals("https://www.viajesfalabella.cl/hoteles/", driver.getCurrentUrl());

        //Ingreso 'Santiago' en el campo de destino
        driver.findElement(inputDestino).sendKeys("Santiago");
        exwait.until(ExpectedConditions.elementToBeClickable(opcionAElegir)).click();

        //Espero a que el botón de fechas sea clickeable, y lo clickeo
        driver.findElement(botonFechaIda).click();
        exwait.until(ExpectedConditions.elementToBeClickable(campoFechaIda)).click();
        exwait.until(ExpectedConditions.elementToBeClickable(campoFechaVuelta)).click();

        //Clickeo el botón de habitaciones
        driver.findElement(botonHabitaciones).click();
        exwait.until(ExpectedConditions.elementToBeClickable(botonAñadirHabitacion)).click();
        exwait.until(ExpectedConditions.elementToBeClickable(botonAplicar)).click();

        //Clickeo el botón buscar
        driver.findElement(botonBuscar).click();

        //Valido que esté en el urlObjetivo
        exwait.until(ExpectedConditions.urlContains(urlObjetivo));

        //Espero a que el botón sea clickeable, y lo clickeo
        Thread.sleep(3000);
        exwait.until(ExpectedConditions.elementToBeClickable(botonAlquileresVacacionales)).click();
        Thread.sleep(3000);

        //Creo una lista de WebElements de los alquileres vacacionales
        WebElement weBotonAlquileresVacacionales = driver.findElement(botonAlquileresVacacionales);
        List<WebElement> alquileresVacacionales = driver.findElements(By.xpath(("//span[contains(text(),'Alquiler vacacional')]")));

        //Los recorro y verifico que todos los que estén en la página sean Alquileres Vacacionales
        for(WebElement we: alquileresVacacionales){
            Assert.assertEquals("Alquiler vacacional", we.getText());
        }
    }
    @Test // TODO NO ANDA
    //TODO TC-011
    public void modificarFechaDeIdaYVuelta() throws InterruptedException {
        //Atributos
        WebDriverWait exwait = new WebDriverWait(driver, 10);
        String urlResultadoBusqueda = "https://www.viajesfalabella.cl/accommodations/results/";
        String urlDetalleHotel = "https://www.viajesfalabella.cl/accommodations/detail/";
        //Localizadores
        By btnAlojamientos = By.xpath("//*[contains(@class, 'HOTELS')]");
        By inputDestino = By.xpath("//*[contains(@class, 'input-tag sbox-main-focus sbox-destination sbox-primary')]");
        By opcionAElegir = By.xpath("//body/div[14]/div[1]/div[1]/ul[1]/li[1]/span[1]");
        By botonFechaIda = By.xpath("//body[1]/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
        By campoFechaIda = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[27]/span[1]");
        By campoFechaVuelta = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[30]/span[1]");
        By botonBuscar = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/a[1]");
        By botonVerDetalleHotel = By.xpath("//body/aloha-app-root[1]/aloha-results[1]/div[1]/div[1]/div[1]/div[2]/div[2]/aloha-list-view-container[1]/div[2]/div[1]/aloha-cluster-container[1]/div[1]/div[1]/div[2]/aloha-cluster-pricebox-container[1]/div[1]/div[2]/div[2]/aloha-button[1]/button[1]");
        By botonReservarAhora = By.xpath("//body/aloha-app-root[1]/aloha-detail[1]/div[1]/div[3]/div[1]/div[2]/aloha-roompacks-container[1]/aloha-roompacks-grid-container[1]/div[2]/div[2]/aloha-reservation-summary-container[1]/div[1]/aloha-next-step-button[1]/aloha-button[1]/button[1]");
        //navego al home
        driver.get(url);

        //navego hasta la página de traslados
        driver.findElement(btnAlojamientos).click();

        //Valido que esté en la URL correcta
        exwait.until(ExpectedConditions.urlContains("/hoteles"));
        Assert.assertEquals("https://www.viajesfalabella.cl/hoteles/", driver.getCurrentUrl());

        //Ingreso 'Santiago' en el campo de destino
        driver.findElement(inputDestino).sendKeys("Santiago");
        exwait.until(ExpectedConditions.elementToBeClickable(opcionAElegir)).click();

        //Espero a que el botón de fechas sea clickeable, y lo clickeo
        driver.findElement(botonFechaIda).click();
        exwait.until(ExpectedConditions.elementToBeClickable(campoFechaIda)).click();
        exwait.until(ExpectedConditions.elementToBeClickable(campoFechaVuelta)).click();

        //Clickeo el botón buscar
        driver.findElement(botonBuscar).click();

        //Valido que esté en el url de resultado de busqueda
        exwait.until(ExpectedConditions.urlContains(urlResultadoBusqueda));

        //Clickeo el botón de 'Ver detalle'
        exwait.until(ExpectedConditions.elementToBeClickable(botonVerDetalleHotel)).click();

        //Me cambio a la nueva ventana
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(browserTabs.get(1));

        WebElement webotonReservarAhora = driver.findElement(botonReservarAhora);

        //Valido que esté en el URL de detalles del hotel
        //exwait.until(ExpectedConditions.urlContains(urlDetalleHotel));

        //En la nueva ventana, clickeo el boton de ver habitaciones
        exwait.until(ExpectedConditions.elementToBeClickable(webotonReservarAhora)).click();

        //Clickeo el botón de reservar ahora
        //exwait.until(ExpectedConditions.elementToBeClickable(botonReservarAhora)).click();





    }

}
