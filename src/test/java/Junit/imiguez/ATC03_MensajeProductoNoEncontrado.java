package junit.imiguez;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.*;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

public class ATC03_MensajeProductoNoEncontrado {

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
    public void atc03() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        searchInput.sendKeys("liquido matapulgas");
        searchInput.sendKeys(Keys.ENTER);
        String url  = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("submit_search="));
        Thread.sleep(3000);
        String resultado = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();
        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", resultado);
    }

    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }

}
