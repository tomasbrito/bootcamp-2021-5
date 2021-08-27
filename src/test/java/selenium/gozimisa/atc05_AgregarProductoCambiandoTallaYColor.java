package selenium.gozimisa;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class atc05_AgregarProductoCambiandoTallaYColor {
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
    public void atc05() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        searchInput.sendKeys("blo");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='index']/div[2]/ul/li")).click();
        Select select = new Select(driver.findElement(By.xpath("//*[@id='group_1']")));
        select.selectByValue("3");
        driver.findElement(By.xpath("//*[@id='color_8']")).click();
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
        WebElement succes = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"));
        String text = succes.getAttribute("innerText");
        if (text.contains("Product successfully added to your shopping cart")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }
    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }
}
