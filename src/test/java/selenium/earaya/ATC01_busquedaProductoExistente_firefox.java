package selenium.earaya;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//atc: automatic test case
public class ATC01_busquedaProductoExistente_firefox {

    WebDriver driver;
    By barraBusqueda = By.xpath("//*[@id='search_query_top']");

    @BeforeClass
    public static void init(){
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();

    }

    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }

    @Test
    public void atc01(){
        driver.get("http://automationpractice.com/index.php");
        System.out.println("se abre url");
        driver.findElement(barraBusqueda).sendKeys("chiffon dress");
        System.out.println("se tipea en el objeto");
        driver.findElement(By.cssSelector("button.btn:nth-child(5)")).click();
        System.out.println("se presiona boton buscar");
        //validar - assert
        String urlActual = driver.getCurrentUrl();
        if (urlActual.contains("submit_search=")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }

    }

}
