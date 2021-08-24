package selenium.lkelly;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc01_busquedaProductoExistente_chrome {
    WebDriver driver;
    By barraBusqueda = By.xpath("//*[@id='search_query_top']");
    By botonBusqueda = By.cssSelector("#searchbox > button");

    @BeforeClass
    public static void setUp(){
        System.out.println("Setup");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        System.out.println("init");
        driver = new ChromeDriver();
    }

    @After
    public void close(){
        System.out.println("Finaliza");
        if(driver != null){
            driver.close();
        }
    }

    @Test
    public void atc01() {
        // Se abre URL
        driver.get("http://automationpractice.com/");
        System.out.println("Se abre URL");
        //Tipeamos chiffon dress en la barra de busqueda
        driver.findElement(barraBusqueda).sendKeys("chiffon dress");
        System.out.println("se tipea objeto 'chiffon dress'");
        //Click al botón de búsqueda
        driver.findElement(botonBusqueda).click();
        System.out.println("click en boton busqueda");
        //Validar reusltado de busqueda
        String urlActual = driver.getCurrentUrl();
        System.out.println("URL Actual: " + urlActual);
        if(urlActual.contains("submit_search=")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }

    }

}
