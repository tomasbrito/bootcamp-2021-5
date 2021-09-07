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
        driver.findElement(By.xpath("//body/nav[1]/div[2]/div[1]/div[3]/ul[1]/li[6]/a[1]")).click();
        //3
        WebElement origen= driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/div/div/input"));
        origen.click();
        //4
        origen.sendKeys("Santiago");
        //6
        driver.findElement(By.xpath("/html/body/div[15]/div/div/ul/li[1]")).click();
        //7
        WebElement destino = driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div/input"));
        destino.click();
        //8
        destino.sendKeys("Sheraton");
        //10
        driver.findElement(By.xpath("//span[contains(text(),'Sheraton Miramar - Avenida Marina, Viña del Mar, C')]")).click();
        //11
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[3]/span/label/i")).click();
        //12
        driver.findElement(By.className("sbox-moment-input")).click();
        //13
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/i")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[3]/div[4]/span[10]/span[1]")).click();//fecha inicio
        driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[3]/div[4]/span[17]/span[1]")).click();//fecha salida
        driver.findElement(By.xpath("//body/div[3]/div[1]/div[6]/div[2]/button[2]/em[1]")).click();
        //14
        WebElement drop1= driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[3]/div/div[1]/div/div/div[2]/div/div/select"));
        drop1.click();
        Select dropdownIda= new Select(drop1);
        //15
        dropdownIda.selectByValue("180");
        //14
        WebElement drop2= driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div/select"));
        drop2.click();
        Select dropdownVuelta= new Select(drop2);
        //15
        dropdownVuelta.selectByValue("180");
        //16
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[5]/div/a/i")).click();
        //17
        Thread.sleep(5000);

        //resultados esperados
        driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/ul/li[4]/a[1]")).click();
        WebElement ida= driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[2]/div/div[1]/div/div/div/input"));
        WebElement vuelta= driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div/input"));
        WebElement fechaIda = driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[3]/div/div[1]/div/div/div[1]/div/div/input"));
        WebElement fechaVuelta =driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div/input"));
        WebElement horaIda = driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[3]/div/div[1]/div/div/div[2]/div/div/select"));
        WebElement horaVuelta= driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div/select"));

        Assert.assertEquals("input", ida.getTagName());
        Assert.assertEquals("input", vuelta.getTagName());
        Assert.assertEquals("input", fechaIda.getTagName());
        Assert.assertEquals("input", fechaVuelta.getTagName());
        Assert.assertEquals("select", horaIda.getTagName());
        Assert.assertEquals("select", horaVuelta.getTagName());
    }


}
