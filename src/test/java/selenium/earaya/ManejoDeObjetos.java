package selenium.earaya;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

public class ManejoDeObjetos {

    //atributos
    static WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();
    }

   @Test
   public void dropdown(){
       System.out.println("sesion 4");
       driver.get("https://the-internet.herokuapp.com/dropdown");
       //identificar el objeto dropdown - tag HTML : <select> </select>
       WebElement dropdown = driver.findElement(By.id("dropdown"));

       //libreria aux : Select -> dropdown
       Select manejoDropdown = new Select(dropdown);

       manejoDropdown.selectByValue("1"); // Option 1
       manejoDropdown.selectByValue("2"); // Option 2
       manejoDropdown.selectByVisibleText("Option 1");
       manejoDropdown.selectByVisibleText("Option 2");

   }

   @Test
   public void dropDownDinamico(){
        //Jquery
       driver.get("https://the-internet.herokuapp.com/jqueryui/menu");

       //WebElement con los que trabajaremos
       WebElement btnEnabled = driver.findElement(By.id("ui-id-3"));
       WebElement btnDownload = driver.findElement(By.id("ui-id-4"));
       WebElement btnPDF = driver.findElement(By.id("ui-id-5"));

       //navegacion
       btnEnabled.click();
       btnDownload.click();
       Assert.assertEquals("PDF",btnPDF.getText());
   }

   @Test
   public void checkbox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

       //WebElement con los que trabajaremos
       // tag a identificar : input -> <input>
       WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
       WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
       checkbox1.click();
       checkbox2.click();
       checkbox1.isSelected();
       checkbox2.isSelected();
   }

   @Test
   public void iframes(){
        driver.get("https://the-internet.herokuapp.com/iframe");

       //WebElement con los que trabajaremos: iframe
       List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

       // cambiar al iframe : otro documento HTML
       driver.switchTo().frame(iframes.get(0)); // instruccion interna, solo para posicionarnos

       //seleccionar objetos del iframe para comenzar a trabajar
       WebElement escribir = driver.findElement(By.id("tinymce"));
       escribir.clear();
       escribir.sendKeys("Hola saludos desde el Bootcamp Tsoft");
   }

   @Test
   public void webTables(){
       //ejercicio tabla 1: ordenar por deuda de mayor a menor y entregar el nombre de la 1era persona que debe mas dinero
       driver.get("https://the-internet.herokuapp.com/tables");

       //traer la lista de WebTables
       List<WebElement> webtables = driver.findElements(By.tagName("table"));

       // 1. cuantas filas y columnas tiene la tabla 1
       List<WebElement> columnas = webtables.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));
       int sizeColumnas = columnas.size();
       //2. presionar click 2 veces al elemento 3 de la lista columnas para ordenar de mayor a menor
       if(columnas.get(3).getText().contains("Due")) {
           columnas.get(3).click();
           columnas.get(3).click();
       }

       //3. obtener las filas de datos
       List<WebElement> filas = webtables.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

       //4. obtener data de la primera fila
       String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
       String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
       String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();

       //5. imprimir datos en consola
       System.out.println("El usuario con mayor deuda es: "+nombre+ " "+apellido+ " "+deuda);

       //ejercicio tabla 2: ordenar por Nombre y entregar datos de deuda de todos los usuarios


   }



    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }

}
