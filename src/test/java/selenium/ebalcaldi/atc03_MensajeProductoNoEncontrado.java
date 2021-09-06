package selenium.ebalcaldi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class atc03_MensajeProductoNoEncontrado {
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
            //driver.close();
        }
    }

    @Test
    public void atc01(){
        By busqueda = By.cssSelector("#search_query_top");
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(busqueda).sendKeys("liquido matapulgas");
        driver.findElement(By.cssSelector("#searchbox > button")).sendKeys(Keys.ENTER);


        String urlActual = driver.getCurrentUrl();
        String mensaje = "No results were found for your search ".concat("\"liquido matapulgas\"");
        Assert.assertEquals(mensaje ,driver.findElement(By.xpath("//*[@id='center_column']/p")).getText());

    }
}
