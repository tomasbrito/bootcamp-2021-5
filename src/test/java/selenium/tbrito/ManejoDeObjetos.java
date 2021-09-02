package selenium.tbrito;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManejoDeObjetos {

    WebDriver driver;

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setUp() {
        System.out.println("SetUp");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select manejoDropdown = new Select(dropdown);
        manejoDropdown.selectByValue("1");
        manejoDropdown.selectByValue("2");

        manejoDropdown.selectByVisibleText("Option 1");
    }

    @Test
    public void dropdownDinamico(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
        WebElement btnEnabled = driver.findElement(By.id("ui-id-3"));
        WebElement btnDownloads = driver.findElement(By.id("ui-id-4"));
        WebElement btnPDF = driver.findElement(By.id("ui-id-5"));

        //navegacion
        btnEnabled.click();
        btnDownloads.click();
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
    }

    @Test
    public void iframes(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

        //cambiar al iframe
        driver.switchTo().frame(iframes.get(0));
        //seleccionar objetos del iframe
        WebElement escribir = driver.findElement(By.id("tinymce"));
        escribir.clear();
        escribir.sendKeys("hola");

   }

}
