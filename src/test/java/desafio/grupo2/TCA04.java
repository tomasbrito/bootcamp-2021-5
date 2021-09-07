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
    public void tca04() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //1
        driver.get("https://www.viajesfalabella.cl/");

        By ventana = By.className("ac-group-title");

        //2
        driver.findElement(By.className("button-circle-icon")).click();
        //3
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input")).click();
        //4
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input")).sendKeys("San Martin de los Andes");
        //5
        driver.findElement(By.className("item-text")).click();
        //6
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div")).click();
        //7
        driver.findElement(By.className("_dpmg2--controls-next")).click();
        //8
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[4]/span[10]/span[1]")).click();//fecha inicio
        //9
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[3]/div[4]/span[17]")).click();//fecha salida
        //10
        driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]")).click();
        //11
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[3]/div")).click();
        //12
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/a[1]")).click();
        //13
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();

        //14
        WebElement dropdown = driver.findElement(By.className("select-tag"));
        Select manejodropdown = new Select(dropdown);
        //15
        manejodropdown.selectByValue("11");
        //16
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[1]")).click();
        //17
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[4]/div/a/em")).click();
        Thread.sleep(5000);////////
        //18
        driver.navigate().back();


        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div/input")).getText());
        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[2]/div/input")).getText());

        //Assert.assertEquals("2", driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]")).getText());


    }
}
