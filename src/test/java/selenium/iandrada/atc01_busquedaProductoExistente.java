package selenium.iandrada;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//atc: Automation Test Case
public class atc01_busquedaProductoExistente {

    WebDriver driver;
    By barrabusqueda = By.xpath("//*[@id='search_query_top']");

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void Setup(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();


    }

    @After
    public void close(){
        System.out.println("After");
        if (driver != null   ){
            driver.close();
        }

    }

    @Test
    public  void atc01(){
        driver.get("http://automationpractice.com/index.php");
        System.out.println("validar");
        driver.findElement(barrabusqueda).sendKeys("chiffon dress");
        System.out.println("se tipea el objeto");
        // Validar - Asserts
        String urlActual = driver.getCurrentUrl();
        if (urlActual.contains("submit_search=")){
            Assert.assertTrue(true);
        }else {
            Assert.fail();
        }
        System.out.println(urlActual);

    }

}
