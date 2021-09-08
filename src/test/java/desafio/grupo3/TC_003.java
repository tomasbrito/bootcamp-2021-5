package desafio.grupo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TC_003 {
    WebDriver driver; // es la instancia a crear del navegador - firefox, chrome, safari

    @BeforeClass
    public static void SetUp(){
        System.out.println("Setup");
        WebDriverManager.chromedriver().setup();; //vamos a crear una instancia de Google Chrome
    }

    @Before
    public void init(){
        System.out.println("init");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();
    }



    @Test
    public void TC_003() throws InterruptedException {
        System.out.println("---Error por falta de edad---");
        driver.get("https://www.viajesfalabella.cl/hoteles/");
        //Seleccionar habitaciones
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[1]")).click();

        //evaluamos:
        String esperado = "Ingresa la edad del menor";
        assertEquals(esperado, driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[3]/div/div[2]/p")).getText());

    }

    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }
}
