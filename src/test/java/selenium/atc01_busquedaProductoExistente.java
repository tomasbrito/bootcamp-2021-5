package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc01_busquedaProductoExistente {

    WebDriver driver;

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void atc01() {
        //abrir navegador
        driver.get("http://automationpractice.com/");

        //buscar campo busqueda y escribir
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']"))
                .sendKeys("chiffon dress");

        //clickear boton buscar
        driver.findElement(By.cssSelector("#searchbox > button")).click();

        //buscar url actual
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        //comparar url
        if(currentUrl.contains("submit_search=")){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @After
    public void close() {
        System.out.println("after");
        // if (driver != null) driver.close();
        System.out.println("simulacion driver.close()");
    }

}

