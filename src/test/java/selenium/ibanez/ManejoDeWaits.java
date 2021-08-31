package selenium.ibanez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ManejoDeWaits {
    @BeforeClass
    public static void init(){ WebDriverManager.edgedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
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








}
