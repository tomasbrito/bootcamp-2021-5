package selenium.earaya;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ATC04 {

    WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
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

    @Test
    public void atc04() throws InterruptedException {

        driver.get("http://automationpractice.com/");
        WebElement source = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        source.sendKeys("blo");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='index']/div[2]/ul/li")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='product_reference']")).getText());
        if(driver.findElement(By.xpath("//*[@id='product_reference']")).getText().contains("Model demo_2")){
            System.out.println("Success");
        } else {
            System.out.println(("Error"));
        }
    }
}
