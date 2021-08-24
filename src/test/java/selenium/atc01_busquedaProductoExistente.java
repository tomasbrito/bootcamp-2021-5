package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class atc01_busquedaProductoExistente {
    WebDriver driver;


    @BeforeClass
    public void  init(){
        WebDriverManager.edgedriver().setup();
    }
    @Before
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies(); // borrar cookies
        driver.manage().window().maximize(); // maximizar la ventana
    }
    @After
    public void close(){
        System.out.println("After");
        if (driver !=  )

    }


}
