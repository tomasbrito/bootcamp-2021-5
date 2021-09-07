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
        WebElement fieldDesde  =  driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/div/div/input"));
        fieldDesde.sendKeys("buenos");
        exwait.until(ExpectedConditions.elementToBeClickable(desdePopUp));
        fieldDesde.sendKeys(Keys.ENTER);

        //llenar campo "hasta"
        WebElement fieldHasta =  driver.findElement(By.cssSelector("body.show-phone:nth-child(2) div.searchbox-container div.searchbox-sbox-boxes.sbox-main.sbox-ui-horizontal.-sbox-hide-without-date.-sbox-hide-advanced-options:nth-child(9) div.sbox-show-hide-container.-sbox-3-shadow-static div.sbox-ui-container.sbox-transfers-container div.sbox-mobile-body div.sbox-row.-wrap.-row-top div.sbox-places div.sbox-places-group-container.sbox-row.-mb5-m.-wrap-s.-wrap div.sbox-second-place-container div.sbox-place-container.-mb4-s div.sbox-input-container div.sbox-3-input.-md.sbox-3-validation.-top-right.-icon-left.sbox-destination-container div.input-container > input.input-tag.sbox-main-focus.sbox-destination.sbox-secondary.sbox-places-second.places-inline:nth-child(2)"));
        fieldHasta.sendKeys("hilton");
        exwait.until(ExpectedConditions.elementToBeClickable(hastaPopUp));
        fieldHasta.sendKeys(Keys.ENTER);

        //click checkbox regreso
        driver.findElement(By.cssSelector("body.show-phone:nth-child(2) div.searchbox-container div.searchbox-sbox-boxes.sbox-main.sbox-ui-horizontal.-sbox-hide-without-date.-sbox-hide-advanced-options:nth-child(9) div.sbox-show-hide-container.-sbox-3-shadow-static div.sbox-ui-container.sbox-transfers-container div.sbox-mobile-body div.sbox-row.-wrap.-row-top div.sbox-places div.sbox-places-group-container.sbox-row.-mb5-m.-wrap-s.-wrap div.sbox-places-check.-mb4-s.-mt3-m.-mt3-l.sbox-round-trip span.sbox-3-checkbox.-md > label.checkbox-label")).click();

        //click fecha ida
        driver.findElement(By.xpath("//div[@class='sbox-3-input -md sbox-3-validation -top-right -icon-left sbox-checkin-container']//div[@class='input-container']//input[@type='text']")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--show-info _dpmg2--roundtrip _dpmg2--show']//div[@class='_dpmg2--months']//div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--month-active']//div[@class='_dpmg2--dates']//span[@class='_dpmg2--date _dpmg2--available']//span[@class='_dpmg2--date-number'][contains(text(),'16')]")).click();

        //click fecha vuelta
        driver.findElement(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--has-start-range _dpmg2--month-active']//div[@class='_dpmg2--dates']//span[@class='_dpmg2--date _dpmg2--available']//span[@class='_dpmg2--date-number'][contains(text(),'30')]")).click();

        //click aplicar
        driver.findElement(By.xpath("//button[@class='_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary']//em[@class='_dpmg2--desktopFooter-button-apply-text btn-text'][contains(text(),'Aplicar')]")).click();

        //click buscar
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-transferspoi\"]/div/div/div[3]/div[2]/div[5]/div")).click();

        By auto = By.xpath("//body[@id='bodyID']/div[@class='ds-transfers-wrapper']/div[@class='ng-scope']/div[@class='ds-transfers-search-view ng-scope']/div[@class='search-view-container-wrapper']/main[@class='search-view-container']/div[@style='position:relative;']/div[@class='results']/div[@class='search-view-items-container']/div[5]/search-item[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/span[1]/h1[1]");
        exwait.until(ExpectedConditions.elementToBeClickable(auto));
        WebElement salida = driver.findElement(By.xpath("//body[@id='bodyID']/div[@class='ds-transfers-wrapper']/div[@class='ng-scope']/div[@class='ds-transfers-search-view ng-scope']/div[@class='search-view-container-wrapper']/main[@class='search-view-container']/div[@style='position:relative;']/div[@class='results']/div[@class='search-view-items-container']/div[5]/search-item[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/span[1]/h3[2]/span[1]/span[1]"));
        Assert.assertEquals("Salida desde el punto que elegiste:", salida.getText());
        System.out.println("");
    }

}
