package selenium.lkelly;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManejoPopup {
    WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }

    @Test
    public void popupJSAlert(){
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       WebElement btnJSAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        btnJSAlert.click();
        Alert popup1 = driver.switchTo().alert();
        String text =popup1.getText();
        if(text.contains("JS Alert")){
            popup1.accept();
        }
    }

    @Test
    public void popupJSConfirm(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnJSConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        btnJSConfirm.click();
        Alert popup2 = driver.switchTo().alert();
        String text =popup2.getText();
        if(text.contains("JS Confirm")){
            popup2.dismiss();
            btnJSConfirm.click();
            popup2.accept();
        }
    }

    @Test
    public void popupJSPrompt(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnJSConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        btnJSConfirm.click();
        Alert popup2 = driver.switchTo().alert();
        String text =popup2.getText();
        if(text.contains("JS Confirm")){
            popup2.dismiss();
            btnJSConfirm.click();
            popup2.accept();
        }
    }

    @Test
    public void popupAuth(){
        String user = "admin";
        String pass ="admin";
        //Autorización básica
        // https://user:pass@url.com
        driver.get("https://" + user + ":" + pass + "@the-internet.herokuapp.com/basic_auth");
        WebElement ingresoExitoso = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"));
        Assert.assertEquals("Congratulations! You must have the proper credentials.",ingresoExitoso.getText());
    }
    @Test
    public void popupWindows(){
        //Generalmente este popup aparece cuando se quiere subir un archivo
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload = driver.findElement(By.xpath("//input[@id='file-upload']"));
        WebElement btnUpload = driver.findElement(By.xpath("//input[@id='file-submit']"));
        //subir archivos
        upload.sendKeys("C:\\Users\\Luisina.Kelly\\Documents\\Bootcamp\\Selenium\\Basico\\ejemploSubir.txt"); //ruta del archivo que vamos a subir
        btnUpload.click();

        WebElement validacionUpload = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]"));
        Assert.assertEquals("File Uploaded!", validacionUpload.getText());
    }
}
