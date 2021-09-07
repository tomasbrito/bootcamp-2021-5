package desafio.grupo4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class Paquete {
    static final String url = "https://www.viajesfalabella.cl/";
    WebDriver driver;
    @BeforeClass
    public static void init(){
        WebDriverManager.edgedriver().setup();

    }

    @Before
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @After
    public void close(){
        System.out.println("After");
        if(driver !=null){
            //  driver.close();
        }
    }

    @Test
    public void prohibirBusqueda() throws InterruptedException {


        //atributos
        WebDriverWait exwait = new WebDriverWait(driver, 10);

        //atributos Localizadores
        By inputOrigen = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
        By inputDestino = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
        By locbtnPaquete = By.xpath("//a[contains(@class,'shifu-3-button-circle PACKAGES paint-circle')]");
        By textoErrorOrigen = By.xpath("//span[contains(text(),'Ingresa una fecha de partida.')]");
        By textoErrorRegreso = By.xpath("//span[contains(text(),'Ingresa una fecha de regreso.')]");
        By btnSearch = By.xpath("//*[contains(@class, 'sbox-search')]");
        //1. ir a url
        driver.get(url); //cargo la url

        //2. boton pestana principal paquete
        WebElement WeBtnPaquete = driver.findElement(locbtnPaquete);
        WeBtnPaquete.click();

        //Valido que esté en la URL correcta
        exwait.until(ExpectedConditions.urlContains("/paquetes"));
        Assert.assertEquals("https://www.viajesfalabella.cl/paquetes/", driver.getCurrentUrl());


        //acceder elemento y enviamos palabra
        WebElement weInputorigen = driver.findElement(inputOrigen);
        WebElement weInputDestino = driver.findElement(inputDestino);

        weInputorigen.sendKeys("Santiago");
        Thread.sleep(1000);
        //exwait.until(ExpectedConditions.elementToBeClickable(inputOrigen));
        weInputorigen.sendKeys(Keys.ENTER);

        weInputDestino.sendKeys("Puerto Montt");
        //exwait.until(ExpectedConditions.elementToBeClickable(inputDestino));
        Thread.sleep(1000);
        weInputDestino.sendKeys(Keys.ENTER);

        //clickeo el botón search
        driver.findElement(btnSearch).click();

        //validaciones
        Assert.assertEquals("Ingresa una fecha de partida.", driver.findElement(textoErrorOrigen).getText());
        Assert.assertEquals("Ingresa una fecha de regreso.", driver.findElement(textoErrorRegreso).getText());



    }
}