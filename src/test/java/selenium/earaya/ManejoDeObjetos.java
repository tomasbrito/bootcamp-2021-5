package selenium.earaya;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

public class ManejoDeObjetos {

    //atributos
    WebDriver driver;

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
    public void Dropdown(){
        // ir a la web
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //identificar objetos con los que trabajaré
        // tag: select
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        // guradar el elemento en la clase de ayuda Select, para poder interactuar con el dropdown
        Select manjearDropdown = new Select(dropdown);
        //opciones de uso de Select para dropdown estaticos
        manjearDropdown.selectByValue("1");
        manjearDropdown.selectByValue("2");
        manjearDropdown.selectByVisibleText("Option 1");
        manjearDropdown.selectByVisibleText("Option 2");
    }

    @Test
    public void DropDownDinamico(){
        //Jquery Menu
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");

        //WebElement a trabajar
        WebElement enabled = driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]"));
        WebElement download = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]/a"));
        download.click();
        enabled.click();
        System.out.println("click");
    }

    @Test
    public void checkboxes(){ // tag: input
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //WebElement a trabajar
        WebElement check1 = driver.findElement(By.xpath("//body/div[@class='row']/div[@id='content']/div[@class='example']/form[@id='checkboxes']/input[1]"));
        check1.click();
        check1.click();
    }

    @Test
    public void webTables(){ // tag: input
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> webtables = driver.findElements(By.tagName("table"));

        //ejercicio tabla 1: ordenar por deuda y entregar el nombre de la persona que debe mas dinero

        // 1. saber cuantas filas y cuantas columnas tengo

        List<WebElement> elementosColumnasT1 = webtables.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));

        int filas = webtables.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size();
        int columnas = webtables.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th")).size();

        //2. llegar hasta el valor de la Columna DUE y presionar 2 Click para ordenar de mayor a menor Deuba
        for (WebElement webElement : elementosColumnasT1) {
            if (Objects.equals(webElement.getText(), "Due")) {
                webElement.click();
                webElement.click();
                break;
            }
        }

        //3. obtener filas
        List<WebElement> elementosFilasT1 = webtables.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        //4. obtener data de la primera fila
        String Nombre = elementosFilasT1.get(0).findElement(By.xpath("td[2]")).getText();
        String Apellido = elementosFilasT1.get(0).findElement(By.xpath("td[1]")).getText();
        String Deuda = elementosFilasT1.get(0).findElement(By.xpath("td[4]")).getText();

        //5. Imprimir Data Solicitada
        System.out.println("El usuario con mayor deuda es: " + Nombre + " "+ Apellido+ " debe "+Deuda);


        //ejercicio tabla 2: ordenar por Nombre y entregar datos de deuda de todos los usuarios


    }

    @Test
    public void iframes(){ // tag: input
        driver.get("https://the-internet.herokuapp.com/iframe");
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(iframe.get(0));
        String msj = driver.findElement(By.id("tinymce")).getText();
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Enviando informacion por el Iframe");
    }



    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }

}
