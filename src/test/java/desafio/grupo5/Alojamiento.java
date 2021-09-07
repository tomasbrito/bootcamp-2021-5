package desafio.grupo5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.HKSCS;
public class Alojamiento {
    WebDriver driver;
    By botonAlojamiento = By.xpath("//*[contains(@class, 'shifu-3-button-circle HOTELS ')]");
    By imputDestino = By.xpath("//*[contains(@class, 'sbox-destination sbox-primary ')]");
    By fechaEntrada = By.xpath("//*[contains(@class, 'sbox-checkin-date-container')]");
    By btnByReserva = By.xpath("//*[@id=\"roompacks-container-wrapper\"]/aloha-roompacks-container/aloha-roompacks-grid-container/div[2]/div[2]/aloha-reservation-summary-container/div/aloha-next-step-button/aloha-button/button/em");
    By imputTarjeta = By.xpath("//*[@id=\"checkout-content\"]/div[1]/payment-component/div/div[1]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div/div[2]/card-container/div/div[2]/card-storage/modal-component/div/div[2]/payment-option-selector/div[2]/div/div/div/input");
    By numeroTarjeta = By.xpath("//*[@id=\"formData.paymentData.cardPayments[0].card.number\"]/div/input");
    By titularTarjeta = By.xpath("//*[@id=\"formData.paymentData.cardPayments[0].card.holderName\"]/div/input");
    By vencimientoTarjeta = By.xpath("//*[@id=\"formData.paymentData.cardPayments[0].card.expirationDate\"]/div/input");
    By codSeg = By.xpath("//*[@id=\"formData.paymentData.cardPayments[0].card.securityCode\"]/div/input");
    By DNI = By.xpath("//*[@id=\"formData.paymentData.cardPayments[0].cardHolderIdentification.number\"]/div/input");
    By error = By.xpath("//*[@id=\"formData.paymentData.cardPayments[0].card.number\"]/validation-error/span");

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //Borrando Cookies
        driver.manage().window().maximize();
    }
    @Test
    public void atc05() throws InterruptedException {
        driver.get("https://www.viajesfalabella.cl");
        System.out.println("Se abre URL");
        Thread.sleep(500);
        Assert.assertEquals("https://www.viajesfalabella.cl/", driver.getCurrentUrl());
        driver.findElement(botonAlojamiento)
                .click();
        Thread.sleep(500);
        driver.findElement(imputDestino).sendKeys("Bari");
        Thread.sleep(500);
        driver.findElement(imputDestino).sendKeys(Keys.ENTER);
        Thread.sleep(500);
        WebElement check_box = driver.findElement(By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[5]/label[1]/i[1]"));
        check_box.click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/a[1]/i[1]"))
                .click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("hoteles-en-san+carlos+de+bariloche?"));
    }
    @Test
    public void atc06() throws InterruptedException {
        //Se abre el URL
        driver.get("https://www.viajesfalabella.cl/hoteles/hl/901/i1/hoteles-en-san+carlos+de+bariloche?from=SB&encodedProps=cGFnZT0xJnZpZXdNb2RlPWxpc3Q=#page=1&view=list");
        System.out.println("Se abre URL");
        Thread.sleep(500);
        //Se clickea en Fecha Entrada
        driver.findElement(fechaEntrada)
                .click();
        Thread.sleep(500);
        //Se clickea en 10/9/21
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/span[10]"))
                .click();
        Thread.sleep(500);
        //Se clickea en 17/9/21
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/span[17]/span[1]"))
                .click();
        Thread.sleep(500);
        //Se clickea en "Aplicar"
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[6]/div[2]/button[2]"))
                .click();
        Thread.sleep(2000);
        //Se clickea en "Buscar"
        driver.findElement(By.xpath("//*[@id=\"sbox-main\"]/div/div/div[3]/div[2]/div[4]"))
                .click();
        //Se abre nueva pestaña
        Thread.sleep(2000);
        //Se clickea checkbox
        WebElement check_box = driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-filter-list/div/ul/li[4]/aloha-filter/aloha-checkbox-filter/ul/li[4]/span/span[1]/aloha-checkbox/span/label/em/span"));
        check_box.click();
        Thread.sleep(2000);
        //Se clickea checkbox
        WebElement check_box2 = driver.findElement(By.xpath("//body/aloha-app-root[1]/aloha-results[1]/div[1]/div[1]/div[1]/div[1]/aloha-filter-list[1]/div[1]/ul[1]/li[4]/aloha-filter[1]/aloha-checkbox-filter[1]/ul[1]/li[1]/span[1]/span[1]/aloha-checkbox[1]/span[1]/label[1]/i[1]"));
        check_box2.click();
        Thread.sleep(2000);
        //Se clickea checkbox
        WebElement check_box3 = driver.findElement(By.xpath("//body/aloha-app-root[1]/aloha-results[1]/div[1]/div[1]/div[1]/div[1]/aloha-filter-list[1]/div[1]/ul[1]/li[4]/aloha-filter[1]/aloha-checkbox-filter[1]/ul[1]/li[3]/span[1]/span[1]/aloha-checkbox[1]/span[1]/label[1]/i[1]"));
        check_box3.click();
        Thread.sleep(2000);
        //Se clickea en Hotel
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div[4]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button"))
                .click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.viajesfalabella.cl/accommodations/detail/"));
        //Se clickea en alojamiento
        Thread.sleep(5000);
        driver.findElement(btnByReserva)
                .click();
        Thread.sleep(2000);
        //Se clickea en "Siguiente"


    }
    @Test
    public void atc07() throws InterruptedException {
        driver.get("https://www.viajesfalabella.cl/trips/xs/PC71dcee7a6b214642ab50c33cb94c4daa27184064?searchParams=SC8yMDIxLTA5LTEwLzIwMjEtMDktMTcvQ0lUXzkwMS8y&searchId=5d939d37-5a83-4ecd-81f1-dc2f34b01f60&stepNum=0&locale=es-CL&dc=false&tx=true&d=aHR0cHM6Ly93d3cudmlhamVzZmFsYWJlbGxhLmNsL2FjY29tbW9kYXRpb25zL2RldGFpbC8yNjM3NzQvMjAyMS0wOS0xMC8yMDIxLTA5LTE3LzI%2Fc2VsZWN0ZWRfcm9vbV9wYWNrPTk4NjIzMTUwNyZzZWFyY2hJZD01ZDkzOWQzNy01YTgzLTRlY2QtODFmMS1kYzJmMzRiMDFmNjAmdGhyb3VnaFJlc3VsdHM9dHJ1ZQ%3D%3D&currency=CLP&flow=H&oTid=PCa3bf6532c80a4a96a3e092f3f018ef9527184063");
        System.out.println("Se abre URL");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pricebox-overlay\"]/div[1]/div/button/em"))
                .click();
        Thread.sleep(7000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.viajesfalabella.cl/checkout/"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/af-app[1]/div[1]/div[1]/div[1]/checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/payment-component[1]/div[1]/div[1]/payment-method[1]/div[1]/payment-method-selector-container[1]/prepaid-payment-container[1]/div[1]/div[1]/div[2]/card-container[1]/div[1]/div[2]/card-storage[1]/div[1]/card-empty-slot[1]/div[1]/div[1]/div[1]/div[1]"))
                .click();
        Thread.sleep(2000);
        driver.findElement(imputTarjeta).sendKeys("San");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/payment-component/div/div[1]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div/div[2]/card-container/div/div[2]/card-storage/modal-component/div/div[2]/payment-option-selector/div[2]/ul/li[1]/span"))
                .click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/payment-component/div/div[1]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div/div[2]/card-container/div/div[2]/card-storage/modal-component/div/div[2]/payment-option-selector/div[2]/ul/li[2]/span"))
                .click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/payment-component/div/div[1]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div/div[2]/card-container/div/div[2]/card-storage/modal-component/div/div[2]/payment-option-selector/div[2]/ul/li[1]"))
                .click();
        Thread.sleep(1000);
        driver.findElement(numeroTarjeta).sendKeys("0000000000000000");
        Thread.sleep(1000);
        driver.findElement(titularTarjeta).sendKeys("Roberto Nuñez");
        Thread.sleep(1000);
        driver.findElement(vencimientoTarjeta).sendKeys("04/32");
        Thread.sleep(1000);
        driver.findElement(codSeg).sendKeys("511");
        Thread.sleep(1000);
        driver.findElement(DNI).sendKeys("45000000");
        Assert.assertEquals("Ingresa un número de tarjeta válido", driver.findElement(error).getText());
    }
    @Test
    public void atc08() throws InterruptedException {

    }
    @After
    public void close(){
        System.out.println("After");
        if(driver != null);
        //driver.close();
    }
}

