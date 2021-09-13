package desafio.grupo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class tc_005 {
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
    public void tc005() throws InterruptedException {
        System.out.println("---Filtrar paquetes por escalas---");
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

        //Elegimos ver detalle del primer elemento----------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div[2]/div/div[2]/aloha-list-view-container/div[2]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button/em")).click();
        Thread.sleep(2000);
        //aca cambia de ventana:
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            Thread.sleep(3000);
        }
        //btn:siguiente
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-detail/div/div[3]/div[2]/div/aloha-infobox-container/aloha-infobox-wrapper-container/div/div/div/aloha-infobox-shopping-content/div/div[2]/aloha-next-step-button/aloha-button/button")).click();
        Thread.sleep(4000);

        //Filtramos por escalas------------------------------------------------------------------------------------------------------------------------------------------------------
        //activamos el check de una escala
        driver.findElement(By.xpath("//*[@id=\"filter-stops\"]/li/ul/div/checkbox-filter/checkbox-filter-item[3]/li/span/span[1]/span/label/i")).click();
        Thread.sleep(7000);

        //VALIDAMOS ------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String msj1 = "Directo";
        String msj2 = "1 escala";
        String actual = driver.findElement(By.xpath("//*[@id=\"trips-cluster-selected-position\"]/trips-cluster-selected/span/cluster/div/div/div[1]/div/span/div/div[2]/span[1]/route-choice/ul/li/route/itinerary/div/div/div[2]/itinerary-element[2]/span/stops-count-item/span/span")).getText();
        System.out.println(actual);
        //Assert.assertEquals(msj, actual);
        if(actual.equals(msj1) || actual.equals(msj2)){
            Assert.assertTrue(true);
        }else
            Assert.fail();
    }



        @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }
}
