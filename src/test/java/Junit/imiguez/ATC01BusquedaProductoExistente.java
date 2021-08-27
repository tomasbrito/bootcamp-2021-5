package junit.imiguez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ATC01BusquedaProductoExistente {

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
    public void atc01() {
        driver.get("http://automationpractice.com/index.php");
        WebElement searchInput = driver.findElement(new By.ByXPath("//*[@id='search_query_top']"));
        searchInput.sendKeys("chiffon dress");
        WebElement searchBtn = driver.findElement(new By.ByXPath("//*[@id='searchbox']/button"));
        searchBtn.click();
        String url  = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("submit_search="));
    }

    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }

}
