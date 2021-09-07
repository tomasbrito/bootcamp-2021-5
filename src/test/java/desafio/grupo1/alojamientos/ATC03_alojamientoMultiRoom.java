package desafio.grupo1.alojamientos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ATC03_alojamientoMultiRoom {

    WebDriver driver;
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final int TIMEOUT_SECS = 5;
    final String RESULTADO_BUSQUEDA_URL = "www.viajesfalabella.cl/accommodations/results";

    @BeforeClass
    public static void initialiseBrowser() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void atc03() {

        driver.get(BASE_URL);
        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@product=\"HOTELS\"]")).click();
        Assert.assertEquals(HOTELES_URL, driver.getCurrentUrl());

        WebElement destinoInput = driver.findElement(By.className("sbox-places"))
                .findElement(By.tagName("input"));

        destinoInput.sendKeys("santiago");

        FluentWait<WebDriver> resultsFetchWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIMEOUT_SECS))
                .pollingEvery(Duration.ofMillis(500));

        By firstOptionBy = By.xpath("//li[@class=\"item -active\"]");

        resultsFetchWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(firstOptionBy, 0));
        driver.findElement(firstOptionBy).click();


        WebElement entradaInput = driver.findElement(By.xpath("//input[@placeholder=\"Entrada\"]"));
        entradaInput.click();

        //TODO extraer año-mes
        WebElement entradaMonth = driver.findElement(By.xpath("//div[@data-month=\"2021-10\"]"));
        List<WebElement> daysList = entradaMonth.findElements(By.tagName("span"));

        //TODO extrare dias
        for (WebElement day : daysList) {
            if (day.getText().equals("1")) {
                day.click();
                break;
            }
        }

        for (WebElement day : daysList) {
            if (day.getText().equals("15")) {
                day.click();
                break;
            }
        }

        WebElement aplicarButton = driver.findElement(By.xpath("//button/*[text()=\"Aplicar\"]"));
        aplicarButton.click();

        WebElement habitacionesInput = driver.findElement(
                By.xpath("//label[text()=\"Habitaciones\"]"));

        habitacionesInput.click();

        //TODO arreglar xpaths y extraer edad
        //1er bloque
        driver.findElement(By.xpath(
                        "/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/a[1]"))
                .click();
        driver.findElement(By.xpath(
                        "/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]"))
                .click();

        WebElement firstAgeList = driver.findElement(
                By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/select"));
        Select ageListSelect = new Select(firstAgeList);
        ageListSelect.selectByValue("10");

        WebElement añadirHabitacionAnchor = driver.findElement(
                By.linkText("Añadir habitación"));
        añadirHabitacionAnchor.click();

        //TODO agregar validacion del segundo blouque
        //2do bloque
        driver.findElement(By.xpath(
                        "/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div/a[1]"))
                .click();
        driver.findElement(By.xpath(
                        "/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/a[2]"))
                .click();

        WebElement secondAgeList = driver.findElement(
                By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div/div/select"));
        Select secondAgeListSelect = new Select(secondAgeList);
        secondAgeListSelect.selectByValue("10");

        WebElement habitacionesAplicarButton = driver.findElement(
                By.linkText("Aplicar"));
        habitacionesAplicarButton.click();

        driver.findElement(By.linkText("Buscar")).click();

        WebDriverWait fetchSearchResults = new WebDriverWait(driver, TIMEOUT_SECS);
        fetchSearchResults.until(ExpectedConditions.urlContains(RESULTADO_BUSQUEDA_URL));

        Assert.assertTrue(driver.getCurrentUrl().contains(RESULTADO_BUSQUEDA_URL));

        //TODO agregar verificacion de habitaciones y personas

    }

    @After
    public void cleanup() {
        //if (driver != null) driver.close();
    }

}
