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
    final String YEAR_MONTH = "2021-10"; // aaaa-mm
    final String ENTRADA_DAY = "1";
    final String SALIDA_DAY = "15";
    final String CHILDREN_AGE = "10";

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

        WebElement entradaMonth = driver.findElement(By.xpath("//div[@data-month='" + YEAR_MONTH + "']"));
        List<WebElement> daysList = entradaMonth.findElements(By.tagName("span"));

        for (WebElement day : daysList) {
            if (day.getText().equals(ENTRADA_DAY)) {
                day.click();
                break;
            }
        }

        for (WebElement day : daysList) {
            if (day.getText().equals(SALIDA_DAY)) {
                day.click();
                break;
            }
        }

        WebElement aplicarButton = driver.findElement(By.xpath("//button/*[text()=\"Aplicar\"]"));
        aplicarButton.click();

        WebElement habitacionesInput = driver.findElement(
                By.xpath("//label[text()=\"Habitaciones\"]"));

        habitacionesInput.click();

        List<WebElement> minusButtons = driver.findElements(By.xpath(
                "//a[contains(@class,\"steppers-icon-left\")]"));
        List<WebElement> plusButtons = driver.findElements(By.xpath(
                "//a[contains(@class,\"steppers-icon-right\")]"));

        minusButtons.get(0).click();
        plusButtons.get(1).click();

        WebElement añadirHabitacionAnchor = driver.findElement(
                By.linkText("Añadir habitación"));
        añadirHabitacionAnchor.click();

        List<WebElement> roomBlocks = driver.findElements(By.xpath(
                "//div[@class=\"_pnlpk-itemBlock\"]"));

        resultsFetchWait.until(ExpectedConditions.visibilityOf(roomBlocks.get(1)));
        Assert.assertTrue(roomBlocks.get(1).isDisplayed());

        minusButtons.get(2).click();
        plusButtons.get(3).click();

        for (int i = 0; i < 2; i++) {
            WebElement ageList = roomBlocks.get(i).findElement(By.tagName("select"));
            Select ageListSelect = new Select(ageList);
            ageListSelect.selectByValue(CHILDREN_AGE);
        }

        WebElement habitacionesAplicarButton = driver.findElement(
                By.linkText("Aplicar"));
        habitacionesAplicarButton.click();

        driver.findElement(By.linkText("Buscar")).click();

        WebDriverWait fetchSearchResults = new WebDriverWait(driver, TIMEOUT_SECS);
        fetchSearchResults.until(ExpectedConditions.urlContains(RESULTADO_BUSQUEDA_URL));

        Assert.assertTrue(driver.getCurrentUrl().contains(RESULTADO_BUSQUEDA_URL));

        List<WebElement> accommodationRoomBlocks = driver.findElements(
                By.className("stepper__room"));

        Assert.assertEquals(2, accommodationRoomBlocks.size());

    }

    @After
    public void cleanup() {
        if (driver != null) driver.close();
    }

}
