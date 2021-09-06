package selenium.lvazquez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class atc_AgregarProductoCambiandoTallaYColor {
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
    public void atc5() throws InterruptedException {
        driver.get("http://automationpractice.com/");

        driver.findElement(By.xpath("//*[@id=\'search_query_top\']"))
                .sendKeys("blo");

        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li")).click();

        String reference = driver.findElement(By.id("product_reference")).getText();

        Assert.assertEquals("Model demo_2", reference);

        WebElement select = driver.findElement(By.id("group_1"));
        Select size = new Select(select);
        size.selectByVisibleText("L");

        driver.findElement(By.id("color_8")).click();

        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();

        Thread.sleep(4000);

        String message = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).getText();
        String model = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_title\"]")).getText();
        String colorSize = driver.findElement(By.xpath("//*[@id=\"layer_cart_product_attributes\"]")).getText();

        Assert.assertEquals("Product successfully added to your shopping cart", message);
        Assert.assertEquals("Blouse", model);
        Assert.assertEquals("White, L", colorSize);
    }
}
