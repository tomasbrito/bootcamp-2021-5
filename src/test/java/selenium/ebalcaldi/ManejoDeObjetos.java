/*
package selenium.ebalcaldi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ManejoDeObjetos {

    WebDriver driver;
    @BeforeClass
    public static void init(){
        WebDriverManager.edgedriver().setup();

    }

    @Before
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }
    @After
    public void close(){
        System.out.println("After");
        if(driver !=null){
            driver.close();
        }
    }

    @Test
    public void dropdown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select s = new Select(dropdown);
        s.selectByValue("1");
        s.selectByValue("2");
        s.selectByVisibleText("Option 1");
        s.selectByVisibleText("Option 2");
    }
    @Test
    public void dropdownDinamico(){
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
        WebElement btnEnabled = driver.findElement(By.id("ui-id-3"));
        WebElement btnDownload = driver.findElement((By.id("ui-id-4")));
        WebElement btnPdf = driver.findElement(By.id("ui-id-5"));
        btnEnabled.click();
        btnDownload.click();
        btnPdf.click();
        Assert.assertEquals("PDF", btnPdf.getText());



    }
    @Test
    public void checkboxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        checkbox.click();
        checkbox1.click();
        checkbox1.isSelected();




    }
    @Test
    public void iframe(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(iframes.get(0));
        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("hola");


    }
    @Test
    public void webTables() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> tablas = driver.findElements(By.tagName("table"));
        List<WebElement> columnas = tablas.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));
        int cantidadColumnas = columnas.size();
        System.out.println(cantidadColumnas);
        if(columnas.get(3).getText().equals("Due")){
            columnas.get(3).click();
            columnas.get(3).click();
        }

        List<WebElement> filas = tablas.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
        String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
        String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();

        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(deuda);

        //ejercicio 2 ordenar por nombre y entregar datos de deuda de todos los usuarios, sin usar xpath.
        // usando la tabla 2, usando los atributos (class = last-name, class = first-name by classname)


    }
    @Test
    public void webTablesClasses() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> tablas = driver.findElements(By.tagName("table"));
        List<WebElement> columnas = tablas.get(1).findElement(By.tagName("thead")).findElements(By.className("th"));
        int cantidadColumnas = columnas.size();
        System.out.println(cantidadColumnas);

        for(WebElement w: columnas){
           // if(columnas.get(w).getText().equals("Name")){

            }
        }
 //       if(columnas.get(3).getText().equals("Due")){
   //         columnas.get(3).click();
     //       columnas.get(3).click();
       // }

      //  List<WebElement> filas = tablas.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        //String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
        //String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
        //String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();


        //ejercicio 2 ordenar por nombre y entregar datos de deuda de todos los usuarios, sin usar xpath.
        // usando la tabla 2, usando los atributos (class = last-name, class = first-name by classname)


    }
}
*/
