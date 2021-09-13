package desafio.grupo1.traslados;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ATC03_intercambioDeCamposDesdeHasta {

    WebDriver driver;
    final String url = "https://www.viajesfalabella.cl/";
    private String aeropuerto, hotel;
    private By seccionTrasladosLocalizador;
    private WebDriverWait smallWait, bigWait;
    // Localizadores:
    By localizadorInputAeropuerto = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline\"]");
    By localizadorPrimeraOpcionAeropuerto = By.xpath("//div[@class='ac-wrapper -desktop -show']//li[@class='item'][1]");
    By localizadorInputHotel = By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']");
    By localizadorPrimeraOpcionHotel = By.xpath("//div[@class='ac-wrapper -desktop -facet -show']//li[@class='item'][1]");
    By localizadorHaciaAeropuerto = By.xpath("//span[@class=\"sbox-3-radio -md sbox-radio-button\"][2]/label");
    By localizadorDesdeAeropuerto = By.xpath("//span[@class=\"sbox-3-radio -md sbox-radio-button\"][1]/label");
    By localizadorCampoDesde = By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']");
    By localizadorCampoHasta = By.xpath("//input[@class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline']");


    @BeforeClass
    public static void initialiseBrowser() {
        System.out.println("Init");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupBrowser() {
        System.out.println("SetUp");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        this.smallWait = new WebDriverWait(driver, 5);
        this.bigWait = new WebDriverWait(driver, 20);
        this.seccionTrasladosLocalizador = By.xpath("//a[@title='Traslados']");
        this.aeropuerto = "Santiago";
        this.hotel = "Hotel";
    }

    @Test
    public void atc03() {
        final String BASE_URL = "https://www.viajesfalabella.cl/";
        final String TRASLADOS_URL = "https://www.viajesfalabella.cl/traslados/";

        // Carga la página web
        driver.get(BASE_URL);
        // 2) Clickea 'Traslados' en la barra de navegacion
        this.smallWait.until(ExpectedConditions.elementToBeClickable(this.seccionTrasladosLocalizador));
        driver.findElement(this.seccionTrasladosLocalizador).click();
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorInputAeropuerto));
        // Valida ubicacion en 'Traslados'
        String url = driver.getCurrentUrl();
        assertTrue(url.contains(TRASLADOS_URL));
        // 3) Ingresa el aeropuerto
        WebElement inputAeropuerto = driver.findElement(localizadorInputAeropuerto);
        inputAeropuerto.sendKeys(this.aeropuerto);
        // 4) Selecciona la primer opción
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorPrimeraOpcionAeropuerto));
        driver.findElement(localizadorPrimeraOpcionAeropuerto).click();
        String aeropuertoSeleccionado = inputAeropuerto.getText();
        // 5) Ingresa el hotel
        WebElement inputHotel = driver.findElement(localizadorInputHotel);
        String aux = inputHotel.getAttribute("placeholder");
        inputHotel.sendKeys(this.hotel);
        // 6) Selecciona la primer opción
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorPrimeraOpcionHotel));
        driver.findElement(localizadorPrimeraOpcionHotel).click();
        String hotelSeleccionado = inputHotel.getText();
        // 7) Clickea 'Hacia el aeropuerto'
        driver.findElement(localizadorHaciaAeropuerto).click();
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorDesdeAeropuerto));
        // Valida el cambio de campos
        String campoDesde = driver.findElement(localizadorCampoDesde).getText();
        String campoHasta = driver.findElement(localizadorCampoHasta).getText();
        assertEquals(hotelSeleccionado, campoDesde);
        assertEquals(aeropuertoSeleccionado, campoHasta);
        // 8) Clickea 'Desde el aeropuerto'
        driver.findElement(localizadorDesdeAeropuerto).click();
        // Valida el cambio de campos
        campoDesde = inputAeropuerto.getText();
        campoHasta = inputHotel.getText();
        assertEquals(aeropuertoSeleccionado, campoDesde);
        assertEquals(hotelSeleccionado, campoHasta);
    }

    @After
    public void cleanup() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }

}