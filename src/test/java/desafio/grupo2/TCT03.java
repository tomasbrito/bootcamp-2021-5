package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TCT03 {
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
    1.Carga home
    2. Hacer clic en "Traslados"
    3. Hacer clic en el campo Desde
    4- Escribir en el campo Desde "Santiago"
    5- Esperar que cargue la lista de resultados
    6- Seleccionar "Aeropuerto Arturo Merino Benitez, Santiago de Chile, Chile"
    7. Hacer clic en el campo Hasta
    8- Escribir en el campo Hasta "Sheraton"
    9- Esperar que cargue la lista de resultados
    10- Seleccionar "Sheraton Miramar - Avenida Marina, Viña del Mar, Chile"
    11- Marcar la opción "Quiero agregar el regreso"
    12-Seleccionar el campo "Arribo" y esperar que cargue un calendario
    13. Selecionar cualquier fecha disponible
    14. Hacer clic al campo Hora
    15. Elergir la opcion "03:00"
    16. Seleccionar el boton "Buscar"
    17. Esperar que cargue la pagina
     */

    @Test
    public void tct03() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //1
        driver.get("https://www.viajesfalabella.cl/");
        //2
        driver.findElement(By.linkText("Traslados")).click();
        //3
        WebElement origen= driver.findElement(By.xpath("//div[@id='sboxContainer-transferspoi'] //input[@placeholder='Ingresa un aeropuerto']"));
        origen.click();
        //4
        origen.sendKeys("Santiago");
        //6
        driver.findElement(By.className("item-text")).click();
        //7
        WebElement destino= driver.findElement(By.xpath("//div[@id='sboxContainer-transferspoi'] //input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']"));
        destino.click();
        //8
        destino.sendKeys("Sheraton");
        //10
        driver.findElement(By.xpath("//span[contains(text(),'Sheraton Miramar - Avenida Marina, Viña del Mar, C')]")).click();
        //11
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"] //label[@class=\"checkbox-label\"]")).click();
        //12
        driver.findElement(By.className("sbox-moment-input")).click();
        //13
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/i")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[3]/div[4]/span[10]/span[1]")).click();//fecha inicio
        driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[3]/div[4]/span[17]/span[1]")).click();//fecha salida
        driver.findElement(By.xpath("//body/div[3]/div[1]/div[6]/div[2]/button[2]/em[1]")).click();
        //14
        Thread.sleep(500);

        WebElement drop1= driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"] //select[@class=\"select-tag sbox-time-arrival\"]"));
        drop1.click();
        Select dropdownIda= new Select(drop1);
        //15
        dropdownIda.selectByValue("180");
        //14
        WebElement drop2= driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"] //select[@class=\"select-tag sbox-time-departure\"]"));
        drop2.click();
        Select dropdownVuelta= new Select(drop2);
        //15
        dropdownVuelta.selectByValue("180");
        //16
        driver.findElement(By.linkText("Buscar")).click();
        //17
        Thread.sleep(1000);

        //resultados esperados
        driver.findElement(By.linkText("Modificar")).click();
        WebElement ida= driver.findElement(By.xpath("//*[@id=\"bodyID\"] //*[@placeholder='Ingresa un aeropuerto']"));
        WebElement vuelta= driver.findElement(By.xpath("//*[@id=\"bodyID\"] //*[@placeholder='Ingresa un hotel o dirección adónde quieras ir']"));
        WebElement fechaIda = driver.findElement(By.xpath("//*[@id=\"bodyID\"] //*[@placeholder='Arribo']"));
        WebElement fechaVuelta =driver.findElement(By.xpath("//*[@id=\"bodyID\"] //*[@placeholder='Partida']"));
        WebElement horaIda = driver.findElement(By.xpath("//*[@id=\"bodyID\"] //*[@class=\"select-tag sbox-time-arrival\"]"));
        WebElement horaVuelta= driver.findElement(By.xpath("//*[@id=\"bodyID\"] //*[@class=\"select-tag sbox-time-departure\"]"));

        Assert.assertEquals("input", ida.getTagName());
        Assert.assertEquals("input", vuelta.getTagName());
        Assert.assertEquals("input", fechaIda.getTagName());
        Assert.assertEquals("input", fechaVuelta.getTagName());
        Assert.assertEquals("select", horaIda.getTagName());
        Assert.assertEquals("select", horaVuelta.getTagName());
    }


}
