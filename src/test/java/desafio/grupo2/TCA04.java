package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class TCA04 {
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
    public void tca04() throws InterruptedException {
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By ventana = By.className("ac-group-title");

        driver.findElement(By.className("button-circle-icon")).click();
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input")).sendKeys("San Martin de los Andes");

        driver.findElement(By.className("item-text")).click();

        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div")).click();
        driver.findElement(By.className("_dpmg2--controls-next")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[4]/span[10]/span[1]")).click();//fecha inicio
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[4]/span[17]")).click();//fecha salida

        driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]")).click();

        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[3]/div")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/a[1]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();

        WebElement dropdown = driver.findElement(By.className("select-tag"));
        Select manejodropdown = new Select(dropdown);
        manejodropdown.selectByValue("11");

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[4]/div/a/em")).click();
        Thread.sleep(5000);////////
        driver.navigate().back();


        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div/input")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[2]/div/input")).getText());

        //Assert.assertEquals("2", driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]")).getText());


    }
}
