package desafio.grupo5;
//Intentando resolver el conflicto.
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
    By sepDiez = By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/span[10]");
    By direccion = By.xpath("/html[1]/body[1]/af-app[1]/div[1]/div[1]/div[1]/checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/payment-component[1]/div[1]/div[1]/payment-method[1]/div[1]/payment-method-selector-container[1]/prepaid-payment-container[1]/div[1]/div[2]/invoice-component[1]/div[1]/div[2]/div[1]/invoice-default-component[1]/div[1]/address[1]/div[1]/div[4]/div[1]/address-street-input[1]/div[1]/div[1]/input-component-v2[1]/div[1]/div[1]/div[1]/input[1]");
    By nombre = By.xpath("/html[1]/body[1]/af-app[1]/div[1]/div[1]/div[1]/checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/travelers[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/traveler[1]/div[1]/div[2]/div[1]/div[1]/traveler-first-name-input[1]/div[1]/div[1]/input-component-v2[1]/div[1]/div[1]/div[1]/input[1]");
    By apellido = By.xpath("/html[1]/body[1]/af-app[1]/div[1]/div[1]/div[1]/checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/travelers[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/traveler[1]/div[1]/div[2]/div[1]/div[1]/traveler-last-name-input[1]/div[1]/div[1]/input-component-v2[1]/div[1]/div[1]/div[1]/input[1]");
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
        Assert.assertEquals("San Carlos de Bariloche, Rio Negro, Argentina",driver.findElement(imputDestino).getAttribute("value"));
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
        driver.findElement(sepDiez)
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
        //Se clickea en el Hotel seleccionado
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div[4]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button"))
                .click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.viajesfalabella.cl/accommodations/detail/"));
        //Se clickea en el Alojamiento seleccionado
        Thread.sleep(5000);
        driver.findElement(btnByReserva)
                .click();
        Thread.sleep(2000);
        //Se clickea en "Siguiente"
    }
    @Test
    public void atc07() throws InterruptedException {
        driver.get("https://www.viajesfalabella.cl/trips/xs/PC9f96d043c15d4c02bcf7d9380a84d26b27184355?searchParams=SC8yMDIxLTA5LTEwLzIwMjEtMDktMTcvQ0lUXzkwMS8y&searchId=399447e6-c24a-4a3f-bde5-1cb06997bd48&stepNum=0&locale=es-CL&dc=false&tx=true&d=aHR0cHM6Ly93d3cudmlhamVzZmFsYWJlbGxhLmNsL2FjY29tbW9kYXRpb25zL2RldGFpbC8zNjE4MTAvMjAyMS0wOS0xMC8yMDIxLTA5LTE3LzI%2Fc2VsZWN0ZWRfcm9vbV9wYWNrPTE3MzA3OTg4MjImc2VhcmNoSWQ9Mzk5NDQ3ZTYtYzI0YS00YTNmLWJkZTUtMWNiMDY5OTdiZDQ4JnRocm91Z2hSZXN1bHRzPXRydWU%3D&currency=CLP&flow=H&oTid=PCaabc6aa915cd44bbae8df4a92a3c32f327184355");
        // Por problemas efectuados debidos a la Disponibilidad de Alojamientos del Hotel elejido anteriormente, nos vimos obligados a cambiar el mismo para que funcione el test.
        // De todas formas se podria usar como un caso distinto, un caso de error por disponibilidad.
        System.out.println("Se abre URL");
        Thread.sleep(2000);
        //Se clickea en "Siguiente"
        driver.findElement(By.xpath("//*[@id=\"pricebox-overlay\"]/div[1]/div/button/em"))
                .click();
        //Se esperan 7 segundos a que cargue la pagina
        Thread.sleep(7000);
        //Se valida que la url sea la esperada.
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.viajesfalabella.cl/checkout/"));
        Thread.sleep(2000);
       //Se clickea en el campo para buscar banco
        driver.findElement(By.xpath("//body/af-app[1]/div[1]/div[1]/div[1]/checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/payment-component[1]/div[1]/div[1]/payment-method[1]/div[1]/payment-method-selector-container[1]/prepaid-payment-container[1]/div[1]/div[1]/div[2]/card-container[1]/div[1]/div[2]/card-storage[1]/div[1]/card-empty-slot[1]/div[1]/div[1]/div[1]/div[1]"))
                .click();
        Thread.sleep(2000);
        //Se ingresa "San" en el campo de busqueda
        driver.findElement(imputTarjeta).sendKeys("San");
        Thread.sleep(1000);
        //Se apreta ENTER para elegir la primera opcion.
        driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/payment-component/div/div[1]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div/div[2]/card-container/div/div[2]/card-storage/modal-component/div/div[2]/payment-option-selector/div[2]/ul/li[1]/span"))
                .click();
        Thread.sleep(500);
        //Se clickea en "Mastercard
        driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/payment-component/div/div[1]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div/div[2]/card-container/div/div[2]/card-storage/modal-component/div/div[2]/payment-option-selector/div[2]/ul/li[2]/span"))
                .click();
        Thread.sleep(500);
        //Se clickea en 1 pago
        driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/payment-component/div/div[1]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div/div[2]/card-container/div/div[2]/card-storage/modal-component/div/div[2]/payment-option-selector/div[2]/ul/li[1]"))
                .click();
        Thread.sleep(1000);
        //Se ingresa en el campo el numero de la tarjeta
        driver.findElement(numeroTarjeta).sendKeys("0000000000000000");
        //Se valida que el numero de la tarjeta sea el esperado
        Assert.assertEquals("0000000000000000",driver.findElement(numeroTarjeta).getAttribute("value"));
        Thread.sleep(1000);
        //Se ingresa "Roberto Nuñez" en el campo "Titular de la Tarjeta".
        driver.findElement(titularTarjeta).sendKeys("Roberto Nuñez");
        //Se valida que el nombre ingresado sea el esperado.
        Assert.assertEquals("Roberto Nuñez",driver.findElement(titularTarjeta).getAttribute("value"));
        Thread.sleep(1000);
        //Se ingresa "04/32" en el campo "Vencimiento".
        driver.findElement(vencimientoTarjeta).sendKeys("04/32");
        //Se valida que la fecha de vencimiento sea la esperada.
        Assert.assertEquals("04/32",driver.findElement(vencimientoTarjeta).getAttribute("value"));
        Thread.sleep(1000);
        //Se ingresa "511" en el campo "Codigo de Seguridad"
        driver.findElement(codSeg).sendKeys("511");
        //Se valida que sea el codigo esperado.
        Assert.assertEquals("511",driver.findElement(codSeg).getAttribute("value"));
        Thread.sleep(1000);
        //Se ingresa "45000000" en el campo "DNI"
        driver.findElement(DNI).sendKeys("45000000");
        //Se valida que el numero sea el esperado.
        Assert.assertEquals("45000000",driver.findElement(DNI).getAttribute("value"));
        //Se valida que el mensaje de error sea "Ingresa un numero de tarjeta valido".
        Assert.assertEquals("Ingresa un número de tarjeta válido", driver.findElement(error).getText());
    }
    @Test
    public void atc08() throws InterruptedException {
        driver.get("https://www.viajesfalabella.cl/trips/xs/PC9f96d043c15d4c02bcf7d9380a84d26b27184355?searchParams=SC8yMDIxLTA5LTEwLzIwMjEtMDktMTcvQ0lUXzkwMS8y&searchId=399447e6-c24a-4a3f-bde5-1cb06997bd48&stepNum=0&locale=es-CL&dc=false&tx=true&d=aHR0cHM6Ly93d3cudmlhamVzZmFsYWJlbGxhLmNsL2FjY29tbW9kYXRpb25zL2RldGFpbC8zNjE4MTAvMjAyMS0wOS0xMC8yMDIxLTA5LTE3LzI%2Fc2VsZWN0ZWRfcm9vbV9wYWNrPTE3MzA3OTg4MjImc2VhcmNoSWQ9Mzk5NDQ3ZTYtYzI0YS00YTNmLWJkZTUtMWNiMDY5OTdiZDQ4JnRocm91Z2hSZXN1bHRzPXRydWU%3D&currency=CLP&flow=H&oTid=PCaabc6aa915cd44bbae8df4a92a3c32f327184355");
        // Por problemas efectuados debidos a la Disponibilidad de Alojamientos del Hotel elejido anteriormente, nos vimos obligados a cambiar el mismo para que funcione el test.
        // De todas formas se podria usar como un caso distinto, un caso de error por disponibilidad.
        System.out.println("Se abre URL");
        Thread.sleep(2000);
        //Se clickea en "Siguiente"
        driver.findElement(By.xpath("//*[@id=\"pricebox-overlay\"]/div[1]/div/button/em"))
                .click();
        //Se esperan 7 segundos a que cargue la pagina
        Thread.sleep(7000);
        //Se valida que la url sea la esperada.
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.viajesfalabella.cl/checkout/"));
        Thread.sleep(2000);
        //Se clickea en el campo para buscar banco
        driver.findElement(By.xpath("//body/af-app[1]/div[1]/div[1]/div[1]/checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/payment-component[1]/div[1]/div[1]/payment-method[1]/div[1]/payment-method-selector-container[1]/prepaid-payment-container[1]/div[1]/div[1]/div[2]/card-container[1]/div[1]/div[2]/card-storage[1]/div[1]/card-empty-slot[1]/div[1]/div[1]/div[1]/div[1]"))
                .click();
        Thread.sleep(2000);
        //Se ingresa "San" en el campo de busqueda
        driver.findElement(imputTarjeta).sendKeys("San");
        Thread.sleep(1000);
        //Se apreta ENTER para elegir la primera opcion.
        driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/payment-component/div/div[1]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div/div[2]/card-container/div/div[2]/card-storage/modal-component/div/div[2]/payment-option-selector/div[2]/ul/li[1]/span"))
                .click();
        Thread.sleep(500);
        //Se clickea en "Mastercard
        driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/payment-component/div/div[1]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div/div[2]/card-container/div/div[2]/card-storage/modal-component/div/div[2]/payment-option-selector/div[2]/ul/li[2]/span"))
                .click();
        Thread.sleep(500);
        //Se clickea en 1 pago
        driver.findElement(By.xpath("//*[@id=\"checkout-content\"]/div[1]/payment-component/div/div[1]/payment-method/div/payment-method-selector-container/prepaid-payment-container/div/div/div[2]/card-container/div/div[2]/card-storage/modal-component/div/div[2]/payment-option-selector/div[2]/ul/li[1]"))
                .click();
        Thread.sleep(2000);
        //Se ingresa "Roberto Nuñez" en el campo "NOMBRE/S Y APELLIDO/S"
        driver.findElement(By.xpath("//input-component-v2[1]/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys("Roberto Nuñez");
        //Se valida que el nombre sea el esperado.
        Assert.assertEquals("Roberto Nuñez",driver.findElement(By.xpath("//input-component-v2[1]/div[1]/div[1]/div[1]/input[1]")).getAttribute("value"));
        Thread.sleep(500);
        //Se selecciona la opcion "Pasaporte"
        WebElement pasaportee = driver.findElement(By.xpath("//select-component-v2[1]/div[1]/div[1]/div[1]/div[1]/select[1]"));
        Select pasaporte = new Select(pasaportee);
        pasaporte.selectByVisibleText("Pasaporte");
        Thread.sleep(500);
        //Se ingresa "1234512311" en el campo "PASAPORTE"
        driver.findElement(By.xpath("//input[@id='invoice-fiscal-identification-number-0']"))
                .sendKeys("1234512311");
        //Se valida que el numero sea el esperado.
        Assert.assertEquals("1234512311",driver.findElement(By.xpath("//input[@id='invoice-fiscal-identification-number-0']")).getAttribute("value"));
        Thread.sleep(500);
        //Se selecciona la opcion "Argentina"
        WebElement paiss = driver.findElement(By.xpath("//select[@id='invoice-fiscal-identification-issueCountry-0']"));
        Select pais = new Select(paiss);
        pais.selectByVisibleText("Argentina");
        Thread.sleep(500);
        //Se ingresa "Av Siempreviva 742" en el campo "DIRECCION".
        driver.findElement(direccion)
                .sendKeys("Av Siempreviva 742");
        //Se valida que el texto sea el esperado.
        Assert.assertEquals("Av Siempreviva 742",driver.findElement(direccion).getAttribute("value"));
        Thread.sleep(500);
        //Se ingresa "Roberto" en el campo "NOMBRE"
        driver.findElement(nombre).sendKeys("Roberto");
        //Se valida que el nombre sea el esperado.
        Assert.assertEquals("Roberto",driver.findElement(nombre).getAttribute("value"));
        Thread.sleep(500);
        //Se ingresa "Nuñez" en el campo "APELLIDO"
        driver.findElement(apellido).sendKeys("Nuñez");
        //Se valida que el apellido sea el esperado.
        Assert.assertEquals("Nuñez",driver.findElement(apellido).getAttribute("value"));
    }
    @After
    public void close(){
        System.out.println("After");
        if(driver != null);
            driver.close();
    }
}
