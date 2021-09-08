package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tc_paquete {

    WebDriver driver;

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_P01 (){

        //Cargar HOME
        //driver.get("https://www.viajesfalabella.cl/");
       // WebElement Paquete = driver.findElement(By.xpath("//h3[contains(text(),'Cancún saliendo de Santiago de Chile'");



    }

    @Test
    public void TC_P04 (){

    }

    @Test
    public void TC_P002 (){

    }

    @Test
    public void TC_P004 (){

    }

    @After
    public void close() {

        if (driver != null) {
            driver.close();
        }

    }
}
