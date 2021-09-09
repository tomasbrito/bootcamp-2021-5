package desafio.grupo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class tc_001 {
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
    public void tc001() throws InterruptedException {
        System.out.println("---Reserva alojamiento---");//Happy path - Alojamiento
        driver.get("https://www.viajesfalabella.cl/hoteles/");

        //Seleccionar el destino---------------------------------------------------------------------------------------------------------------------------
        String destino = "buenos aires";
        WebElement campoDestino = driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input"));
        campoDestino.click();
        Thread.sleep(1000);
        campoDestino.sendKeys(destino);
        Thread.sleep(1000);
        campoDestino.sendKeys(Keys.ENTER);


        //Seleccionar una fecha---------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div/input")).click();
        WebElement fechaEntrada = driver.findElement(By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div._dpmg2--month._dpmg2--o-3._dpmg2--month-active > div._dpmg2--dates > span:nth-child(18) > span._dpmg2--date-number"));
        fechaEntrada.click();
        Thread.sleep(1000);

        WebElement fechaSalida = driver.findElement(By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(3) > span._dpmg2--date-number"));
        fechaSalida.click();
        //btn:aplicar
        driver.findElement(By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--date-footer > div._dpmg2--desktopFooter-btn-container > button._dpmg2--desktopFooter-button._dpmg2--desktopFooter-button-apply.sbox-3-btn.-lg.-primary > em")).click();

        //Seleccionar habitaciones---------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div")).click();
        Thread.sleep(1000);
        //agregamos adulto
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/a[2]")).click();
        //agregamos niño
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();
        Thread.sleep(1000);
        Select edad = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/select")));
        edad.selectByVisibleText("9 años");


        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[1]")).click();

        //Buscamos:---------------------------------------------------------------------------------------------------------------------------
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[4]/div/a/em")).click();
        Thread.sleep(4000);

        //Elegimos ver detalle del primer elemento----------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div[1]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button/em")).click();
        Thread.sleep(2000);
        //aca cambia de ventana:
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            Thread.sleep(4000);
        }
        //btn: ver habitaciones
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-detail/div/div[2]/div[2]/div/aloha-infobox-container/aloha-infobox-wrapper-container/div/div/div/aloha-infobox-shopping-content/div/div[2]/aloha-button/button")).click();
        //obtenemos precio por noche y descuento
        String precioXNoche = driver.findElement(By.xpath("//*[@id=\"roompacks-container-wrapper\"]/aloha-roompacks-container/aloha-roompacks-grid-container/div[2]/div[1]/aloha-roompacks-group-container/div[2]/aloha-roompack-container/div[2]/aloha-roompack-price-container/aloha-summary-price/div/span[2]")).getText();
        //btn: ver habitaciones
        driver.findElement(By.xpath("//*[@id=\"roompacks-container-wrapper\"]/aloha-roompacks-container/aloha-roompacks-grid-container/div[2]/div[2]/aloha-reservation-summary-container/div/aloha-next-step-button/aloha-button/button/em")).click();
        Thread.sleep(4000);
        String ubicacionHotel = driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-detail/div/aloha-re-search-container/aloha-re-search/div/div[1]/div/ul/li[2]/span/span")).getText();//capturo la ubicacion
        //btn:Reservar ahora
        driver.findElement(By.xpath("//*[@id=\"roompacks-container-wrapper\"]/aloha-roompacks-container/aloha-roompacks-grid-container/div[2]/div[2]/aloha-reservation-summary-container/div/aloha-next-step-button/aloha-button/button/em")).click();
        Thread.sleep(4000);
        //btn:siguiente
        driver.findElement(By.xpath("//*[@id=\"pricebox-overlay\"]/div[1]/div/button/em")).click();
        Thread.sleep(5000);

        //VALIDAMOS ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String msjPersonas = "Alojamiento para 4 personas";
        double totalEsperado = Double.parseDouble(precioXNoche) * 15;
        String totalA = driver.findElement(By.xpath("//*[@id=\"chk-total-price\"]/div[2]/money/div/span[3]")).getText();
        double totalActual = Double.parseDouble(totalA);
        String cantPersonas = driver.findElement(By.xpath("//*[@id=\"pricebox-list-detail\"]/ul/div[1]/div[1]/p/span")).getText();

        if (totalEsperado == totalActual && cantPersonas.equals(msjPersonas)  ){
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
