package selenium.lvazquez;

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
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select manejoDropdown = new Select(dropdown);
        manejoDropdown.selectByValue("1");
        manejoDropdown.selectByValue("2");
        manejoDropdown.selectByVisibleText("Option 1");
        manejoDropdown.selectByVisibleText("Option 2");
    }

    @Test
    public void dropdownDinamico() {
        //se hace con jQuery
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");

        // agarrar los botones
        WebElement btnEnabled = driver.findElement(By.id("ui-id-3"));
        WebElement btnDownload = driver.findElement(By.id("ui-id-4"));
        WebElement btnPDF = driver.findElement(By.id("ui-id-5"));

        // navegar
        btnEnabled.click();
        btnDownload.click();
        Assert.assertEquals("PDF", btnPDF.getText());
    }

    @Test
    public void checkbox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        checkbox1.click();
        checkbox2.click();
        checkbox1.isSelected();
        checkbox2.isSelected();
    }

    @Test
    public void iframes() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(iframes.get(0));
        WebElement escribir = driver.findElement(By.id("tinymce"));
        escribir.clear();
        escribir.sendKeys("Pruebarda");
    }

    @Test
    public void webTables() {
        //ordenar quien debe mas $
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> webtables = driver.findElements(By.tagName("table"));

        // identificar filas y columnas de la tabla
        List<WebElement> columnas = webtables.get(0)
                .findElement(By.tagName("thead"))
                .findElements(By.tagName("th"));

        int columnasSize = columnas.size();

        WebElement dueColumn = columnas.get(3);
        if (dueColumn.getText() == "Due"){
            dueColumn.click();
            dueColumn.click();
        }

        List<WebElement> filas =  webtables.get(0)
                .findElement(By.tagName("tbody"))
                .findElements(By.tagName("td"));

        String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
        String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
        String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();

        System.out.println("mas deuda: " + nombre + apellido);

        // tabla 2 ordenar por nombre y entregar la deuda de los usuarios sin usar xpath


    }

    @After
    public void close() {
        // if (driver != null) driver.close();
    }
}
