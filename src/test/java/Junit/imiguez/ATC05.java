package junit.imiguez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ATC05 {


    WebDriver driver;

    @BeforeClass
    public static void init() {
        System.out.println("Init");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        System.out.println("SetUp");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdown() {
        System.out.println("Sesion 4");
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByValue("1");
        select.selectByValue("2");
    }

    @Test
    public void dynamicDropdown() {
        System.out.println("Sesion 4");
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement btnEnable = driver.findElement(By.id("ui-id-3"));
        WebElement btnDownload = driver.findElement(By.id("ui-id-4"));
        WebElement btnPDF = driver.findElement(By.id("ui-id-5"));
        btnEnable.click();
        btnDownload.click();
        Assert.assertEquals("PDF", btnPDF.getAttribute("innerText"));
    }

    @Test
    public void checkbox() {
        //TODO
    }

    @Test
    public void iframes() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(iframes.get(0));
        WebElement escribir = driver.findElement(By.id("tinymce"));
        escribir.clear();
        escribir.sendKeys("Hello World!");
    }

    @Test
    public void tables() {
        //Ordenar por deuda en la tabla 2 usando cssSelector
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> tables = driver.findElements(By.tagName("table"));
        WebElement t1 = tables.get(0);
        List<WebElement> colNames = t1.findElements(By.tagName("th"));
        for (int i = 0; i < colNames.size(); i++) {
            WebElement col = colNames.get(3);
            if (col.getText().toLowerCase().equals("due")) {
                col.click();
                col.click();
            }
        }
    }

    @Test
    public void tables2() {
        //Ordenar por deuda en la tabla 2 usando cssSelector
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table = driver.findElement(By.id("table2"));
        List<WebElement> colNames = table.findElements(By.cssSelector("#table2 > thead > tr > th.header.headerSortDown > span"));
        for (int i = 0; i < colNames.size(); i++) {
            WebElement col = colNames.get(i);
            if (col.getText().toLowerCase().equals("due")) {
                col.click();
                col.click();
            }
        }
    }


    @After
    public void clean() {
        System.out.println("Clean");
        if (driver != null)
            driver.close();
    }

}
