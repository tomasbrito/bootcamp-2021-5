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

public class ATC04_confirmacionDePago {

    WebDriver driver;
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final int TIMEOUT_SECS = 10;
    final String RESULTADO_BUSQUEDA_URL = "www.viajesfalabella.cl/accommodations/results";
    final String HOTEL_DETAILS_URL = "https://www.viajesfalabella.cl/accommodations/detail/";
    final String TRIPS_URL = "https://www.viajesfalabella.cl/trips/";
    final String CHECKOUT_URL = "https://www.viajesfalabella.cl/checkout";



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

        driver.findElement(By.linkText("Buscar")).click();

        WebDriverWait fetchSearchResults = new WebDriverWait(driver, TIMEOUT_SECS);
        fetchSearchResults.until(ExpectedConditions.urlContains(RESULTADO_BUSQUEDA_URL));

        Assert.assertTrue(driver.getCurrentUrl().contains(RESULTADO_BUSQUEDA_URL));

        //TODO cambiar xpath
        WebElement hotelesButton = driver.findElement(By.xpath(
                "/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/aloha-results-toolbar/div[1]/div[1]/nav/div/div/ul/li[2]"));
        hotelesButton.click();

        //TODO agregar wait y cambiar xpath
        Thread.sleep(5000);

        WebElement verDetalleButton = driver.findElement(By.xpath(
                "/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div[1]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button"));
        verDetalleButton.click();

        //cambiar a la nueva pestaña
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(browserTabs.get(1));

        //TODO assert que la nueva pestaña tenga en el titulo el mismo nombre que el hotel que se eligio antes

        WebDriverWait hotelDetailsWait = new WebDriverWait(driver, TIMEOUT_SECS);
        hotelDetailsWait.until(ExpectedConditions.urlContains(HOTEL_DETAILS_URL));

        Assert.assertTrue(driver.getCurrentUrl().contains(HOTEL_DETAILS_URL));

        //TODO sleep
        Thread.sleep(5000);

        WebElement verHabitacionesButton = driver.findElement(By.xpath(
                "/html/body/aloha-app-root/aloha-detail/div/div[2]/div[2]/div/aloha-infobox-container/aloha-infobox-wrapper-container/div/div/div/aloha-infobox-shopping-content/div/div[2]/aloha-button/button/em"));
        verHabitacionesButton.click();

        //TODO sleep boton clickeable
        Thread.sleep(2000);

        WebElement reservarAhoraButton = driver.findElement(By.xpath(
                "//*[@id=\"roompacks-container-wrapper\"]/aloha-roompacks-container/aloha-roompacks-grid-container/div[2]/div[2]/aloha-reservation-summary-container/div/aloha-next-step-button/aloha-button/button/em"));
        reservarAhoraButton.click();

        //TODO capaz dejar un solo wait?
        WebDriverWait tripsListWait = new WebDriverWait(driver, TIMEOUT_SECS);
        tripsListWait.until(ExpectedConditions.urlContains(TRIPS_URL));

        Assert.assertTrue(driver.getCurrentUrl().contains(TRIPS_URL));

        Thread.sleep(5000);

        WebElement siguienteButton = driver.findElement(By.xpath(
                "/html/body/app-root/div/app-pricebox-sticky/div/div/div[1]/div/button"));
        siguienteButton.click();

        WebDriverWait checkoutWait = new WebDriverWait(driver, TIMEOUT_SECS);
        checkoutWait.until(ExpectedConditions.urlContains(CHECKOUT_URL));

        Assert.assertTrue(driver.getCurrentUrl().contains(CHECKOUT_URL));

        //TODO checkear que contenga el nombre del hotel?

    }

    @After
    public void cleanup() {
        //if (driver != null) driver.close();
    }

}
