package selenium.ebalcaldi.grupo4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Traslado {
    static final String url = "https://www.viajesfalabella.cl/";
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
}
