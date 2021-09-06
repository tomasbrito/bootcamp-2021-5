package junit.imiguez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//https://the-internet.herokuapp.com/dynamic_loading/1
public class ManejoDeWaits {

    WebDriver driver;

    @BeforeClass
    public static void init() {
        System.out.println("Init");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        System.out.println("SetUp");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //Implicit Wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void explicitWait() {
        WebDriverWait exWait = new WebDriverWait(driver, 10);

    }

    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }

}
