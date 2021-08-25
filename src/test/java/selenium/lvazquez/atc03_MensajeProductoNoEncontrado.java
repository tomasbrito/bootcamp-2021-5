package selenium.lvazquez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc03_MensajeProductoNoEncontrado {
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
    public void atc03() {
        driver.get("http://automationpractice.com/");

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\'search_query_top\']"));

        searchBox.sendKeys("liquido matapulgas");
        searchBox.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Assert.assertTrue(false);
        }

        String message = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();

        System.out.println(message);
        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", message);

    }

    @After
    public void close() {
        System.out.println("after");
        if (driver != null) driver.close();
    }
}
