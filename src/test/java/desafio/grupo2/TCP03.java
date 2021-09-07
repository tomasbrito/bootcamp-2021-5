package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TCP03 {
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
    public void tcp03(){
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[1]/div[2]/div/div/span[2]/input")).click();
        WebElement origen= driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div/input"));
        origen.click();
        origen.sendKeys("Chile");

        driver.findElement(By.xpath("//body/div[11]/div[1]/div[1]/ul[1]/li[1]")).click();

        WebElement destino = driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div/input"));
        destino.click();
        destino.sendKeys("Chile");

        driver.findElement(By.xpath("//body/div[11]/div[1]/div[1]/ul[1]/li[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[3]/div/div[1]/div")).click();
        driver.findElement(By.xpath("//body/div[5]/div[1]/div[2]/div[2]")).click();

        driver.findElement(By.xpath("/html/body/div[5]/div/div[5]/div[3]/div[4]/span[10]")).click();//fecha inicio
        driver.findElement(By.xpath("//body/div[5]/div[1]/div[5]/div[3]/div[4]/span[17]/span[1]")).click();//fecha salida

        driver.findElement(By.xpath("//body/div[7]/div[1]/div[6]/div[2]/button[2]/em[1]")).click();

        WebElement destino2 = driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[7]/div[2]/div[2]/div[1]/div/div/div/div/input"));
        destino2.click();
        destino2.sendKeys("Chile");

        driver.findElement(By.xpath("//body/div[11]/div[1]/div[1]/ul[1]/li[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[7]/div[2]/div[2]/div[2]/div/div[1]/div/input")).click();
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[5]/div[3]/div[4]/span[14]")).click();
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[6]/div[2]/button[2]/em[1]")).click();

        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        Assert.assertEquals("El destino debe ser diferente del origen.",driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[7]/div[2]/div[1]/div[1]/div/div/div/div/span[3]")).getText());
        Assert.assertEquals("El destino debe ser diferente del origen.",driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[7]/div[2]/div[2]/div[1]/div/div/div/div/span[3]")).getText());
    }
}
