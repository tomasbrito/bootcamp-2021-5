package desafio.grupo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tc_012 {


    WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup () {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); // borrar cookies
        driver.manage().window().maximize();
    }

    @After
    public void close () {
        if (driver != null){
            driver.close();
        }
    }
    //div[@class='sbox-places-group-container sbox-row -mb5-m -wrap-s -wrap']
    @Test
    public void test() throws InterruptedException {
        WebDriverWait exwait = new WebDriverWait(driver,10);
        By desdePopUp = By.xpath("//span[@class='ac-group-title eva-3-overline-2']");
        By hastaPopUp = By.xpath("//div[@class='ac-wrapper -desktop -facet -show']//div[@class='ac-container']");
        driver.get("https://www.viajesfalabella.cl/");
        //click traslado
        driver.findElement(By.xpath("//i[@class='shifu-icon-product shifu-3-icon-traslate']")).click();

        //llenar campo "desde"
        WebElement fieldDesde  =  driver.findElement(By.xpath("//input[@placeholder='Ingresa un aeropuerto']"));
        fieldDesde.sendKeys("buenos");
        exwait.until(ExpectedConditions.elementToBeClickable(desdePopUp));
        fieldDesde.sendKeys(Keys.ENTER);

        //llenar campo "hasta"
        WebElement fieldHasta =  driver.findElement(By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']"));
        fieldHasta.sendKeys("hilton");
        exwait.until(ExpectedConditions.elementToBeClickable(hastaPopUp));
        fieldHasta.sendKeys(Keys.ENTER);

        //click checkbox regreso
        driver.findElement(By.xpath("//input[@class='checkbox-tag sbox-round-trip-check']/following-sibling::i[1]")).click();

        //click fecha ida

        driver.findElement(By.xpath("//input[@class='input-tag sbox-checkin']")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--show-info _dpmg2--roundtrip _dpmg2--show']//div[@class='_dpmg2--months']//div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--month-active']//div[@class='_dpmg2--dates']//span[@class='_dpmg2--date _dpmg2--available']//span[@class='_dpmg2--date-number'][contains(text(),'16')]")).click();

        //click fecha vuelta
        driver.findElement(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--has-start-range _dpmg2--month-active']//div[@class='_dpmg2--dates']//span[@class='_dpmg2--date _dpmg2--available']//span[@class='_dpmg2--date-number'][contains(text(),'30')]")).click();

        //click aplicar
        driver.findElement(By.xpath("(//em[@class='_dpmg2--desktopFooter-button-apply-text btn-text'])[2]")).click();

        //click buscar
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[5]/div")).click();

        By auto = By.xpath("(//span[@class='transfer-detail'])[5]");
        exwait.until(ExpectedConditions.elementToBeClickable(auto));
        WebElement salida = driver.findElement(By.xpath("(//span[text()='Salida desde el punto que elegiste:'])[5]"));
        Assert.assertEquals("Salida desde el punto que elegiste:", salida.getText());
        System.out.println("");
    }

}