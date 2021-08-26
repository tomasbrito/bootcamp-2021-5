package selenium.iandrada;

import static org.junit.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class atc04_EncontrarProductoDeListaDinamica {


    WebDriver driver;

    @BeforeClass
    public static void init(){ WebDriverManager.chromedriver().setup();}

    @Before
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void atc04() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        searchInput.sendKeys("blo");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='index']/div[2]/ul/li")).click();
        WebElement padre = driver.findElement(By.xpath("//*[@id='product_reference']"));
        Assert.assertEquals("Model demo_2", padre.getText());
    }

    @After
    public void close() {

        if (driver != null) {
            //driver.close();
        }
    }

}
