package selenium.gozimisa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class atc06 {

    WebDriver driver;
    By barraBusqueda = By.xpath("//*[@id='search_query_top']"); //en el navegador inspeccionar elemento y copiar XPath o select para css

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

    @Test
    public void dropdown(){
        //tag html <select>
        driver.get("https://the-internet.herokuapp.com/dropdown");
        System.out.println("se abre url");
        WebElement dropdown=driver.findElement(By.id("dropdown"));

        Select manejoDropDown = new Select(dropdown);
        manejoDropDown.selectByValue("1");
        manejoDropDown.selectByValue("2");

        manejoDropDown.selectByVisibleText("Option 1");
        manejoDropDown.selectByVisibleText("Option 2");
    }

    @Test
    public void dropdownDinamico(){
        //Jquery
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");

        WebElement btnEnabled = driver.findElement(By.id("ui-id-3"));
        WebElement btnDowndoad = driver.findElement(By.id("ui-id-4"));
        WebElement btnPDF = driver.findElement(By.id("ui-id-5"));

        btnEnabled.click();
        btnDowndoad.click();
        Assert.assertEquals("PDF", btnPDF.getText());
    }

    @Test
    public void checkbox(){

        driver.get("https://the-internet.herokuapp.com/checkboxes");

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

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

        //esto es para cambiar al primer iframe
        driver.switchTo().frame(iframes.get(0));

        WebElement text =driver.findElement(By.id("tinymce"));
        text.clear();
        text.sendKeys("Estoy escribiendo de intellij");
    }

    @Test
    public void webtables(){
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> tablas = driver.findElements(By.tagName("table"));

        //ordenar
        List<WebElement> columna= tablas.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));
        int sizeColum = columna.size();

        if(columna.get(3).getText().equals("Due")){
        columna.get(3).click();
        columna.get(3).click();
        }

        //buscar
        List<WebElement> filas = tablas.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        int sizeFila = filas.size();

        String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
        String apellido= filas.get(0).findElement(By.xpath("td[1]")).getText();
        String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();
    }


    //ejercicio tabla 2: ordenar por Nombre y entregar datos de deuda de todos los usuarios
    @Test
    public void webtables2(){
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> tablas = driver.findElements(By.tagName("table"));

        //ordenar
        List<WebElement> thead= tablas.get(1).findElement(By.tagName("thead")).findElements(By.tagName("th"));
        if(thead.get(1).getText().equals("First Name")){
            thead.get(1).click();
        }

        List<WebElement> tbody = tablas.get(1).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        int sizeFila = tbody.size();

        for (WebElement webElement : tbody) {
            String nombre = webElement.findElement(By.className("first-name")).getText();
            String apellido = webElement.findElement(By.className("last-name")).getText();
            String deuda = webElement.findElement(By.className("dues")).getText();
            System.out.println("la persona "+nombre+" "+apellido+" debe: "+deuda);
        }
    }
}
