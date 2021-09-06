package selenium.ibanez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.ws.WebEndpoint;
import java.util.List;

public class ManejoDeObjetos {
    static WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.edgedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();

    }

    @Test
    public void dropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //Identificar el objeto dropdown - tag : select
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        //libreria oux : Select --> dropdown
        Select manejoDropdown = new Select(dropdown);
        manejoDropdown.selectByValue("1"); // Option 1
        manejoDropdown.selectByValue(("2")); // Option 2
        manejoDropdown.selectByVisibleText("");


    }

    @Test
    public void dropDownDinamico(){
            //Jquery
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");

        //WebElement con los que trabajaremos.
        WebElement btnEnable = driver.findElement(By.id("ui-id-3"));
        WebElement btnDownload = driver.findElement((By.id("ui-id-4")));
        WebElement btnPDF = driver.findElement((By.id("ui-id-5")));


        //navegacion
        btnEnable.click();
        btnDownload.click();
        Assert.assertEquals("PDF",btnPDF.getText());

    }
    @Test
    public void chekBoxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //WebElement con los que trabajermos
        // tag a identificar : input --> <input>
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        checkbox1.click();
        checkbox2.click();
        checkbox1.isSelected();
        checkbox2.isSelected();
    }

    @Test
    public void iFrames(){
        driver.get("https://the-internet.herokuapp.com/iframe");


        //WebElement con los que trabajermos : iframes
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));


        // cambiar al iframe : otra documento HTML
        driver.switchTo().frame(iframes.get(0)); // instruccion interna, solo para posicionarnos.

        //seleccionar objetos del iframe para comenzar a trabajar
        WebElement escribir = driver.findElement(By.id("tinymce"));
        escribir.clear();
        escribir.sendKeys("Hola po wn, murio el tomi11, no me la container");
    }

    @Test
    public  void webTables(){
        //ejercicio tabla 1: ordenar por deuda de mahyor a menor y entregar el nombre de la 1era persona que debe mas dinero
        driver.get("https://the-internet.herokuapp.com/tables");

        //traer la lista de WebTables
        List<WebElement> webtables = driver.findElements(By.tagName("table"));

        //1. cuantas filas y columnas tiene la tabla
        List<WebElement> columnas = webtables.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));
        int sizeColumnas = columnas.size();
        //2. presionar click 2 veces al elemento 3 de la lista.
        if (columnas.get(3).getText() == "Due") {
            columnas.get(3).click();
            columnas.get(3).click();
            int size;
            columnas: size = 6;
        }


    }


    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            //driver.close();
        }
    }
}