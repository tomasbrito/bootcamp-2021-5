package selenium.lkelly;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ManejoDeObjetos {

    WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }

    @Test
    public void dropdown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select manejoDropdown = new Select(dropdown);
        manejoDropdown.selectByValue("1"); //Option 1
        manejoDropdown.selectByValue("2"); //Option 2
        manejoDropdown.selectByVisibleText("Option 1");
        manejoDropdown.selectByVisibleText("Option 2");
    }
    @Test
    public void dropdownDinamico() throws InterruptedException {
        //JQuery
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
       WebElement btnEnabled = driver.findElement(By.id("ui-id-3"));
       WebElement btnDownload = driver.findElement(By.id("ui-id-4"));
       WebElement btnPDF = driver.findElement(By.id("ui-id-5"));
       btnEnabled.click();
       btnDownload.click();
       Assert.assertEquals("PDF",btnPDF.getText());
    }

    @Test
    public void checkbox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        checkbox1.click();
        checkbox2.click();
        checkbox1.isSelected();
        checkbox2.isSelected();
    }

    @Test
    public void iframe() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        // cambiar al iframe (otro documento HTML)
        driver.switchTo().frame(iframes.get(0));
        //seleccionar objetos del iframe
        WebElement escribir = driver.findElement(By.id("tinymce"));
        escribir.clear();
        escribir.sendKeys("Hola!");
    }

    @Test
    public void webTables() {
        driver.get("https://the-internet.herokuapp.com/tables");
        //ejercicio tabla 1 : ordenar deuda y devolver el nombre de quien tenga mas deuda
        //traer lista de webTables
        List<WebElement> webTables = driver.findElements(By.tagName("table"));

        // 1. cuantas filas y columnas tiene la tabla 1?
        List<WebElement> columnas = webTables.get(0).findElement(By.tagName("thead")).findElements(By.tagName("tr"));
        int sizeColumnas = columnas.size();
        //2. Presionar dos veces al elemento 3 de la lista
        if(columnas.get(3).getText().contains("Due")){
            columnas.get(3).click();
            columnas.get(3).click();
        }
        //3. obtener las filas de datos
        List<WebElement> filas = webTables.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
       String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
       String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
       String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();
        System.out.println("El usuario con mayor deuda es "+ nombre + apellido +deuda);
    }

    //ejercicio tabla 2: ordenar por Nombre y entregar datos de deuda de todos los usuarios
    @Test
    public void webTables2() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> webTables = driver.findElements(By.tagName("table"));
        List<WebElement> columnas = webTables.get(1).findElement(By.tagName("thead")).findElements(By.tagName("tr"));
        if(columnas.get(0).getText().contains("First Name")){
            columnas.get(0).click();
        }
        List<WebElement> filas = webTables.get(1).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        for (int i=0; i< filas.size();i++){
            String nombre = filas.get(i).findElement(By.className("first-name")).getText();
            String apellido = filas.get(i).findElement(By.className("last-name")).getText();
            String deuda = filas.get(i).findElement(By.className("dues")).getText();
            System.out.println("El usuario "+ nombre +" "+ apellido+ " tiene una deuda de "+deuda);
        }
    }

}
