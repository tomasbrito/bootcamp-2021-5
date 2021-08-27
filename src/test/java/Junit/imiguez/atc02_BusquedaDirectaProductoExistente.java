package junit.imiguez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ATC02_BusquedaDirectaProductoExistente {

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
        driver.manage().window().maximize();
    }

    @Test
    public void atc02() {
        driver.get("http://automationpractice.com/index.php");
        WebElement searchInput = driver.findElement(By.cssSelector("#search_query_top"));
        searchInput.sendKeys("printed chiffon dress");
        WebElement searchBtn = driver.findElement(By.cssSelector("#searchbox > button"));
        searchBtn.click();
        String resultado = driver.findElement(By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.right-block > h5 > a")).getText();
        Assert.assertEquals("Printed Chiffon Dress", resultado);
    }

    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }

}