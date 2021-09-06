package selenium.ebalcaldi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ManejoDeWaits {
    WebDriver driver;
    @BeforeClass
    public static void init(){
        WebDriverManager.edgedriver().setup();

    }

    @Before
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void close(){
        System.out.println("After");
        if(driver !=null){
            driver.close();
        }
    }
    @Test
    public void explicitWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        By localizadorAEsperar = By.xpath("//h4[contains(text(), 'Hello World!')]");
        WebDriverWait exwait = new WebDriverWait(driver, 10);
        WebElement btnStart = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        btnStart.click();
        exwait.until(ExpectedConditions.elementToBeClickable(localizadorAEsperar));
        WebElement text = driver.findElement(localizadorAEsperar);
        Assert.assertEquals("Hello World!", text.getText());
    }

    @Test
    public void fluentWait(){
        FluentWait<WebDriver> fWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .withMessage("Error de timeout")
                .ignoring(NoSuchElementException.class);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        By localizadorAEsperar = By.xpath("//h4[contains(text(), 'Hello World!')]");
        WebElement btnStart = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        btnStart.click();
        fWait.until(ExpectedConditions.elementToBeClickable(localizadorAEsperar));
        WebElement text = driver.findElement(localizadorAEsperar);
        Assert.assertEquals("Hello World!", text.getText());
    }





}
