package selenium.sespinoza;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class atc04_EncontrarProductoDeListaDinamica {
    WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.edgedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();

    }

    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            //driver.close();
        }
    }

    @Test
    public void atc01() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php?id_product=2&controller=product&search_query=Blouse&results=1");
        System.out.println("se abre url");
        waitForElement(driver, By.xpath("//*[@id=\"uniform-group_1\"]")).click();
        waitForElement(driver, By.xpath("//*[@id=\"group_1\"]/option[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"color_8\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")).getText(),"1");

    }

    private WebElement waitForElement(WebDriver driver, By locator) {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(locator));
    }

}
