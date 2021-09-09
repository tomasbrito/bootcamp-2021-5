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

public class ATC04 {

    WebDriver driver;
    private String aeropuerto, hotel;
    private By seccionTrasladosLocalizador;
    private WebDriverWait smallWait, bigWait;

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
        driver.get("https://www.viajesfalabella.cl/");
        // 2) Clickea 'Traslados' en la barra de navegacion
        this.smallWait.until(ExpectedConditions.elementToBeClickable(this.seccionTrasladosLocalizador));
        driver.findElement(this.seccionTrasladosLocalizador).click();
        By localizadorInputAeropuerto = By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/div/div/input");
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorInputAeropuerto));
        // Valida ubicacion en 'Traslados'
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("traslados"));
        // 3) Ingresa el aeropuerto
        driver.findElement(localizadorInputAeropuerto).sendKeys(this.aeropuerto);
        // 4) Selecciona la primer opción
        By primerAeropuerto = By.xpath("//body/div[15]/div/div/ul/li[1]");
        this.smallWait.until(ExpectedConditions.elementToBeClickable(primerAeropuerto));
        driver.findElement(primerAeropuerto).click();
        // 5) Ingresa el hotel
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div/input")).sendKeys(this.hotel);
        By primerHotel = By.xpath("//body/div[15]/div/div/ul/li[1]");
        this.smallWait.until(ExpectedConditions.elementToBeClickable(primerHotel));
        driver.findElement(primerHotel).click();
        // 6) Ingresa fecha en el campo 'Arribo'
        driver.findElement(By.xpath("//input[@class=\"input-tag sbox-checkin\"]")).click();
        By fecha = By.xpath("//body/div[3]/div/div[5]/div[2]/div[4]/span[1]");
        this.smallWait.until(ExpectedConditions.elementToBeClickable(fecha));
        driver.findElement(fecha).click();
        // 7) Ingresa horario en el campo 'Hora'
        Select hora = new Select(driver.findElement(By.xpath("//div[@class=\"select-container\"]/select[@class='select-tag sbox-time-arrival']")));
        hora.selectByIndex(30);
        // 8) Clickea boton 'Buscar'
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[5]/div")).click();////a[@class='sbox-3-btn -primary -md sbox-search']
        // 9) Espera a que cargue la página
        By botonComprar = By.xpath("//div[@class='search-cluster ng-scope'][1]//button");////div[@class='search-cluster ng-scope'][1]//button
        this.bigWait.until(ExpectedConditions.elementToBeClickable(botonComprar));
        // 10) Clickea boton 'Comprar'
        driver.findElement(botonComprar).click();
        // 11) Clickea la primer opcion de pago "Transferencia Bancaria"
        By metodoDePago = By.xpath("//payment-method-selector//li[2]//label");
        this.bigWait.until(ExpectedConditions.elementToBeClickable(metodoDePago));
        driver.findElement(metodoDePago).click();
        // 12) Selecciona la primera opción
        Select banco = new Select(driver.findElement(By.xpath("//*[@id='card-selector-0']")));
        banco.selectByIndex(1);
        // 13) Rellena campos de la seccion comprobante de pago
        driver.findElement(By.xpath("//*[@id=\"formData.paymentData.cashPayments[0].invoice.fiscalName\"]//input")).sendKeys("prueba");
        driver.findElement(By.xpath("//*[@id=\"invoice-fiscal-identification-number-0\"]")).sendKeys("004340922");
        driver.findElement(By.xpath("//*[@id=\"formData.paymentData.cashPayments[0].invoice.fiscalAddress.street\"]//input")).sendKeys("prueba");
        // 14) Rellena campos de la seccion 'Quiénes viajan?'
        driver.findElement(By.xpath("//*[@id=\"formData.travelers[0].firstName\"]//input")).sendKeys("prueba");
        driver.findElement(By.xpath("//*[@id=\"formData.travelers[0].lastName\"]//input")).sendKeys("prueba");
        // 15) Rellena campos de la seccion 'Información adicional'
        WebElement aerolinea = driver.findElement(By.xpath("//*[@id=\"transfer-info-departure-airline-0\"]"));
        aerolinea.sendKeys("aerolineas");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        aerolinea.sendKeys(Keys.ARROW_DOWN);
        aerolinea.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"transfer-info-departure-flightNumber-0\"]")).sendKeys("1");
        // 16) Rellena campos de la seccion 'A dónde enviamos tus vouchers?'
        driver.findElement(By.xpath("//input[@class='contact-email input-tag ng-untouched ng-pristine ng-invalid']")).sendKeys("prueba@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"checkout-content\"]//email-address//input-component[2]//input")).sendKeys("prueba@gmail.com");
        // 17) Rellena campos de la seccion 'A qué número podemos llamarte?'
        driver.findElement(By.xpath("//*[@id=\"formData.contactData.phones[0].areaCode\"]//input")).sendKeys("42");
        driver.findElement(By.xpath("//*[@id=\"formData.contactData.phones[0].number\"]//input")).sendKeys("32414");
        // 18) Clickea boton 'Comprar'
        driver.findElement(By.id("buy-button")).click();
        // Valida mensaje de error
        String msj = driver.findElement(By.xpath("//checkbox-component/span/span[2]")).getText();
        assertEquals("Acepta los términos y condiciones", msj);
    }

    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }
}
