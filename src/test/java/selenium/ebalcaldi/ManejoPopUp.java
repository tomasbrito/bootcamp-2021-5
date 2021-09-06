package selenium.ebalcaldi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class ManejoPopUp {
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void close(){
        System.out.println("After");
        if(driver !=null){
            driver.close();
        }
    }

    @Test
    public void popupJSAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnJsAlert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        btnJsAlert.click();
        Alert popUp1 = driver.switchTo().alert();
        String texto = popUp1.getText();
        if(texto.contains("JS Alert"))
            popUp1.accept();

    }
    @Test
    public void popupJsConfirm(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnJsConfirm = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
        btnJsConfirm.click();
        Alert popUp1 = driver.switchTo().alert();
        String texto = popUp1.getText();
        if(texto.contains("JS Confirm")) {
            popUp1.dismiss();
            btnJsConfirm.click();
            popUp1.accept();
        }
    }
    @Test
    public void popupJSPrompt(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnJsPrompt = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        btnJsPrompt.click();
        Alert popUp1 = driver.switchTo().alert();
        String texto = popUp1.getText();
        if(texto.contains("JS prompt")) {
            popUp1.sendKeys("hola");
            popUp1.accept();
        }
    }
    @Test
    public void popupAuth(){
        String user = "admin";
        String pass = user;
        driver.get("https://"+user+":"+pass+"@the-internet.herokuapp.com/basic_auth");
        WebElement ingresoExitoso = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p"));
        Assert.assertEquals("Congratulations! You must have the proper credentials.", ingresoExitoso.getText());

    }
    @Test
    public void popupWindows(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement btnArchivo = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
        btnArchivo.sendKeys("C:\\Users\\Ezequiel.Balcaldi\\Documents\\Prueba\\prueba.txt");
        btnArchivo.click();
        WebElement validacionUpload = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        Assert.assertEquals("File Uploaded!", validacionUpload);
    }
}
