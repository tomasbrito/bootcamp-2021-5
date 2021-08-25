package selenium.iandrada;

import static org.junit.Assert.*; //Se invocan todas las funciones estaticas de la libreria

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc02_BusquedaDirectaProductoExistente {

    WebDriver driver;

    @BeforeClass
    public static void init(){ WebDriverManager.chromedriver().setup();}

    @Before
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test

    public void atc02 () throws InterruptedException { // InterruptedException, esta frase indica que una de las lineas puede generar excepcion, ejemplo "thread.sleep"
        driver.get("http://automationpractice.com/index.php");
        assertEquals( "http://automationpractice.com/index.php", driver.getCurrentUrl());
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("#searchbox > button")).click();
        Thread.sleep(3000);
        assertEquals( "printed chiffon dress", driver.findElement(By.cssSelector("#search_query_top")).getText());
        assertEquals( "Printed Chiffon Dress", driver.findElement(By.cssSelector("a.product-name")).getText());

    }

    @After
    public void close() {

        if (driver != null) {
            //driver.close();
        }
    }
}
