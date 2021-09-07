package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TCT01 {
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
    2. Hacer click en "Traslados"
    3. Hacer click sobre la solapa "Pasajeros"
    4. En "Menores", agregar 1 haciendo click en +
    5. Hacer click sobre el boton "Buscar"
    6. Click sobre la solapa "Pasajeros"
     */
    @Test
    public void tct01(){
        //1
        driver.get("https://www.viajesfalabella.cl/");
        //2
        driver.findElement(By.xpath("//body/nav[1]/div[2]/div[1]/div[3]/ul[1]/li[6]/a[1]")).click();
        //3
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[4]/div/div/div[2]/div/div")).click();
        //4
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div/a[2]")).click();
        //5
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[5]/div/a/em")).click();
        //6
        WebElement verificacion= driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[4]/div/div/div[2]/div/div/div/span[2]"));
        //resultados esperados
        Assert.assertEquals("Ingresa la edad.", verificacion.getText());
    }
}
