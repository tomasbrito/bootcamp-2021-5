package selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc01_busquedaProductoExistente {

    WebDriver driver;
    //By barraBusqueda = By.xpath(" ");

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
     public void setUp(){
        driver =new ChromeDriver();
        driver.manage().deleteAllCookies();//borrar cookies
        driver.manage().window().maximize();
    }

    @After
    public void close(){
        System.out.println("After");
        if (driver!=null){
            driver.close();
            System.out.println("flag driver igual a null");
        }
    }

    @Test
    public void atc01(){
        driver.get("http://automationpractice.com/index.php");
        System.out.println("se abre url");
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("chiffon dress");//
        System.out.println("se tipea en el objeto");
        driver.findElement(By.cssSelector("#searchbox > button")).click();//
        System.out.println("se presiona el boton buscar");
        //validar - assert
        String urlActual = driver.getCurrentUrl();
        if (urlActual.contains("submit_search=")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
        System.out.println(urlActual);
    }

}
