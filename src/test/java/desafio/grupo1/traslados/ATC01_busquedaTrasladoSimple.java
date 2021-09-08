package desafio.grupo1.traslados;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class ATC01_busquedaTrasladoSimple {
    WebDriver driver;
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String TRASLADOS_URL = "https://www.viajesfalabella.cl/traslados/";
    final int TIMEOUT_SECS = 5;
    final String RESULTADO_BUSQUEDA_URL = "https://www.viajesfalabella.cl/transfer/shopping/#!/search/roundtrip/airport/";
    final String AIRPORT_NAME = "Aeropuerto Arturo Merino Benitez";
    final String HOTEL_NAME = "Hotel W Santiago";
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
    }

    @Test
    public void atc01() throws InterruptedException {

        driver.get(BASE_URL);
        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@product=\"TRANSFERS\"]")).click();
        Assert.assertEquals(TRASLADOS_URL, driver.getCurrentUrl());

        WebElement regresoCheckbox = driver.findElement(By.xpath(
                "//label[text()=\"Quiero agregar el regreso\"]"));
        regresoCheckbox.click();

        WebElement desdeInput = driver.findElement(By.className("sbox-places"))
                .findElement(By.tagName("input"));

        desdeInput.sendKeys("santiago");

        FluentWait<WebDriver> resultsFetchWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIMEOUT_SECS))
                .pollingEvery(Duration.ofMillis(500));

        By originFirstOptionBy = By.xpath("//li[@class=\"item -active\"]");

        resultsFetchWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(originFirstOptionBy, 0));
        driver.findElement(originFirstOptionBy).click();

        WebElement hastaInput = driver.findElement(By.xpath(
                "//*[@placeholder=\"Ingresa un hotel o dirección adónde quieras ir\"]\n"
        ));

        hastaInput.sendKeys("hotel w santiago");

        By destinationFirstOptionBy = By.xpath("//li[@class=\"item -active\"]");

        resultsFetchWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(destinationFirstOptionBy, 0));
        driver.findElement(destinationFirstOptionBy).click();

        WebElement arriboInput = driver.findElement(By.xpath("//input[@placeholder=\"Arribo\"]"));
        arriboInput.click();

        WebElement entradaMonth = driver.findElement(By.xpath("(//div[@data-month='" + YEAR_MONTH + "'])[2]"));
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

        WebElement aplicarButton = driver.findElement(By.xpath("(//button/*[text()=\"Aplicar\"])[2]"));
        aplicarButton.click();

        driver.findElement(By.linkText("Buscar")).click();

        resultsFetchWait.until(ExpectedConditions.urlContains(RESULTADO_BUSQUEDA_URL));

        Assert.assertTrue(driver.getCurrentUrl().contains(RESULTADO_BUSQUEDA_URL));

        List<WebElement> pointsDescriptionList = driver.findElements(By.xpath(
                "//div[@class=\"points-description\"]/ul/li"));

        String airportName = pointsDescriptionList.get(0).getText();
        String hotelName = pointsDescriptionList.get(2).getText();

        boolean isAirportNameCorrect = airportName.contains(AIRPORT_NAME);
        boolean isHotelNameCorrect = hotelName.contains(HOTEL_NAME);

        Assert.assertTrue(isAirportNameCorrect);
        Assert.assertTrue(isHotelNameCorrect);

    }

    @After
    public void cleanup() {
        if (driver != null) driver.close();
    }
}
