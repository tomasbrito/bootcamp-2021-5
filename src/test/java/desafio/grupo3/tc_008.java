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
        WebElement fieldDesde = driver.findElement(By.xpath("//div[@class='sbox-3-input -md sbox-3-validation -top-right -icon-left sbox-origin-container places-inline']//div[@class='input-container']//input[@type='text']"));
        fieldDesde.click();
        fieldDesde.sendKeys("buenos aires");
        exwait.until(ExpectedConditions.elementToBeClickable(origenPopUp));
        fieldDesde.sendKeys(Keys.ENTER);

        //llenar campo "destino"
        WebElement fieldHasta = driver.findElement(By.xpath("//div[@class='sbox-3-input -md sbox-3-validation -top-right -icon-left sbox-destination-container']//div[@class='input-container']//input[@type='text']"));
        fieldHasta.click();
        fieldHasta.sendKeys("mendoza");
        exwait.until(ExpectedConditions.elementToBeClickable(destinoPopUp));
        fieldHasta.sendKeys(Keys.ENTER);

        //elegir fecha ida
        By popUpFecha = By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--months']");
        driver.findElement(By.xpath("//div[@class='input-container sbox-checkin-input-container']//input[@type='text']")).click();
        exwait.until(ExpectedConditions.elementToBeClickable(popUpFecha));
        WebElement fechaIda = driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--months']//div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--month-active']//div[@class='_dpmg2--dates']/span[10]"));
        fechaIda.click();

        //elegir fecha vuelta
        driver.findElement(By.xpath("//body[@class='show-phone']/div[@class='datepicker-packages sbox-v4-components']/div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show _dpmg2--transition-displacement']/div[@class='_dpmg2--months']/div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--has-start-range _dpmg2--month-active']/div[@class='_dpmg2--dates']/span[24]")).click();

        //click boton "aplicar"
        driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show _dpmg2--transition-displacement']//div[@class='_dpmg2--date-footer']//div[@class='_dpmg2--desktopFooter-btn-container']//button[@class='_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary']")).click();

        //click boton "buscar"
        driver.findElement(By.xpath("//div[@class='sbox-button -ml3-l']//div[@class='sbox-button-container']//a[@class='sbox-3-btn -primary -md sbox-search']//em[@class='btn-text'][contains(text(),'Buscar')]")).click();

        exwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='-eva-3-mb-xlg']//aloha-cluster-container//div[@class='eva-3-cluster-gallery -eva-3-bc-white -eva-3-shadow-line-hover']//div[@class='cluster-container -eva-3-shadow-line']")));
        //click boton ""
        driver.findElement(By.xpath("//div[@class='-eva-3-mb-xlg']//aloha-cluster-container//div[@class='eva-3-cluster-gallery -eva-3-bc-white -eva-3-shadow-line-hover']//div[@class='cluster-container -eva-3-shadow-line']//div[@class='cluster-pricebox-container']//aloha-cluster-pricebox-container//div[@class='eva-3-pricebox-cluster -responsive -pkg']//div[@class='pricebox-top-container']//div[@class='pricebox-action']//aloha-button//button[@class='eva-3-btn -md -primary -eva-3-fwidth']")).click();

        exwait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }


        exwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Ver todos los servicios')]")));
        //click en "ver detalle de la habitacion"
        driver.findElement(By.xpath("//div[contains(text(),'Ver todos los servicios')]")).click();


        WebElement h4Ofrece = driver.findElement(By.xpath("//h4[contains(text(),'El alojamiento ofrece')]"));
        Assert.assertEquals("El alojamiento ofrece",h4Ofrece.getText());
    }

}
