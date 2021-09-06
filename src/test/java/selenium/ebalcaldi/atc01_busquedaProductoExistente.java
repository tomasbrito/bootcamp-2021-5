package selenium.ebalcaldi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class atc01_busquedaProductoExistente {
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

    }
    @After
    public void close(){
        System.out.println("After");
        if(driver !=null){
            driver.close();
        }
    }

    @Test
    public void atc01(){
        By busqueda = By.xpath("//*[@id=\"search_query_top\"]");
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(busqueda).sendKeys("chiffon dress");
        driver.findElement(By.cssSelector("#searchbox > button")).click();
        //validar
        String urlActual = driver.getCurrentUrl();
        if(urlActual.contains("submit_search=")){
            Assert.assertTrue(true);

            System.out.println("Validado");
        }else{
            Assert.fail();
            System.out.println("Se rompio");
        }


   }



}
