package selenium.ebalcaldi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class atc05 {
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
        driver.findElement(busqueda).sendKeys("blo");
        driver.findElement(By.cssSelector("#search_query_top")).click();
        waitForElement(driver, By.xpath("//*[@id=\"index\"]/div[2]/ul/li")).click();




    }
    private WebElement waitForElement(WebDriver driver, By locator) {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(locator));
    }
}
