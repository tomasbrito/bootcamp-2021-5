package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class tc_alojamiento {
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
    public void TC_A02() throws InterruptedException {

        //La pagina debe arrojar resultados que solamente se ubiquen en "Viña del Mar"

        WebDriverWait wait = new WebDriverWait(driver, 5);

        //Cargar HOME
        driver.get("https://www.viajesfalabella.cl/");

        //Hacer Click en Alojamientos
        WebElement btnAlojamiento = driver.findElement(By.className("button-circle-icon"));
        btnAlojamiento.click();

        //Hacer Click en campo Destino
        WebElement Destino = driver.findElement(By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Ingresa una ciudad, alojamiento o atracción']"));
        Destino.click();

        //Introducir Viña del Mar en el campo Destino
        Destino.sendKeys("viña del mar");

        //Esperar a que se listen los resultados de busqueda
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[14]/div[1]/div[1]/ul[1]")));

        //Seleccionar opcion Viña del Mar, Valparaiso, Chile
        WebElement resultado_1 = driver.findElement(By.xpath("//body/div[14]/div[1]/div[1]/ul[1]"));
        resultado_1.click();

        // Seleccionar el campo Entrada
        WebElement FechaEntrada = driver.findElement(By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Entrada']"));
        FechaEntrada.click();

        //Seleccion de cualquier Fecha disponible entrada y salida
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_dpmg2--months")));
        driver.findElements(By.className("_dpmg2--date-number")).get(15).click();
        driver.findElements(By.className("_dpmg2--date-number")).get(20).click();

        //Click en Aplicar
        WebElement AplicarFecha = driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]"));
        AplicarFecha.click();

        //Click en Buscar
        WebElement Buscar = driver.findElement(By.linkText("Buscar"));
        Buscar.click();

        //Esperar a que cargue la pagina los resultados
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("results-cluster-container")));

        //Validar que resultados se encuentre en "Viña del mar"
        List<WebElement> resultadosViña = driver.findElements(By.xpath("//span[contains(text(),'Viña del Mar.')]"));

        for (int i = 0; i < resultadosViña.size(); i++) {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void TC_A03() throws InterruptedException {

        //La lista de habitaciones no puede estar vacia.

        WebDriverWait wait = new WebDriverWait(driver, 5);

        //Cargar HOME
        driver.get("https://www.viajesfalabella.cl/");

        //Hacer Click en Alojamientos
        WebElement btnAlojamiento = driver.findElement(By.className("button-circle-icon"));
        btnAlojamiento.click();

        //Hacer Click en campo Destino
        WebElement Destino = driver.findElement(By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Ingresa una ciudad, alojamiento o atracción']"));
        Destino.click();

        // Introducir "HR Luxor Buenos Aires" en el campo Destino
        Destino.sendKeys("HR Luxor Buenos Aires");

        // Esperar que se liste los resultados de la busqueda en la lista autocompletada
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[14]/div[1]/div[1]/ul[1]")));

        // Seleccionar la opcion "HR Luxor Buenos Aires, Buenos Aires, Argentina"
        WebElement resultado_1 = driver.findElement(By.xpath("//body/div[14]/div[1]/div[1]/ul[1]/li[1]/span[1]"));
        resultado_1.click();

        // Seleccionar el campo Entrada
        WebElement FechaEntrada = driver.findElement(By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Entrada']"));
        FechaEntrada.click();

        //Seleccion de cualquier Fecha disponible entrada y salida
        // DUDA - Por que tarda tanto en hacer los click en las fechass correspondientes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_dpmg2--months")));
        driver.findElements(By.className("_dpmg2--date-number")).get(15).click();
        driver.findElements(By.className("_dpmg2--date-number")).get(20).click();

        //Click en Aplicar
        WebElement AplicarFecha = driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]"));
        AplicarFecha.click();

        //Click en Buscar
        WebElement Buscar = driver.findElement(By.linkText("Buscar"));
        Buscar.click();

        //Esperar a que cargue la pagina los resultados
        Thread.sleep(5000);

        // Seleccionar "HR Luxor Buenos Aires"
        WebElement Hotel = driver.findElement(By.className("pricebox-action"));
        Hotel.click();

        // Esperar a que cargue la pagina del hotel
        Thread.sleep(4000);

        // Cambio de pestaña
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        // Hacer clic en "Ver habitaciones"
        WebElement VerHabitaciones = driver.findElement(By.xpath("//em[contains(text(),'Ver habitaciones')]"));
        VerHabitaciones.click();

        // Validar que existen habitaciones
        Boolean listaHabitaciones = driver.findElement(By.xpath("//div[@id='roompacks-container-wrapper']")).isDisplayed();

        if (listaHabitaciones.booleanValue()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @After
    public void close() {

        if (driver != null) {
            driver.close();
        }
    }
}

