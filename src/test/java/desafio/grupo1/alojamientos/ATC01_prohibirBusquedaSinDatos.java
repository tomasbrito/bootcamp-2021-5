package desafio.grupo1.alojamientos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ATC01_prohibirBusquedaSinDatos {

    WebDriver driver;
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String HOTELES_URL = "https://www.viajesfalabella.cl/hoteles/";
    final String entradaMsg = "Ingresa una fecha de entrada.";
    final String salidaMsg = "Ingresa una fecha de salida.";

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
    public void atc01() {
        driver.get(BASE_URL);
        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@product=\"HOTELS\"]")).click();
        Assert.assertEquals(HOTELES_URL, driver.getCurrentUrl());

        driver.findElement(By.linkText("Buscar")).click();
        List<WebElement> validationTooltips =
                driver.findElement(By.className("sbox-dates"))
                        .findElements(By.className("validation-msg"));

        String entradaTooltipMsg = validationTooltips.get(0).getText();
        String salidaTooltipMsg = validationTooltips.get(1).getText();

        Assert.assertEquals(entradaMsg, entradaTooltipMsg);
        Assert.assertEquals(salidaMsg, salidaTooltipMsg);
    }

    @After
    public void cleanup() {
        if (driver != null) driver.close();
    }

}
