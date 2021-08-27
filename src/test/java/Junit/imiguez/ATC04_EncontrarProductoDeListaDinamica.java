
package junit.imiguez;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.*;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.util.concurrent.TimeUnit;

public class ATC04_EncontrarProductoDeListaDinamica {

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
    public void atc04() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        searchInput.sendKeys("blo");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='index']/div[2]/ul/li")).click();

        WebElement padre = driver.findElement(By.xpath("//*[@id='product_reference']"));
        Assert.assertEquals("Model demo_2", padre.getText());
    }

    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }

}