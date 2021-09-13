package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TCP03 {
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
    1. Cargar home
    2. Hacer clic en "Vuelo + 2 Alojamientos"
    3. Esperar que se abra un formulario
    4. Escribir en el campo Origen "Chile"
    5. Esperar a que cargue la lista de resultados
    6.Seleccionar "Santiago de Chile, Santiago, Chile"
    7. Escribir en el campo Destino "Chile"
    8. Esperar a que cargue la lista de resultados
    9. Seleccionar "Santiago de Chile, Santiago, Chile"
    10. Seleccionar el campo "Ida" y esperar que cargue un calendario
    11. Selecionar cualquier fecha disponible
    12. Esperar que cargue el calendario de "Vuelta" y seleccionar cualquier fecha disponible
    13. Seleccionar el campo "Hasta" y esperar que cargue un calendario
    14. Selecionar cualquier fecha disponible
    15. Escribir en el campo Segundo destino "Chile"
    16. Esperar a que cargue la lista de resultados
    17. Seleccionar "Santiago de Chile, Santiago, Chile"
    18. Seleccionar el campo "Desde" y esperar que cargue un calendario
    19. Selecionar cualquierfecha disponible
    20. Seleccionar boton Buscar
     */

    @Test
    public void tcp03(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //1
        driver.get("https://www.viajesfalabella.cl/");
        //2
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"] //input[@value='vhh']")).click();
        //4
        WebElement origen= driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"] //input[@placeholder='Ingresa una ciudad']"));
        origen.click();
        origen.sendKeys("Chile");
        //6
        driver.findElement(By.className("item-text")).click();
        //7
        WebElement destino = driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"] //input[@class=\"input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline\"]"));
        destino.click();
        destino.sendKeys("Chile");
        //9
        driver.findElement(By.className("item-text")).click();
        //10
        driver.findElement(By.xpath("//div[@id='sboxContainer-packages'] //input[@placeholder='Ida']")).click();
        //11
        driver.findElement(By.xpath("//body/div[5]/div[1]/div[2]/div[2]")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div/div[5]/div[3]/div[4]/span[10]")).click();//fecha inicio
        //12-13
        driver.findElement(By.xpath("//body/div[5]/div[1]/div[5]/div[3]/div[4]/span[17]/span[1]")).click();//fecha salida
        //14
        driver.findElement(By.xpath("/html/body/div[7]/div/div[6]/div[2]/button[2]/em")).click();
        //15
        WebElement destino2 = driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[7]/div[2]/div[2]/div[1]/div/div/div/div/input"));
        destino2.click();
        destino2.sendKeys("Chile");
        driver.findElement(By.className("item-text")).click();

        //17
        WebElement destino3 = driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"] //input[@class=\"input-tag sbox-main-focus sbox-hotel-second-destination sbox-primary undefined\"]"));
        destino3.click();
        destino3.sendKeys("Chile");
        driver.findElement(By.className("item-text")).click();

        //18
        driver.findElement(By.xpath("//div[@id='sboxContainer-packages'] //input[@placeholder='Hasta']")).click();
        //19
        driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[4]/span[14]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/div[2]/button[2]/em")).click();

        driver.findElement(By.linkText("Buscar")).click();

        //resultados esperados
        Assert.assertEquals("El destino debe ser diferente del origen.",driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[7]/div[2]/div[1]/div[1]/div/div/div/div/span[3]")).getText());
        Assert.assertEquals("El destino debe ser diferente del origen.",driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[7]/div[2]/div[2]/div[1]/div/div/div/div/span[3]")).getText());
    }
}
