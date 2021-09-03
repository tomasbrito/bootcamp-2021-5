package selenium.lkelly;

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
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ManejoDeWaits {

    //Tipos de esperas:
    // -Espera implicita
    // -Espera explicita
    // -FluentWait

    WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    //  Implicit wait --> se define una sola vez y sirve para toda la ejecución.
        //       findElement -->  findElements.
    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }

    @Test
    public void explicitWait(){
        WebDriverWait explicitWait = new WebDriverWait(driver,10);
        By localizadorAEsperar  = By.xpath("//h4[contains(text(),'Hello World!')]");

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement btnStart = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
        btnStart.click();
        explicitWait.until(ExpectedConditions.elementToBeClickable(localizadorAEsperar));
        WebElement hello = driver.findElement(localizadorAEsperar);
        Assert.assertEquals("Hello World!", hello.getText());
    }
    @Test
    public void fluentWait(){
        //Fluent Wait: mayor control de configuración, se usa para llamadas asincronas.
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) // Set timeout
                .pollingEvery(Duration.ofMillis(100)) // Set query/check/control interval
                .withMessage("Error de Timeout") // Set timeout message
                .ignoring(NoSuchElementException.class);
        By localizadorAEsperar  = By.xpath("//h4[contains(text(),'Hello World!')]");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement btnStart = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
        btnStart.click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(localizadorAEsperar));
        WebElement hello = driver.findElement(localizadorAEsperar);
        Assert.assertEquals("Hello World!", hello.getText());
    }

}
