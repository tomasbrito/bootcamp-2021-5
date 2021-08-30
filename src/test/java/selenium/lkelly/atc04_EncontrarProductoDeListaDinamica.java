package selenium.lkelly;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class atc04_EncontrarProductoDeListaDinamica {
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
    public void atc4() throws InterruptedException {
        driver.get("http://automationpractice.com/");

        driver.findElement(By.xpath("//*[@id=\'search_query_top\']"))
                .sendKeys("blo");

        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li")).click();

        String reference = driver.findElement(By.id("product_reference")).getText();

        Assert.assertEquals("Model demo_2", reference);
    }
}
