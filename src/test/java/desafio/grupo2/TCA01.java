package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TCA01 {
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
    public void tca01(){
        driver.get("https://www.viajesfalabella.cl/");
        By ventana = By.className("ac-group-title");

        driver.findElement(By.className("button-circle-icon")).click();
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input")).sendKeys("la");

        WebElement verificacion = driver.findElement(ventana);
        WebDriverWait exwait= new WebDriverWait(driver, 1);
        exwait.until(ExpectedConditions.elementToBeClickable(ventana));

        System.out.println(verificacion.getText());

        Assert.assertEquals("Ingresa al menos 3 letras, y aguarda los resultados", verificacion.getText());
    }
}
