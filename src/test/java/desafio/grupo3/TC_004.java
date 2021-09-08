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

public class TC_004 {
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
    public void tc_004() throws InterruptedException {
        System.out.println("---Reserva alojamiento---");
        driver.get("https://www.viajesfalabella.cl/hoteles/");

        //Seleccionar el destino---------------------------------------------------------------------------------------------------------------------------
        WebElement destino = driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input"));
        destino.click();
        Thread.sleep(1000);
        destino.sendKeys("mia");
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

        //Buscamos:---------------------------------------------------------------------------------------------------------------------------
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[4]/div/a/em")).click();
        Thread.sleep(8000);

    //Filtramos----------------------------------------------------------------------------------------------------------------
        String desde = "1000000";
        String hasta = "500000";
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-filter-list/div/ul/li[2]/aloha-filter/aloha-slider-filter/ul/div[3]/div[1]/aloha-input/div/div/input")).sendKeys(desde);
        Thread.sleep(1000);
        WebElement campoHasta = driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-filter-list/div/ul/li[2]/aloha-filter/aloha-slider-filter/ul/div[3]/div[2]/aloha-input/div/div/input"));
        campoHasta.click();
        campoHasta.sendKeys(Keys.END);
        for (int i = 0; i < 7; i++) {
            campoHasta.sendKeys(Keys.BACK_SPACE);
        }
        campoHasta.sendKeys(hasta);
        //aplicar filtro
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-filter-list/div/ul/li[2]/aloha-filter/aloha-slider-filter/ul/aloha-button/button/em")).click();



    }


    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }


}
