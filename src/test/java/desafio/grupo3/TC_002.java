package desafio.grupo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_002 {
    WebDriver driver; // es la instancia a crear del navegador - firefox, chrome, safari

    @BeforeClass
    public static void SetUp(){
        System.out.println("Setup");
        WebDriverManager.chromedriver().setup();; //vamos a crear una instancia de Google Chrome
    }

    @Before
    public void init(){
        System.out.println("init");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();
    }

    @Test
    public void tc_002() throws InterruptedException {




    }

    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }
}
