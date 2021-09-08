package desafio.grupo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tc_008 {


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

    @Test
    public void test() {
        WebDriverWait exwait = new WebDriverWait(driver,15);
        By origenPopUp = By.xpath("//div[@class='ac-container']");
        By destinoPopUp = By.xpath("//div[@class='ac-container']");
        driver.get("https://www.viajesfalabella.cl/");
        //click paquetes
        driver.findElement(By.xpath("//i[@class='shifu-icon-product shifu-3-icon-packages']")).click();

        //llenar campo "origen"
        WebElement fieldDesde = driver.findElement(By.xpath("(//input[contains(@class,'input-tag sbox-main-focus')])[1]"));
        fieldDesde.click();
        fieldDesde.sendKeys("buenos aires");
        exwait.until(ExpectedConditions.elementToBeClickable(origenPopUp));
        fieldDesde.sendKeys(Keys.ENTER);

        //llenar campo "destino"
        WebElement fieldHasta = driver.findElement(By.xpath("(//input[contains(@class,'input-tag sbox-main-focus')])[2]"));
        fieldHasta.click();
        fieldHasta.sendKeys("mendoza");
        exwait.until(ExpectedConditions.elementToBeClickable(destinoPopUp));
        fieldHasta.sendKeys(Keys.ENTER);

        //elegir fecha ida
        By popUpFecha = By.xpath("(//div[@class='_dpmg2--controlsWrapper'])[3]");
        driver.findElement(By.xpath("//div[@class='input-container sbox-checkin-input-container']//input[@type='text']")).click();
        exwait.until(ExpectedConditions.elementToBeClickable(popUpFecha));
        WebElement fechaIda = driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--months']//div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--month-active']//div[@class='_dpmg2--dates']/span[10]"));
        fechaIda.click();

        //elegir fecha vuelta
        driver.findElement(By.xpath("//body[@class='show-phone']/div[@class='datepicker-packages sbox-v4-components']/div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show _dpmg2--transition-displacement']/div[@class='_dpmg2--months']/div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--has-start-range _dpmg2--month-active']/div[@class='_dpmg2--dates']/span[24]")).click();

        //click boton "aplicar"
        driver.findElement(By.xpath("(//em[@class='_dpmg2--desktopFooter-button-apply-text btn-text'])[5]")).click();

        //click boton "buscar"
        driver.findElement(By.xpath("(//a[contains(@class,'sbox-3-btn -primary')])[3]")).click();


        By hotel = By.xpath("(//div[@class='cluster-description cluster-description-top'])[1]");
        exwait.until(ExpectedConditions.elementToBeClickable(hotel));
        //click boton "siguiente"
        driver.findElement(By.xpath("(//button[contains(@class,'eva-3-btn -md')])[2]")).click();

        exwait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }


        exwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Ver todos los servicios')]")));
        //click en "ver detalle de la habitacion"
        driver.findElement(By.xpath("//div[contains(text(),'Ver todos los servicios')]")).click();


        WebElement ofreceBoton = driver.findElement(By.xpath("//h4[contains(text(),'El alojamiento ofrece')]"));
        Assert.assertEquals("El alojamiento ofrece",ofreceBoton.getText());
    }

}
