package selenium.iandrada;

import static org.junit.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc03_MensajeDeProductoNoEncontrado {

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
    public void atc03() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("liquido matapulgas");
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(Keys.ENTER); //Se envia el enter a la barra "Busqueda".
        Thread.sleep(3000);
        String resultado = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();
        assertEquals("No results were found for your search \"liquido matapulgas\"", resultado ); // Para buscar un caracter especial dentro de un string, se usa \ y tome las comillas dobles
    }

    @After
    public void close() {

        if (driver != null) {
            //driver.close();
        }
    }





}
