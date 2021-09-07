package desafio.grupo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TCT03 {
    WebDriver driver;

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
    public void tct03() throws InterruptedException {
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//body/nav[1]/div[2]/div[1]/div[3]/ul[1]/li[6]/a[1]")).click();

        WebElement origen= driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/div/div/input"));
        origen.click();
        origen.sendKeys("Santiago");

        driver.findElement(By.xpath("/html/body/div[15]/div/div/ul/li[1]")).click();

        WebElement destino = driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div/input"));
        destino.click();
        destino.sendKeys("Sheraton");

        driver.findElement(By.xpath("//span[contains(text(),'Sheraton Miramar - Avenida Marina, Viña del Mar, C')]")).click();

        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[3]/span/label/i")).click();

        driver.findElement(By.className("sbox-moment-input")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/i")).click();

        driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[3]/div[4]/span[10]/span[1]")).click();//fecha inicio
        driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[3]/div[4]/span[17]/span[1]")).click();//fecha salida

        driver.findElement(By.xpath("//body/div[3]/div[1]/div[6]/div[2]/button[2]/em[1]")).click();

        WebElement drop1= driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[3]/div/div[1]/div/div/div[2]/div/div/select"));
        drop1.click();
        Select dropdownIda= new Select(drop1);
        dropdownIda.selectByValue("180");

        WebElement drop2= driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div/select"));
        drop2.click();
        Select dropdownVuelta= new Select(drop2);
        dropdownVuelta.selectByValue("180");

        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[5]/div/a/i")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/ul/li[4]/a[1]")).click();
        WebElement ida= driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[2]/div/div[1]/div/div/div/input"));
        WebElement vuelta= driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div/input"));
        WebElement fechaIda = driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[3]/div/div[1]/div/div/div[1]/div/div/input"));
        WebElement fechaVuelta =driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div/input"));
        WebElement horaIda = driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[3]/div/div[1]/div/div/div[2]/div/div/select"));
        WebElement horaVuelta= driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div/select"));

        Assert.assertEquals("input", ida.getTagName());
        Assert.assertEquals("input", vuelta.getTagName());
        Assert.assertEquals("input", fechaIda.getTagName());
        Assert.assertEquals("input", fechaVuelta.getTagName());
        Assert.assertEquals("select", horaIda.getTagName());
        Assert.assertEquals("select", horaVuelta.getTagName());
    }


}
