package desafio.grupo1.vuelos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.*;

public class VuelosATC {

    WebDriver driver;
    private String origen, destino;
    private By seccionVuelosLocalizador;
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
        this.seccionVuelosLocalizador = By.xpath("//body/nav/div[2]/div/div[3]/ul/li[2]/a");
        this.origen = "Santiago";
        this.destino = "México";
    }

    @Test
    public void ATC01_RechazoCompraVuelo() {
        this.irASeccionCompra(); // Lo separo ya que otra prueba lo va a requerir
        driver.findElement(By.id("buy-button")).click(); // 12)
        // Validaciones:
        assertEquals("Elige la tarjeta con la que quieres pagar", driver.findElement(By.xpath("//card-storage/div/div/p")).getText()); // Valida mensaje de error de la tarjeta
        assertTrue(driver.findElement(By.xpath("//*[@id=\"formData.travelers[0].firstName\"]/div/div/validation-error/span")).getText().contains("Ingresa el nombre")); // Valida mensaje de error en nombre
        assertTrue(driver.findElement(By.xpath("//*[@id=\"formData.travelers[0].lastName\"]/div/div/validation-error/span"))
                .getText().contains("Ingresa el apellido")); // Valida mensaje de error en apellido contains("Ingresa el apellido")
        assertTrue(driver.findElement(By.xpath("//*[@id=\"formData.travelers[0].identifications[0].number\"]/div/div/validation-error/span"))
                .getText().contains("Ingresa el número de documento")); // Valida mensaje de error en DNI
        assertTrue(driver.findElement(By.xpath("//*[@id=\"formData.travelers[0].birthdate.day\"]/div/validation-error/span"))
                .getText().contains("Ingresa el día")); // Valida mensaje de error en día
        assertTrue(driver.findElement(By.xpath("//*[@id=\"formData.travelers[0].birthdate.month\"]/div/validation-error/span"))
                .getText().contains("Ingresa el mes")); // Valida mensaje de error en mes
        assertTrue(driver.findElement(By.xpath("//*[@id=\"formData.travelers[0].birthdate.year\"]/div/validation-error/span"))
                .getText().contains("Ingresa el año")); // Valida mensaje de error en año
        assertTrue(driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/contact-email-container/contact-email/div/div/email-address/div/div/input-component[1]/div/div/div/span"))
                .getText().contains("Ingresa el email")); // Valida mensaje de error en email
        assertTrue(driver.findElement(By.xpath("//*[@id=\"formData.contactData.phones[0].areaCode\"]/validation-error/span"))
                .getText().contains("Campo obligatório")); // Valida mensajen de error en área
        assertTrue(driver.findElement(By.xpath("//*[@id=\"formData.contactData.phones[0].number\"]/validation-error/span"))
                .getText().contains("Campo obligatório")); // Valida mensaje de error en número
        assertTrue(driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/buy-component/div/agreement-component/div/ol/li/terms-checkbox-component/checkbox-component/span/span[2]"))
                .getText().contains("Acepta los términos y condiciones")); // Valida mensaje de error en términos y condiciones
    }

    @Test
    public void ATC02_NoGuardarDatosDeCompra() {
        this.irASeccionCompra();
        WebElement inputNombre = driver.findElement(By.xpath("//*[@id=\"formData.travelers[0].firstName\"]/div/div/input"));
        // 13)
        inputNombre.sendKeys("prueba");
        // 14)
        driver.navigate().back();
        // 15)
        driver.switchTo().alert().accept();
        // 16)
        this.bigWait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//*[@id=\"clusters\"]/span[1]/div/span/reduced-cluster/div/div/div/div/div[2]/span[3]/div/span")));
        driver.findElement(By.xpath("//*[@id=\"clusters\"]/span[1]/div/span/reduced-cluster/div/div/div/div/div[2]/span[3]/div/span")).click();
        // 17)
        driver.findElement(By.xpath("//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[4]/span/a")).click();
        // 18)
        this.bigWait.until(ExpectedConditions.elementToBeClickable(By.id("buy-button")));
        inputNombre = driver.findElement(By.xpath("//*[@id=\"formData.travelers[0].firstName\"]/div/div/input"));
        assertEquals(inputNombre.getText(), "");
    }

    @Test
    public void ATC03_ReseteoFechaIda() {
        // Cargar la página web
        driver.get("https://www.viajesfalabella.cl/");
        this.smallWait.until(ExpectedConditions.elementToBeClickable(seccionVuelosLocalizador));
        // 1) Busco seccion "Vuelos"
        WebElement seccionVuelos = driver.findElement(seccionVuelosLocalizador);
        seccionVuelos.click();
        this.smallWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sboxContainer-flights\"]/div/div/div[3]/div[2]/div[2]/div/div[1]/div[2]/input")));
        WebElement inputFechaIda = driver.findElement(By.xpath("//*[@id=\"sboxContainer-flights\"]/div/div/div[3]/div[2]/div[2]/div/div[1]/div[2]/input"));
        inputFechaIda.click();
        this.smallWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div._dpmg2--month-active > div._dpmg2--dates > span._dpmg2--today")));
        List<WebElement> diasDisponibles = driver.findElements(By.cssSelector("div._dpmg2--month-active > div._dpmg2--dates > span._dpmg2--available"));
        if (Integer.parseInt(diasDisponibles.get(0).getText().replace("\nHOY", "")) < 25) {
            diasDisponibles.get(3).click(); // 2)
            diasDisponibles.get(2).click(); // 3)
        } else { // Si hoy es mayor al dia 25 clickeo dias del proximo mes
            // 2)
            driver.findElement(By.cssSelector("body > div.datepicker-flights-main > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(3)")).click();
            // 3)
            driver.findElement(By.cssSelector("body > div.datepicker-flights-main > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(2)")).click();
        }
        assertEquals("", inputFechaIda.getText());
    }


    private void irASeccionCompra() {
        // Declaro localizadores para poder aprovechar después que se espere hasta que sean clickeables
        By inputOrigenLocalizador = By.xpath("//*[@id=\"sboxContainer-flights\"]/div/div/div[3]/div[2]/div[1]/div[1]/div/div/div/input");
        By botonSiguiente = By.xpath("//*[@id=\"clusters\"]/span[1]/div/span/reduced-cluster/div/div/div/div/div[2]/span[3]/div/span");
        // Cargar la página web
        driver.get("https://www.viajesfalabella.cl/");
        this.smallWait.until(ExpectedConditions.elementToBeClickable(seccionVuelosLocalizador));
        // 1) Busco seccion "Vuelos"
        WebElement seccionVuelos = driver.findElement(seccionVuelosLocalizador);
        seccionVuelos.click();
        this.smallWait.until(ExpectedConditions.elementToBeClickable(inputOrigenLocalizador));
        // Valida ubicacion en la seccion 'Vuelos'
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("vuelos"));
        WebElement inputOrigen = driver.findElement(inputOrigenLocalizador);
        // 2) Ingresa dato origen en el campo
        inputOrigen.sendKeys(this.origen);
        this.smallWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[16]/div/div/ul"))); // Espera a que salgan las opciones de autocompletado
        // 3) Presiona TAB
        inputOrigen.sendKeys(Keys.TAB);
        // 4) Ingresa dato destino en el campo
        WebElement inputDestino = driver.findElement(By.xpath("//*[@id=\"sboxContainer-flights\"]/div/div/div[3]/div[2]/div[1]/div[2]/div/div/div/div/input"));
        inputDestino.sendKeys(this.destino);
        this.smallWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[16]/div/div/ul"))); // Espera a que salgan las opciones de autocompletado
        // 5) Presiona ENTER
        inputDestino.sendKeys(Keys.ENTER);
        // 6)
        WebElement checkboxFecha = driver.findElement(By.xpath("//*[@id=\"sboxContainer-flights\"]/div/div/div[3]/div[2]/div[2]/span/label/i"));
        checkboxFecha.click();
        WebElement botonBuscar = driver.findElement(By.xpath("//*[@id=\"sboxContainer-flights\"]/div/div/div[3]/div[2]/div[4]/div/a"));
        // 7)
        botonBuscar.click();
        // 8)
        this.bigWait.until(ExpectedConditions.elementToBeClickable(botonSiguiente));
        String h1 = driver.findElement(By.xpath("//*[@id=\"flights-container\"]/div/div[1]/div[1]/div[2]/div/h1")).getText();
        // Valida la busqueda
        assertTrue(h1.contains("Vuelos a") && h1.contains(this.destino));
        // 9)
        driver.findElement(botonSiguiente).click();
        // 10)
        driver.findElement(By.xpath("//*[@id=\"passengers-modal-position\"]/passengers-modal/div/div[2]/span[4]/span/a")).click();
        // 11)
        this.bigWait.until(ExpectedConditions.elementToBeClickable(By.id("buy-button")));
        // Valida ubicacion en la seccion de compra del vuelo
        url = driver.getCurrentUrl();
        assertTrue(url.contains("checkout"));
    }

    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }

}
