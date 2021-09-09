package desafio.grupo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class tc_002 {
    WebDriver driver; // es la instancia a crear del navegador - firefox, chrome, safari

    @BeforeClass
    public static void SetUp(){
        System.out.println("Setup");
        WebDriverManager.chromedriver().setup();; //vamos a crear una instancia de Google Chrome
    }

    @Before
    public void init(){
        System.out.println("init");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();
    }

    @Test
    public void tc_002() throws InterruptedException {
        System.out.println("---Reserva alojamiento---");
        driver.get("https://www.viajesfalabella.cl/hoteles/");

        //Seleccionar el destino---------------------------------------------------------------------------------------------------------------------------
        WebElement destino = driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input"));
        destino.click();
        Thread.sleep(1000);
        destino.sendKeys("bue");
        Thread.sleep(1000);
        destino.sendKeys(Keys.ENTER);

        //Seleccionar una fecha---------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div/input")).click();
        WebElement fechaEntrada = driver.findElement(By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div._dpmg2--month._dpmg2--o-3._dpmg2--month-active > div._dpmg2--dates > span:nth-child(18) > span._dpmg2--date-number"));
        fechaEntrada.click();
        Thread.sleep(1000);

        WebElement fechaSalida = driver.findElement(By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(3) > span._dpmg2--date-number"));
        fechaSalida.click();

        driver.findElement(By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--date-footer > div._dpmg2--desktopFooter-btn-container > button._dpmg2--desktopFooter-button._dpmg2--desktopFooter-button-apply.sbox-3-btn.-lg.-primary > em")).click();

        //Seleccionar habitaciones---------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/a[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[1]")).click();

        //Buscamos:---------------------------------------------------------------------------------------------------------------------------
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[4]/div/a/em")).click();
        Thread.sleep(4000);

        //Elegimos "ver detalle" del primer elemento----------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div[1]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button/em")).click();
        Thread.sleep(2000);
        //aca cambia de ventana:--------------------------------------------------------------------------------------------------------------------------------------------------------
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            Thread.sleep(4000);
        }
        //btn:ver habitaciones----------------------------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-detail/div/div[2]/div[2]/div/aloha-infobox-container/aloha-infobox-wrapper-container/div/div/div/aloha-infobox-shopping-content/div/div[2]/aloha-button/button/em")).click();
        //btn:Reservar ahora
        driver.findElement(By.xpath("//*[@id=\"roompacks-container-wrapper\"]/aloha-roompacks-container/aloha-roompacks-grid-container/div[2]/div[2]/aloha-reservation-summary-container/div/aloha-next-step-button/aloha-button/button/em")).click();
        Thread.sleep(4000);
        //btn:siguiente
        driver.findElement(By.xpath("//*[@id=\"pricebox-overlay\"]/div[1]/div/button/em")).click();
        Thread.sleep(5000);

        //CMR puntos-----------------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/cmr-split/div/div/div/checkbox-component/span/label/i")).click();
        WebElement campo = driver.findElement(By.id("cmr-payer-identification-number"));
        campo.click();
        campo.sendKeys("ABC");
        driver.findElement(By.cssSelector("#checkout-content > div.col.-sm-12.-lg-8 > cmr-split > div > div > div > div > div > div.-eva-3-mb-xlg > span")).click();

        //Validamos------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String msj = "Ingresa un valor válido";
        Assert.assertEquals(msj, driver.findElement(By.xpath("//*[@id=\"formData.paymentData.cashPayments[0].payeeIdentification.number\"]/div/div/validation-error/span")).getText());
        }

    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }
}
