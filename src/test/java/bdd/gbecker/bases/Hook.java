package bdd.gbecker.bases;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {

    protected WebDriver driver;

    @Before(order = 0)
    public static void initialiseBrowser() {
        WebDriverManager.chromedriver().setup();
    }

    @Before(order = 1)
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void cleanup() {
        //    if (driver != null) driver.close();
    }
}
