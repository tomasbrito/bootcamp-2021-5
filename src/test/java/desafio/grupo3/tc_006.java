package desafio.grupo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class tc_006 {
    WebDriver driver;

    @BeforeClass
    public static void SetUp(){
        System.out.println("Setup");
        WebDriverManager.chromedriver().setup();;
    }

    @Before
    public void init(){
        System.out.println("init");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void tc006() throws InterruptedException {
        System.out.println("---Filtrar paquetes por estrellas---");
        driver.get("https://www.viajesfalabella.cl/paquetes");

        //Seleccionar ciudad origen----------------------------------------------------------------------------------------------------------------------------------------------------
        WebElement campoOrigen = driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div/input"));
        campoOrigen.click();
        campoOrigen.sendKeys("bue");//buenos aires
        Thread.sleep(1000);
        campoOrigen.sendKeys(Keys.ENTER);
        //Seleccionar ciudad destino----------------------------------------------------------------------------------------------------------------------------------------------------
        WebElement campoDest = driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div/input"));
        campoDest.click();
        campoDest.sendKeys("mia");//miami
        Thread.sleep(1000);
        campoDest.sendKeys(Keys.ENTER);

        //Seleccionar una fecha---------------------------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[3]/div/div[1]/div/input")).click();
        WebElement fechaIda = driver.findElement(By.xpath("/html/body/div[5]/div/div[5]/div[1]/div[4]/span[18]/span[1]"));
        fechaIda.click();
        Thread.sleep(1000);

        WebElement fechaVuelta = driver.findElement(By.xpath("/html/body/div[5]/div/div[5]/div[2]/div[4]/span[3]/span[1]"));
        fechaVuelta.click();
        //btn: aplicar
        driver.findElement(By.xpath("/html/body/div[7]/div/div[6]/div[2]/button[2]/em")).click();

        //Seleccionar habitaciones---------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[5]/div/div/div[5]/div/div")).click();
        Thread.sleep(1000);
        //agregamos adulto-btn:+
        driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/a[2]")).click();
        //agregamos niño
        driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();
        Thread.sleep(1000);
        Select edad = new Select(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/select")));
        edad.selectByVisibleText("9 años");
        //btn:aplicar
        driver.findElement(By.cssSelector("body > div.distpicker.distpicker-rooms-packages.sbox-v4-components > div > div._pnlpk-panel__footer.-medium-down-to-lg > a._pnlpk-apply-button.sbox-3-btn.-primary._pnlpk-panel__button--link-right.-lg")).click();

        //Buscamos:---------------------------------------------------------------------------------------------------------------------------
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[6]/div/a/em")).click();
        Thread.sleep(10000);

        //Filtramos por estrellas
        //checkeamos el check de 5 estrellas
        driver.findElement(By.xpath("body > aloha-app-root > aloha-results > div > div > div.results-wrapper.-eva-3-mt-xlg > div.filters-column > aloha-filter-list > div > ul > li:nth-child(3) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(4) > span > span.filters-checkbox > aloha-checkbox > span > label > i")).click();
        Thread.sleep(2000);

    }



    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }
}
