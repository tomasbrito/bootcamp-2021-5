package desafio.grupo1.traslados;

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


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ATC04_denegarCompraSinTerminosYCondicionesAceptados {

    WebDriver driver;
    final String url = "https://www.viajesfalabella.cl/";
    private String aeropuerto, hotel;
    private By seccionTrasladosLocalizador;
    private WebDriverWait smallWait, bigWait;
    // Localizadores:
    By localizadorInputAeropuerto = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline\"]");
    By localizadorPrimeraOpcionAeropuerto = By.xpath("//div[@class='ac-wrapper -desktop -show']//li");
    By localizadorInputHotel = By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']");
    By localizadorPrimeraOpcionHotel = By.xpath("//div[@class='ac-wrapper -desktop -facet -show']//li");
    By localizadorFechaArribo = By.xpath("//input[@class=\"input-tag sbox-checkin\"]");
    By localizadorFechaElegida = By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--onlyway _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--month _dpmg2--o-5'][1]//span[@class='_dpmg2--date _dpmg2--available'][2]");
    By localizadorHora = By.xpath("//div[@class=\"select-container\"]/select[@class='select-tag sbox-time-arrival']");
    By localizadorBuscar = By.xpath("//div[@class='sbox-button']//a[@class=\"sbox-3-btn -primary -md sbox-search\"]");
    By localizadorComprar = By.xpath("//div[@class='search-cluster ng-scope'][1]//button");
    By localizadorMetodoDePago = By.xpath("//payment-method-selector//li[2]//label");
    By localizadorBanco = By.xpath("//*[@id='card-selector-0']");
    By localizadorNombreYApellidoComprobante = By.xpath("//*[@id=\"formData.paymentData.cashPayments[0].invoice.fiscalName\"]//input");
    By localizadorDNI = By.xpath("//*[@id=\"invoice-fiscal-identification-number-0\"]");
    By localizadorDireccion = By.xpath("//*[@id=\"formData.paymentData.cashPayments[0].invoice.fiscalAddress.street\"]//input");
    By localizadorNombre = By.xpath("//*[@id=\"formData.travelers[0].firstName\"]//input");
    By localizadorApellido = By.xpath("//*[@id=\"formData.travelers[0].lastName\"]//input");
    By localizadorAerolinea = By.xpath("//*[@id=\"transfer-info-departure-airline-0\"]");
    By localizadorNumeroDeVuelo = By.xpath("//*[@id=\"transfer-info-departure-flightNumber-0\"]");
    By localizadorEmail = By.xpath("//input[@class='contact-email input-tag ng-untouched ng-pristine ng-invalid']");
    By localizadorConfirmarEmail = By.xpath("//*[@id=\"checkout-content\"]//email-address//input-component[2]//input");
    By localizadorCodigoDeArea = By.xpath("//*[@id=\"formData.contactData.phones[0].areaCode\"]//input");
    By localizadorNumeroDeTel = By.xpath("//*[@id=\"formData.contactData.phones[0].number\"]//input");
    By localizadorComprarTraslado = By.id("buy-button");
    By localizadorMensaje = By.xpath("//checkbox-component//span[2]");


    @BeforeClass
    public static void init() {
        System.out.println("Init");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        System.out.println("SetUp");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        this.smallWait = new WebDriverWait(driver, 5);
        this.bigWait = new WebDriverWait(driver, 20);
        this.seccionTrasladosLocalizador = By.xpath("//a[@title='Traslados']");
        this.aeropuerto = "Aeropuerto Arturo Merino Benitez";
        this.hotel = "Santiago Marriott Hotel";
    }

    @Test
    public void denegarCompraSinTerminosYCondicionesAceptados() {
        // Carga la página web
        driver.get(url);
        // 2) Clickea 'Traslados' en la barra de navegacion
        this.smallWait.until(ExpectedConditions.elementToBeClickable(this.seccionTrasladosLocalizador));
        driver.findElement(this.seccionTrasladosLocalizador).click();
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorInputAeropuerto));
        // Valida ubicacion en 'Traslados'
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("traslados"));
        // 3) Ingresa el aeropuerto
        driver.findElement(localizadorInputAeropuerto).sendKeys(this.aeropuerto);
        // 4) Selecciona la primer opción
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorPrimeraOpcionAeropuerto));
        driver.findElement(localizadorPrimeraOpcionAeropuerto).click();
        // 5) Ingresa el hotel
        driver.findElement(localizadorInputHotel).sendKeys(this.hotel);
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorPrimeraOpcionHotel));
        driver.findElement(localizadorPrimeraOpcionHotel).click();
        // 6) Ingresa fecha en el campo 'Arribo'
        driver.findElement(localizadorFechaArribo).click();
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorFechaElegida));
        driver.findElement(localizadorFechaElegida).click();
        // 7) Ingresa horario en el campo 'Hora'
        Select hora = new Select(driver.findElement(localizadorHora));
        hora.selectByIndex(30);
        // 8) Clickea boton 'Buscar'
        driver.findElement(localizadorBuscar).click();
        // 9) Espera a que cargue la página
        this.bigWait.until(ExpectedConditions.elementToBeClickable(localizadorComprar));
        // 10) Clickea boton 'Comprar'
        driver.findElement(localizadorComprar).click();
        // 11) Clickea la primer opcion de pago "Transferencia Bancaria"
        this.bigWait.until(ExpectedConditions.elementToBeClickable(localizadorMetodoDePago));
        driver.findElement(localizadorMetodoDePago).click();
        // 12) Selecciona la primera opción
        Select banco = new Select(driver.findElement(localizadorBanco));
        banco.selectByIndex(1);
        // 13) Rellena campos de la seccion comprobante de pago
        driver.findElement(localizadorNombreYApellidoComprobante).sendKeys("prueba");
        driver.findElement(localizadorDNI).sendKeys("004340922");
        driver.findElement(localizadorDireccion).sendKeys("prueba");
        // 14) Rellena campos de la seccion 'Quiénes viajan?'
        driver.findElement(localizadorNombre).sendKeys("prueba");
        driver.findElement(localizadorApellido).sendKeys("prueba");
        // 15) Rellena campos de la seccion 'Información adicional'
        WebElement aerolinea = driver.findElement(localizadorAerolinea);
        aerolinea.sendKeys("aerolineas");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        aerolinea.sendKeys(Keys.ARROW_DOWN);
        aerolinea.sendKeys(Keys.ENTER);
        driver.findElement(localizadorNumeroDeVuelo).sendKeys("1");
        // 16) Rellena campos de la seccion 'A dónde enviamos tus vouchers?'
        driver.findElement(localizadorEmail).sendKeys("prueba@gmail.com");
        driver.findElement(localizadorConfirmarEmail).sendKeys("prueba@gmail.com");
        // 17) Rellena campos de la seccion 'A qué número podemos llamarte?'
        driver.findElement(localizadorCodigoDeArea).sendKeys("42");
        driver.findElement(localizadorNumeroDeTel).sendKeys("32414");
        // 18) Clickea boton 'Comprar'
        driver.findElement(localizadorComprarTraslado).click();
        // Valida mensaje de error
        String msj = driver.findElement(localizadorMensaje).getText();
        assertEquals("Acepta los términos y condiciones", msj);
    }

    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }
}
