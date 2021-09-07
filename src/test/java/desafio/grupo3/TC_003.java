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
        System.out.println("Error por falta de edad");
        driver.get("https://www.viajesfalabella.cl/hoteles/");
        /*//Seleccionar una fecha
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/span[7]"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/span[30]/span[1]"));
        driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[2]/button[2]/em"));
        */
        //Seleccionar el destino
        /*
        WebElement destino = driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div"));
        destino.click();
        Thread.sleep(3000);
        destino.sendKeys("Buenos");//El destino será en Buenos Aires
        Thread.sleep(3000);
        destino.sendKeys(Keys.ENTER);
         */
        //
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
