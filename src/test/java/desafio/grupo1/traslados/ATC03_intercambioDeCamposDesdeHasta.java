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

public class ATC03 {

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
        this.seccionTrasladosLocalizador = By.xpath("//body/nav/div[2]/div/div[3]/ul/li[6]/a");
        this.aeropuerto = "Santiago";
        this.hotel = "Hotel";
    }

    @Test
    public void intercambioDeCamposDesdeHasta() {
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
        WebElement inputAeropuerto = driver.findElement(localizadorInputAeropuerto);
        inputAeropuerto.sendKeys(this.aeropuerto);
        // 4) Selecciona la primer opción
        By primerAeropuerto = By.xpath("//body/div[15]/div/div/ul/li[1]");
        this.smallWait.until(ExpectedConditions.elementToBeClickable(primerAeropuerto));
        driver.findElement(primerAeropuerto).click();
        String aeropuertoSeleccionado = inputAeropuerto.getText();
        // 5) Ingresa el hotel
        WebElement inputHotel = driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div/input"));
        inputHotel.sendKeys(this.hotel);
        // 6) Selecciona la primer opción
        By primerHotel = By.xpath("//body/div[15]/div/div/ul/li[1]");
        this.smallWait.until(ExpectedConditions.elementToBeClickable(primerHotel));
        driver.findElement(primerHotel).click();
        String hotelSeleccionado = inputHotel.getText();
        // 7) Clickea 'Hacia el aeropuerto'
        driver.findElement(By.xpath("//span[@class=\"sbox-3-radio -md sbox-radio-button\"][2]/label")).click();
        By desdeAeropuerto = By.xpath("//span[@class=\"sbox-3-radio -md sbox-radio-button\"][1]/label");
        this.smallWait.until(ExpectedConditions.elementToBeClickable(desdeAeropuerto));
        // Valida el cambio de campos
        String campoDesde = driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div/input")).getText();
        String campoHasta = driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/div/div/input")).getText();
        assertEquals(hotelSeleccionado, campoDesde);
        assertEquals(aeropuertoSeleccionado, campoHasta);
        // 8) Clickea 'Desde el aeropuerto'
        driver.findElement(desdeAeropuerto).click();
        // Valida el cambio de campos
        campoDesde = inputAeropuerto.getText();
        campoHasta = inputHotel.getText();
        assertEquals(aeropuertoSeleccionado, campoDesde);
        assertEquals(hotelSeleccionado, campoHasta);
    }

    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }

}