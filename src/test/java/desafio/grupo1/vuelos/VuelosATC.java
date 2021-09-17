package desafio.grupo1.vuelos;

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

import static org.junit.Assert.*;

public class VuelosATC {

    WebDriver driver;
    final String url = "https://www.viajesfalabella.cl/";
    private String origen, destino;
    private By seccionVuelosLocalizador;
    private WebDriverWait smallWait, bigWait;
    // Localizadores comunes:
    By localizadorInputOrigen = By.xpath("//input[@class='input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-origin-input sbox-primary sbox-places-first places-inline']");
    By localizadorInputDestino = By.xpath("//input[@class='input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-destination-input sbox-secondary sbox-places-second places-inline']");
    By localizadorSiguiente = By.xpath("//div[@id='clusters']/span[1]//span[contains(text(),'Siguiente')]");
    By localizadorContinuar = By.xpath("//a[@class=\"eva-3-btn -primary -lg\"]");
    By localizadorFechaNoDecidida = By.xpath("//i[@class=\"checkbox-check sbox-3-icon-checkmark -mr1 sbox-ui-icon\"]");
    By localizadorBuscar = By.xpath("//div[@class='sbox-button -ml3-l']//a[@class='sbox-3-btn -primary -md sbox-search']");
    By localizadorTituloDeBusqueda = By.xpath("//h1[@class=\"landingTitle\"]");
    // Localizadores ATC01:
    By localizadorComprar = By.id("buy-button");
    By localizadorErrorTarjeta = By.xpath("//p[@class='eva-3-p -eva-3-tc-red-3 -invalid']");
    By localizadorErrorNombre = By.xpath("//*[@id=\"formData.travelers[0].firstName\"]//span");
    By localizadorErrorApellido = By.xpath("//*[@id=\"formData.travelers[0].lastName\"]//span");
    By localizadorErrorDia = By.xpath("//*[@id=\"formData.travelers[0].birthdate.day\"]//span");
    By localizadorErrorMes = By.xpath("//*[@id=\"formData.travelers[0].birthdate.month\"]//span");
    By localizadorErrorAño = By.xpath("//*[@id=\"formData.travelers[0].birthdate.year\"]//span");
    By localizadorErrorEmail = By.xpath("//div[@class=\"-md -top-left chk-input eva-3-input eva-3-validation-inline -invalid\"]//span");
    By localizadorErrorArea = By.xpath("//*[@id=\"formData.contactData.phones[0].areaCode\"]//span");
    By localizadorErrorNumero = By.xpath("//*[@id=\"formData.contactData.phones[0].number\"]//span");
    By localizadorErrorTerminos = By.xpath("//terms-checkbox-component//span[@class='validation-msg']");
    // Localizadores ATC02:
    By localizadorInputNombre = By.xpath("//*[@id=\"formData.travelers[0].firstName\"]//input");
    // Localizadores ATC03:
    By localizadorFechaIda = By.xpath("//div[@class='input-container sbox-bind-event-click-start-date']/input[@placeholder='Ida']");
    By localizadorFechaHoy = By.cssSelector("span._dpmg2--today");
    By localizadorFechasDeEsteMes = By.cssSelector("div._dpmg2--month-active > div._dpmg2--dates > span._dpmg2--available");
    By localizadorDia3MesProximo = By.cssSelector("//div[@class='_dpmg2--month _dpmg2--o-5'][1]//span[contains(@class,'_dpmg2--available')][3]");
    By localizadorDia2MesProximo = By.cssSelector("//div[@class='_dpmg2--month _dpmg2--o-5'][1]//span[contains(@class,'_dpmg2--available')][2]");
    // Localizadores ATC04:
    By localizadorOrigenDestinoPrimeraOpcion = By.xpath("//div[@class='ac-group-container'][1]//li[@class='item'][1]");
    By localizadorTiposDePasaje = By.xpath("//label[@class='radio-label-container']");
    By localizadorAgregarMenor = By.xpath("//*[@class=\"steppers-icon-right eva-3-icon-plus\"]");
    By localizadorEdadDelMenor = By.id("eva-select");
    By localizadorDiaNacimientoMenor = By.id("traveler-birthday-day-1");
    By localizadorMesNacimientoMenor = By.id("traveler-birthday-month-1");
    By localizadorAñoNacimientoMenorOpciones = By.xpath("//*[@id=\"traveler-birthday-year-1\"]/option");
    By localizadorAñoNacimientoMenor = By.id("traveler-birthday-year-1");
    By localizadorErrorEdadMenor = By.xpath("//*[@id=\"formData.travelers[1].birthdate.day\"]//validation-error");

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
        this.seccionVuelosLocalizador = By.xpath("//a[@title='Vuelos']");
        this.origen = "Santiago";
        this.destino = "México";
    }

    @Test
    public void ATC01_RechazoCompraVuelo() {
        this.irASeccionCompra(); // Lo separo ya que otra prueba lo va a requerir
        // 12) Clickear boton 'Comprar'
        driver.findElement(localizadorComprar).click();
        // Validaciones:
        // Valida mensaje de error de la tarjeta
        assertEquals("Elige la tarjeta con la que quieres pagar", driver.findElement(localizadorErrorTarjeta).getText());
        // Valida mensaje de error en nombre
        assertTrue(driver.findElement(localizadorErrorNombre).getText().contains("Ingresa el nombre"));
        // Valida mensaje de error en apellido contains("Ingresa el apellido")
        assertTrue(driver.findElement(localizadorErrorApellido).getText().contains("Ingresa el apellido"));
        // Valida mensaje de error en día
        assertTrue(driver.findElement(localizadorErrorDia).getText().contains("Ingresa el día"));
        // Valida mensaje de error en mes
        assertTrue(driver.findElement(localizadorErrorMes).getText().contains("Ingresa el mes"));
        // Valida mensaje de error en año
        assertTrue(driver.findElement(localizadorErrorAño).getText().contains("Ingresa el año"));
        // Valida mensaje de error en email
        assertTrue(driver.findElement(localizadorErrorEmail).getText().contains("Ingresa el email"));
        // Valida mensajen de error en área
        assertTrue(driver.findElement(localizadorErrorArea).getText().contains("Campo obligatório"));
        // Valida mensaje de error en número
        assertTrue(driver.findElement(localizadorErrorNumero).getText().contains("Campo obligatório"));
        // Valida mensaje de error en términos y condiciones
        assertTrue(driver.findElement(localizadorErrorTerminos).getText().contains("Acepta los términos y condiciones"));
    }

    @Test
    public void ATC02_NoGuardarDatosDeCompra() {
        this.irASeccionCompra();
        WebElement inputNombre = driver.findElement(localizadorInputNombre);
        // 13) Llena campo 'Nombres'
        inputNombre.sendKeys("prueba");
        // 14) Retrocede a la página anterior
        driver.navigate().back();
        // 15) Confirma el alert
        driver.switchTo().alert().accept();
        // 16) Espera que cargue la página
        this.bigWait.until(ExpectedConditions.elementToBeClickable(localizadorSiguiente));
        // 17) Clickea boton 'Siguiente'
        driver.findElement(localizadorSiguiente).click();
        // 18) Clickea boton 'Continuar'
        driver.findElement(localizadorContinuar).click();
        // 19) Espera que cargue la página
        this.bigWait.until(ExpectedConditions.elementToBeClickable(localizadorComprar));
        // Valida que el campo 'Nombres' este vacío
        inputNombre = driver.findElement(localizadorInputNombre);
        assertEquals(inputNombre.getText(), "");
    }

    @Test
    public void ATC03_ReseteoFechaIda() {
        this.irASeccionVuelos();
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorFechaIda));
        WebElement inputFechaIda = driver.findElement(localizadorFechaIda);
        inputFechaIda.click();
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorFechaHoy));
        List<WebElement> diasDisponibles = driver.findElements(localizadorFechasDeEsteMes);
        if (Integer.parseInt(diasDisponibles.get(0).getText().replace("\nHOY", "")) < 25) {
            diasDisponibles.get(3).click(); // 2)
            diasDisponibles.get(2).click(); // 3)
        } else { // Si hoy es mayor al dia 25 clickeo dias del proximo mes
            driver.findElement(localizadorDia3MesProximo).click();// 2)
            driver.findElement(localizadorDia2MesProximo).click();// 3)
        }
        assertEquals("", inputFechaIda.getText());
    }

    @Test
    public void ATC04_DenegarFechaNacimientoDeMenor() {
        this.irASeccionVuelos();
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorInputOrigen));
        // 3) Click input 'solo ida'
        driver.findElements(localizadorTiposDePasaje).get(1).click();
        // 4) Ingresar origen en el input origen
        WebElement inputOrigen = driver.findElement(localizadorInputOrigen);
        inputOrigen.sendKeys(this.origen);
        // Espera a que salgan las opciones de autocompletado
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorOrigenDestinoPrimeraOpcion));
        // 5) Presionar TAB
        inputOrigen.sendKeys(Keys.TAB);
        // 6) Ingresar destino en el input destino
        WebElement inputDestino = driver.findElement(localizadorInputDestino);
        inputDestino.sendKeys(this.destino);
        // 7) Presionar ENTER
        // Espera a que salgan las opciones de autocompletado
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorOrigenDestinoPrimeraOpcion));
         inputDestino.sendKeys(Keys.ENTER);
        // 8) Clickear checkbox
        driver.findElement(localizadorFechaNoDecidida).click();
        // 9) Clickear 'Buscar'
        driver.findElement(localizadorBuscar).click();
        // 10) Esperar a que cargue la página
        this.bigWait.until(ExpectedConditions.elementToBeClickable(localizadorSiguiente));
        String h1 = driver.findElement(localizadorTituloDeBusqueda).getText();
        // Valida la busqueda
        assertTrue(h1.contains("Vuelos a") && h1.contains(this.destino));
        // 11) Clickear boton 'Siguiente'
        driver.findElement(localizadorSiguiente).click();
        // 12) Agregar un menor
        driver.findElements(localizadorAgregarMenor).get(1).click();
        // 13) Seleccionar la edad del menor
        Select edadMenor = new Select(driver.findElement(localizadorEdadDelMenor));
        edadMenor.selectByValue("6");
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorContinuar));
        // 14) Clickear boton 'Continuar'
        driver.findElement(localizadorContinuar).click();
        // 15) Valida ubicacion en la seccion de compra del vuelo
        this.bigWait.until(ExpectedConditions.elementToBeClickable(localizadorComprar));
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("checkout"));
        // 16) Seleccionar la opcion 1 del input dia
        Select dia = new Select(driver.findElement(localizadorDiaNacimientoMenor));
        dia.selectByIndex(1);
        // 17) Seleccionar la opcion 1 del input mes
        Select mes = new Select(driver.findElement(localizadorMesNacimientoMenor));
        mes.selectByIndex(1);
        // 18) Seleccionar año mas antiguo
        List<WebElement> años = driver.findElements(localizadorAñoNacimientoMenorOpciones);
        Select año = new Select(driver.findElement(localizadorAñoNacimientoMenor));
        año.selectByIndex(años.size()-1);
        // Valida mensaje de error
        String msj = driver.findElement(localizadorErrorEdadMenor).getText();
        assertEquals("La fecha de nacimiento ingresada no coincide con el rango de edad de un pasajero menor", msj);
    }

    private void irASeccionVuelos() {
        // Cargar la página web
        driver.get(url);
        this.smallWait.until(ExpectedConditions.elementToBeClickable(seccionVuelosLocalizador));
        // 1) Busco seccion "Vuelos"
        WebElement seccionVuelos = driver.findElement(seccionVuelosLocalizador);
        seccionVuelos.click();
    }

    private void irASeccionCompra() {
        // Declaro localizadores para poder aprovechar después que se espere hasta que sean clickeables
        By inputOrigenLocalizador = By.xpath("//input[@class='input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-origin-input sbox-primary sbox-places-first places-inline']");
        By botonSiguiente = By.xpath("//*[@id=\"clusters\"]/span[1]/div/span/reduced-cluster/div/div/div/div/div[2]/span[3]/div/span");

        this.irASeccionVuelos();
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorInputOrigen));
        // Valida ubicacion en la seccion 'Vuelos'
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("vuelos"));
        WebElement inputOrigen = driver.findElement(localizadorInputOrigen);
        // 2) Ingresa dato origen en el campo
        inputOrigen.sendKeys(this.origen);
        // Espera a que salgan las opciones de autocompletado
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorOrigenDestinoPrimeraOpcion));
        // 3) Presiona TAB
        inputOrigen.sendKeys(Keys.TAB);
        // 4) Ingresa dato destino en el campo
        WebElement inputDestino = driver.findElement(localizadorInputDestino);
        inputDestino.sendKeys(this.destino);
        // Espera a que salgan las opciones de autocompletado
        this.smallWait.until(ExpectedConditions.elementToBeClickable(localizadorOrigenDestinoPrimeraOpcion));
        // 5) Presiona ENTER
        inputDestino.sendKeys(Keys.ENTER);
        // 6) Selecciona opcion de fecha no decidida
        WebElement checkboxFecha = driver.findElement(localizadorFechaNoDecidida);
        checkboxFecha.click();
        // 7) Clickea boton 'Buscar'
        WebElement botonBuscar = driver.findElement(localizadorBuscar);
        botonBuscar.click();
        // 8) Espera que cargue la página
        this.bigWait.until(ExpectedConditions.elementToBeClickable(localizadorSiguiente));
        String h1 = driver.findElement(localizadorTituloDeBusqueda).getText();
        // Valida la busqueda
        assertTrue(h1.contains("Vuelos a") && h1.contains(this.destino));
        // 9) Selecciona la primera opcion de la busqueda
        driver.findElement(localizadorSiguiente).click();
        // 10) Clickea boton 'Siguiente'
        driver.findElement(localizadorContinuar).click();
        // 11) Espera que cargue la página
        this.bigWait.until(ExpectedConditions.elementToBeClickable(localizadorComprar));
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
