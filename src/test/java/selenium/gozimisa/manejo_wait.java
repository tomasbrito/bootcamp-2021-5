package selenium.gozimisa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class manejo_wait {
    WebDriver driver;
    By barraBusqueda = By.xpath("//*[@id='search_query_top']"); //en el navegador inspeccionar elemento y copiar XPath o select para css

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();//borrar cookies
        driver.manage().window().maximize();


        //tiempo de espera
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //em general no se utiliza

    }

    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }

    @Test
    public void explicitWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        By localizadorAEsperar = By.xpath("//h4[contains(text(),'Hello World!')]");

        WebDriverWait exwait= new WebDriverWait(driver, 10);

        WebElement btnStart = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));

        btnStart.click();
        //espera explicita
        exwait.until(ExpectedConditions.elementToBeClickable(localizadorAEsperar));

        WebElement hello=driver.findElement(localizadorAEsperar);
        Assert.assertEquals("Hello World",hello.getText());


    }

    @Test
    public void fluentWait(){
        //se usa en llamadas asincronas
        FluentWait<WebDriver> fluwair = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis((100))).withMessage("error time out").ignoring(NoSuchElementException.class);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        By localizadorAEsperar = By.xpath("//h4[contains(text(),'Hello World!')]");

        WebDriverWait exwait= new WebDriverWait(driver, 10);

        WebElement btnStart = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));

        btnStart.click();
        //espera explicita
        exwait.until(ExpectedConditions.elementToBeClickable(localizadorAEsperar));

        WebElement hello=driver.findElement(localizadorAEsperar);
        Assert.assertEquals("Hello World",hello.getText());
    }


}
