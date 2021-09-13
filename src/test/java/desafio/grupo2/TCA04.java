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
    /*
    1.Cargar home
    2.Click en Alojamientos
    3.Click en Destino
    4.Ingresar San Martin de los Andes
    5.Seleccionar primera opcion
    6.Seleccionar Fechas
    7.Desplazarse hasta noviembre (2 clicks)
    8.Ingresar entrada 10 de noviembre
    9.Ingresar salida 17 de Noviembre
    10. Click Aplicar
    11. Seleccionar Habitaciones
    12.Click en signo - en Adultos
    13.Click en + agregar Menores
    14.Click en Elegir la edad del menor
    15.seleccionar 11 años
    16.Aplicar
    17.Click Buscar
    18.Click en volver atras navegador
    */

    @Test
    public void tca04() throws InterruptedException { //poner nombre
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //1
        driver.get("https://www.viajesfalabella.cl/");

        //2
        driver.findElement(By.linkText("Alojamientos")).click();
        //3
        WebElement origen= driver.findElement(By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Ingresa una ciudad, alojamiento o atracción']"));
        origen.click();
        //4
        origen.sendKeys("San Martin de los Andes");
        //5
        driver.findElement(By.className("item-text")).click();
        //6
        driver.findElement(By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Entrada']")).click();
        //7
        //driver.findElement(By.className("_dpmg2--controls-next")).click();
        //8
        driver.findElements(By.className("_dpmg2--date-number")).get(9).click();//fecha inicio
        //9
        driver.findElements(By.className("_dpmg2--date-number")).get(16).click();;//fecha salida
        //10
        driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]")).click();
        //11
        driver.findElement(By.xpath("//label[contains(text(),'Habitaciones')]")).click();
        //12
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock'] //a[@class=\"steppers-icon-left sbox-3-icon-minus\"]")).click();
        //13
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock'] //div[@class=\"_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg\"] //a[@class=\"steppers-icon-right sbox-3-icon-plus\"]")).click();

        //14
        WebElement dropdown = driver.findElement(By.className("select-tag"));
        Select manejodropdown = new Select(dropdown);
        //15
        manejodropdown.selectByValue("11");
        //16
        driver.findElement(By.linkText("Aplicar")).click();
        //17
        driver.findElement(By.linkText("Buscar")).click();
        Thread.sleep(5000);
        //18
        driver.navigate().back();


        Assert.assertEquals("", driver.findElement(By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Ingresa una ciudad, alojamiento o atracción']")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Entrada']")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Salida']")).getText());

        //Assert.assertEquals("1",driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"] //input[class=\"sbox-distri-tag sbox-rooms\"]")).getSize().toString());
        //Assert.assertEquals("1",driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"] //input[class=\"sbox-distri-tag sbox-rooms\"]")).getSize().toString());



    }
}
