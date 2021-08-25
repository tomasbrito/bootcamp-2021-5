package selenium.gbecker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc02_BusquedaDirectaProductoExistente {
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
    public void atc02() {
        driver.get("http://automationpractice.com/");

        driver.findElement(By.cssSelector("#search_query_top"))

                .sendKeys("printed chiffon dress");

        driver.findElement(By.cssSelector("#searchbox > button")).click();

        String title = driver.findElement(By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.left-block > div > a.product_img_link"))
                .getAttribute("title");

        System.out.println(title);
        Assert.assertEquals("Printed Chiffon Dress", title);

    }

        @After
    public void close() {
        System.out.println("after");
         if (driver != null) driver.close();
    }
}
