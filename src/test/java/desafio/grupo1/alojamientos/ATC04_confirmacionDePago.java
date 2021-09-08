package desafio.grupo1.alojamientos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ATC04_confirmacionDePago {

    WebDriver driver;
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final int TIMEOUT_SECS = 10;
    final String RESULTADO_BUSQUEDA_URL = "www.viajesfalabella.cl/accommodations/results";
    final String HOTEL_DETAILS_URL = "https://www.viajesfalabella.cl/accommodations/detail/";
    final String TRIPS_URL = "https://www.viajesfalabella.cl/trips/";
    final String CHECKOUT_URL = "https://www.viajesfalabella.cl/checkout";
    final String YEAR_MONTH = "2021-10"; // aaaa-mm
    final String ENTRADA_DAY = "1";
    final String SALIDA_DAY = "15";


    @BeforeClass
    public static void initialiseBrowser() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void atc04() throws InterruptedException {

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

        driver.findElement(By.linkText("Buscar")).click();

        WebDriverWait fetchSearchResults = new WebDriverWait(driver, TIMEOUT_SECS);
        fetchSearchResults.until(ExpectedConditions.urlContains(RESULTADO_BUSQUEDA_URL));

        Assert.assertTrue(driver.getCurrentUrl().contains(RESULTADO_BUSQUEDA_URL));

        WebElement fetchAnimationDiv = driver.findElement(By.className("-eva-3-hide"));
        resultsFetchWait.until(ExpectedConditions.invisibilityOf(fetchAnimationDiv));

        By hotelsListBy = By.className("results-cluster-container");
        resultsFetchWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(hotelsListBy));

        List<WebElement> hotelsList = driver.findElements(hotelsListBy);
        WebElement firstHotel = hotelsList.get(0);

        String hotelName = firstHotel.findElement(By.xpath(
                        "//span[contains(@class,\"accommodation-name\")]")).
                getText();
        WebElement verDetalleButton = firstHotel.findElement(By.tagName("button"));

        verDetalleButton.click();

        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(browserTabs.get(1));

        WebDriverWait hotelDetailsWait = new WebDriverWait(driver, TIMEOUT_SECS);
        hotelDetailsWait.until(ExpectedConditions.urlContains(HOTEL_DETAILS_URL));

        Assert.assertTrue(driver.getCurrentUrl().contains(HOTEL_DETAILS_URL));

        String pageHotelTitle = driver.findElement(By.className("main-info"))
                .findElement(By.tagName("h1"))
                .getText();

        Assert.assertEquals(hotelName, pageHotelTitle);

        WebElement verHabitacionesButton = driver.findElement(By.xpath(
                "//em[text()=\"Ver habitaciones\"]"));
        verHabitacionesButton.click();

        WebElement reservarAhoraButton = driver.findElement(By.xpath(
                "//em[text()=\"Reservar ahora\"]"));

        fetchSearchResults.until(ExpectedConditions.elementToBeClickable(reservarAhoraButton));
        reservarAhoraButton.click();

        fetchSearchResults.until(ExpectedConditions.urlContains(TRIPS_URL));
        Assert.assertTrue(driver.getCurrentUrl().contains(TRIPS_URL));

        By siguienteButtonBy = By.xpath("//em[text()=\"Siguiente\"]");
        resultsFetchWait.until(ExpectedConditions.presenceOfElementLocated(siguienteButtonBy));

        WebElement siguienteButton = driver.findElement(siguienteButtonBy);
        siguienteButton.click();

        resultsFetchWait.until(ExpectedConditions.urlContains(CHECKOUT_URL));
        Assert.assertTrue(driver.getCurrentUrl().contains(CHECKOUT_URL));

    }

    @After
    public void cleanup() {
        if (driver != null) driver.close();
    }

}
