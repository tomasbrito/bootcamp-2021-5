package selenium.gastonb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class pactica {
    WebDriver driver;
    //By barraBusqueda = By.xpath(" ");

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        driver =new ChromeDriver();
        driver.manage().deleteAllCookies();//borrar cookies
        driver.manage().window().maximize();
        System.out.println("before");
    }

    @After
    public void close(){
        System.out.println("After");
        if (driver!=null){
            driver.close();
            System.out.println("flag driver igual a null");
        }
    }

    @Test
    public void atc00() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#content > div > button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"elements\"]/button")).click();//////*[@id="elements"]/button[1]
    }
}
