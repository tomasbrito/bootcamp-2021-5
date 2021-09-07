package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TCP02 {
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
    public void tcp02(){
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[1]/div[2]/div/div/span[3]/input")).click();
        WebElement origen= driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div/input"));
        origen.click();
        origen.sendKeys("cordoba");

        driver.findElement(By.xpath("//body/div[11]/div[1]/div[1]/ul[1]/li[1]")).click();

        WebElement destino = driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div/input"));
        destino.click();
        destino.sendKeys("rosario");

        driver.findElement(By.xpath("//body/div[11]/div[1]/div[1]/ul[1]/li[1]")).click();

        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        Assert.assertEquals("Ingresa una fecha de partida.", driver.findElement(By.xpath("//span[contains(text(),'Ingresa una fecha de partida.')]")).getText());
        Assert.assertEquals("Ingresa una fecha de regreso.", driver.findElement(By.xpath("//span[contains(text(),'Ingresa una fecha de regreso.')]")).getText());

    }
}
