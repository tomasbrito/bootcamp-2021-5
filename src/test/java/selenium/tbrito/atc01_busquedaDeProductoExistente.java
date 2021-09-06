package selenium.tbrito;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc01_busquedaDeProductoExistente {

    WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup () {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); // borrar cookies
        driver.manage().window().maximize();
    }

    @After
    public void close () {
        if (driver != null){
            driver.close();
        }
    }

    @Test
    public void test(){
        driver.get("http://automationpractice.com/index.php");
        System.out.println("se abre url");
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("chiffon dress");
        driver.findElement(By.cssSelector("button.btn:nth-child(5)")).click();
        String urlActual = driver.getCurrentUrl();
        if (urlActual.contains("submit_search=")){
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

}
