package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TCT01 {
    WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();//borrar cookies
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
    public void tct01(){
        driver.get("https://www.viajesfalabella.cl/");
        driver.findElement(By.xpath("//body/nav[1]/div[2]/div[1]/div[3]/ul[1]/li[6]/a[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[4]/div/div/div[2]/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[5]/div/a/em")).click();

        WebElement verificacion= driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[4]/div/div/div[2]/div/div/div/span[2]"));

        Assert.assertEquals("Ingresa la edad.", verificacion.getText());
    }
}
