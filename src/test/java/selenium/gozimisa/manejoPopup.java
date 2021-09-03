package selenium.gozimisa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class manejoPopup {
    WebDriver driver;
    By barraBusqueda = By.xpath("//*[@id='search_query_top']"); //en el navegador inspeccionar elemento y copiar XPath o select para css

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();//borrar cookies
        driver.manage().window().maximize();

    }

    @After
    public void close() {
        System.out.println("After");
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void popupAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        btnAlert.click();

        Alert popup1 = driver.switchTo().alert();

        String text = popup1.getText();
        if (text.contains("JS Alert")) {
            popup1.accept();
        }
    }

    @Test
    public void popupJsconfim() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnjsconfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
        btnjsconfirm.click();

        Alert popup1 = driver.switchTo().alert();

        String text = popup1.getText();
        if (text.contains("JS Confirm")) {
            popup1.dismiss();
            btnjsconfirm.click();
            popup1.accept();
        }
    }

    @Test
    public void popupJsPrompt() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnjspromt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
        btnjspromt.click();

        Alert popup1 = driver.switchTo().alert();

        String text = popup1.getText();
        if (text.contains("JS Prompt")) {
            popup1.sendKeys("hola");
            popup1.accept();
        }
    }

    @Test
    public void popupAuth(){
        String user="admin";
        String pass="admin";

        driver.get("https://"+user+":"+pass+"the-internet.herokuapp.com/basic_auth");
        WebElement exito = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]"));
        Assert.assertEquals("Congratulations! You must have the proper credentials.\n" +
                "\n", exito.getText());
    }

    @Test
    public void popupWindows(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload = driver.findElement(By.xpath("//input[@id='file-upload']"));

        upload.sendKeys("C:\\Users\\Gina.Ozimisa\\Pictures\\Screenpresso\\2021-08-09_15h07_47.png");

        WebElement btnupload = driver.findElement(By.xpath("//input[@id='file-submit']"));
        btnupload.click();

        WebElement validacion = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]"));
        Assert.assertEquals("File Uploaded!\n", validacion.getText());
    }
}