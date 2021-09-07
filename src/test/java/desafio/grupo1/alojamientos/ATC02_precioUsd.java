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

public class ATC02_precioUsd {

    WebDriver driver;
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final int TIMEOUT_SECS = 5;
    final String RESULTADO_BUSQUEDA_QUERY = "hoteles-en-santiago+de+chile?";
    final String CURRENCY_VALUE = "USD";
    final String CURRENCY_TEXT = "US$";

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
    public void atc02() throws InterruptedException {

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

        //TODO
        WebElement checkbox = driver.findElement(By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[5]/label[1]/i[1]"));
        checkbox.click();

        driver.findElement(By.linkText("Buscar")).click();

        WebDriverWait fetchSearchResults = new WebDriverWait(driver, TIMEOUT_SECS);
        fetchSearchResults.until(ExpectedConditions.urlContains(RESULTADO_BUSQUEDA_QUERY));

        Assert.assertTrue(driver.getCurrentUrl().contains(RESULTADO_BUSQUEDA_QUERY));

        WebElement currency = driver.findElement(By.xpath("//select[@name=\"currency\"]"));
        Select currencySelect = new Select(currency);

        currencySelect.selectByValue(CURRENCY_VALUE);

        FluentWait<WebDriver> currencyChangeWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIMEOUT_SECS))
                .pollingEvery(Duration.ofMillis(300));

        By pricesListBy = By.className("landing-inline");
        WebElement spinner = driver.findElement(By.id("fullLoader"));

        currencyChangeWait.until(ExpectedConditions.invisibilityOf(spinner));

        List<WebElement> pricesList = driver.findElements(pricesListBy);
        for (WebElement price : pricesList){
            boolean isUsd = price.getText().contains(CURRENCY_TEXT);
            Assert.assertTrue(isUsd);
        }

    }

    @After
    public void cleanup() {
        if (driver != null) driver.close();
    }

}
