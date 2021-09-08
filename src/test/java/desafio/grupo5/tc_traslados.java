package desafio.grupo5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tc_traslados {
    WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();

    }
    @Test
    public void busquedaCampoIncompleto() throws InterruptedException {
        //Declaramos el wait y los localizadores a esperar
        WebDriverWait wait = new WebDriverWait(driver,10);
        By localizadorLugar = By.xpath("//span[contains(text(),'Sheraton Pilar Hotel & Convention Center, Pilar, P')]");
        By localizadorBtnAplicar = By.xpath("//body[1]/div[3]/div[1]/div[6]/div[2]/button[2]/em[1]");
        By localizadorAlerta = By.xpath("//span[contains(text(),'Ingresa un origen.')]");

        //1. Ingresamos a la URL de traslados
        driver.get("https://www.viajesfalabella.cl/traslados/");
        //2. Validamos la URL
        Assert.assertEquals("https://www.viajesfalabella.cl/traslados", driver.getCurrentUrl());

        //3. Identificamos los elementos
        WebElement fieldTo = driver.findElement(By.xpath("//*[contains(@class, 'sbox-places-second')]"));
        WebElement fieldDate = driver.findElement(By.xpath("//*[contains(@class, 'input-tag sbox-checkin')]"));
        WebElement fechaElegida = driver.findElement(By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[4]/span[21]/span[1]"));
        WebElement btnBuscar = driver.findElement(By.xpath("//em[contains(text(),'Buscar')]"));
        //4. Ingresamos texto en el campo "Hasta"
        fieldTo.sendKeys("Sheraton Pilar");
        //5. Esperamos hasta que aparezca el resultado esperado
        wait.until(ExpectedConditions.elementToBeClickable(localizadorLugar)).click();
        Assert.assertEquals("Sheraton Pilar Hotel & Convention Center, Pilar, Provincia de Buenos Aires, Argentina",fieldTo.getAttribute("value"));
        //6. Clickeamos en el campo "Fecha", seleccionamos la fecha y damos a aplicar
        fieldDate.click();
        fechaElegida.click();
        wait.until(ExpectedConditions.elementToBeClickable(localizadorBtnAplicar)).click();
        Assert.assertEquals("Mar, 21 sep 2021",fieldDate.getAttribute("value"));
        btnBuscar.click();
        Assert.assertEquals("Ingresa un origen.", driver.findElement(localizadorAlerta).getText());
    }

    @Test
    public void busquedaSimple(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By localizadorFrom = By.xpath("//span[contains(text(),'Aeropuerto Southern')]");
        By localizadorTo = By.xpath("//span[contains(text(),'Cecil Hotel, South Main Street, Los Ángeles, Calif')]");
        By localizadorBtnAplicar = By.xpath("//body[1]/div[3]/div[1]/div[6]/div[2]/button[2]/em[1]");
        By btnSumarAdultos = By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[2]");
        //1. Ingresamos al home
        driver.get("https://www.viajesfalabella.cl/traslados");
        //2. Validamos la URL
        Assert.assertEquals("https://www.viajesfalabella.cl/traslados", driver.getCurrentUrl());


        // Entramos a la sección traslados
        // Identificamos los elementos Web
        WebElement fieldFrom = driver.findElement(By.xpath("//*[contains(@class, 'sbox-places-first places-inline')]"));
        WebElement fieldTo = driver.findElement(By.xpath("//*[contains(@class, 'sbox-places-second')]"));
        WebElement fieldDate = driver.findElement(By.xpath("//*[contains(@class, 'input-tag sbox-checkin')]"));
        WebElement fechaElegida = driver.findElement(By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[4]/span[20]/span[1]"));
        WebElement btnPasajeros = driver.findElement(By.xpath("//app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]"));
        WebElement btnAplicarPasajeros = driver.findElement(By.xpath("//a[contains(text(),'Aplicar')]"));
        WebElement btnBuscar = driver.findElement(By.xpath("//em[contains(text(),'Buscar')]"));

        //Clickeamos en el campo desde y validamos
        fieldFrom.click();
        fieldFrom.sendKeys("Cali");
        wait.until(ExpectedConditions.elementToBeClickable(localizadorFrom)).click();
        Assert.assertEquals("Aeropuerto Southern California Logistics, Victorville, Estados Unidos",fieldFrom.getAttribute("value"));

        // Clickeamos en el campo hasta y validamos
        fieldTo.click();
        fieldTo.sendKeys("Cecil");
        wait.until(ExpectedConditions.elementToBeClickable(localizadorTo)).click();
        Assert.assertEquals("Cecil Hotel, South Main Street, Los Ángeles, California, EE. UU.", fieldTo.getAttribute("value"));

        // Clickeamos en el campo fecha y validamos
        fieldDate.click();
        fechaElegida.click();
        wait.until(ExpectedConditions.elementToBeClickable(localizadorBtnAplicar)).click();
        Assert.assertEquals("Lun, 20 sep 2021",fieldDate.getAttribute("value"));

        btnPasajeros.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnSumarAdultos)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnSumarAdultos)).click();
        btnAplicarPasajeros.click();
        WebElement campoPasajerosAssert = driver.findElement(By.xpath("//app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        Assert.assertEquals("3",campoPasajerosAssert.getAttribute("value"));
        btnBuscar.click();
        if(driver.getCurrentUrl().contains("search")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @Test
    public void busquedaCambioTarjeta(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By localizadorFrom = By.xpath("//span[contains(text(),'Aeropuerto La Guardia, Nueva York,')]");
        By localizadorTo = By.xpath("//span[contains(text(),'Seaport Hotel Boston, Seaport Lane, Boston, Massac')]");
        By localizadorFecha = By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[4]/span[8]/span[1]");
        By localizadorBtnAplicar = By.xpath("//body[1]/div[3]/div[1]/div[6]/div[2]/button[2]/em[1]");
        //1. Ingresamos al home
        driver.get("https://www.viajesfalabella.cl/traslados");
        //2. Validamos la URL
        Assert.assertEquals("https://www.viajesfalabella.cl/traslados", driver.getCurrentUrl());

        // Identificamos los elementos
        WebElement fieldFrom = driver.findElement(By.xpath("//*[contains(@class, 'sbox-places-first places-inline')]"));
        WebElement fieldTo = driver.findElement(By.xpath("//*[contains(@class, 'sbox-places-second')]"));
        WebElement fieldDate = driver.findElement(By.xpath("//*[contains(@class, 'input-tag sbox-checkin')]"));
        WebElement btnBuscar = driver.findElement(By.xpath("//em[contains(text(),'Buscar')]"));


        //Clickeamos en el campo desde
        fieldFrom.click();
        fieldFrom.sendKeys("New");
        wait.until(ExpectedConditions.elementToBeClickable(localizadorFrom)).click();
        Assert.assertEquals("Aeropuerto La Guardia, Nueva York, Estados Unidos",fieldFrom.getAttribute("value"));

        fieldTo.click();
        fieldTo.sendKeys("Sea");
        wait.until(ExpectedConditions.elementToBeClickable(localizadorTo)).click();
        Assert.assertEquals("Seaport Hotel Boston, Seaport Lane, Boston, Massachusetts, EE. UU.",fieldTo.getAttribute("value"));

        fieldDate.click();
        wait.until(ExpectedConditions.elementToBeClickable(localizadorFecha)).click();
        wait.until(ExpectedConditions.elementToBeClickable(localizadorBtnAplicar)).click();
        Assert.assertEquals("Mié, 8 sep 2021",fieldDate.getAttribute("value"));
        btnBuscar.click();

        wait.until(ExpectedConditions.urlContains("ChIJCwWGU3hw44kRHxmdbY32A7E/08-09-2021/00:00/1"));
        By localizadorBtnComprar = By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[2]/main/div[3]/div/div[2]/div[4]/search-item/div[2]/div[2]/div[2]/div/div[1]/div[2]/button");
        if(driver.getCurrentUrl().contains("search")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
        wait.until(ExpectedConditions.elementToBeClickable(localizadorBtnComprar)).click();



        wait.until(ExpectedConditions.urlContains("checkout"));
        By localizadorBtnTarjeta = By.xpath("//card-container[1]/div[1]/div[2]/card-storage[1]/div[1]/card-empty-slot[1]/div[1]/div[1]");
        if(driver.getCurrentUrl().contains("checkout")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
        wait.until(ExpectedConditions.elementToBeClickable(localizadorBtnTarjeta)).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[2]/div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[3]/div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[2]/h5[1]"))).click();
        if(driver.findElement(By.xpath("//h6[contains(text(),'Visa Banco Santander')]")).getText().contains("Santander")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[contains(text(),'Cambiar')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[1]/div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[2]/div[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[2]/h5[1]"))).click();
        if(driver.findElement(By.xpath("//h6[contains(text(),'Visa Banco Falabella')]")).getText().contains("Falabella")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @Test
    public void busquedaDatosIncompletos(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By localizadorFrom = By.xpath("//body/div[7]/div[1]/div[1]/ul[1]/li[1]/span[1]");
        By localizadorTo = By.xpath("//span[contains(text(),'Sanibel Beach, Sanibel, Florida')]");
        By localizadorFecha = By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[4]/span[11]/span[1]");
        By localizadorBtnAplicar = By.xpath("//body[1]/div[3]/div[1]/div[6]/div[2]/button[2]/em[1]");
        //1. Ingresamos al home
        driver.get("https://www.viajesfalabella.cl/traslados");
        //2. Validamos la URL
        Assert.assertEquals("https://www.viajesfalabella.cl/traslados", driver.getCurrentUrl());

        // Identificamos los elementos
        WebElement fieldFrom = driver.findElement(By.xpath("//*[contains(@class, 'sbox-places-first places-inline')]"));
        WebElement fieldTo = driver.findElement(By.xpath("//*[contains(@class, 'sbox-places-second')]"));
        WebElement fieldDate = driver.findElement(By.xpath("//*[contains(@class, 'input-tag sbox-checkin')]"));
        WebElement btnBuscar = driver.findElement(By.xpath("//em[contains(text(),'Buscar')]"));
        //Clickeamos en el campo desde
        fieldFrom.click();
        fieldFrom.sendKeys("Mia");
        wait.until(ExpectedConditions.elementToBeClickable(localizadorFrom)).click();
        Assert.assertEquals("Aeropuerto Internacional Miami, Miami, Estados Unidos",fieldFrom.getAttribute("value"));

        fieldTo.click();
        fieldTo.sendKeys("San");
        wait.until(ExpectedConditions.elementToBeClickable(localizadorTo)).click();
        Assert.assertEquals("Sanibel Beach, Sanibel, Florida, EE. UU.",fieldTo.getAttribute("value"));

        fieldDate.click();
        wait.until(ExpectedConditions.elementToBeClickable(localizadorFecha)).click();
        wait.until(ExpectedConditions.elementToBeClickable(localizadorBtnAplicar)).click();
        Assert.assertEquals("Sáb, 11 sep 2021",fieldDate.getAttribute("value"));
        btnBuscar.click();

        wait.until(ExpectedConditions.urlContains("search"));
        if(driver.getCurrentUrl().contains("search")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
        Select moneda = new Select(driver.findElement(By.id("currency-select")));
        moneda.selectByVisibleText("Dólares");
        By btnComprar =By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[2]/main/div[3]/div/div[2]/div[5]/search-item/div[2]/div[2]/div[2]/div/div[1]/div[2]/button");
        wait.until(ExpectedConditions.elementToBeClickable(btnComprar)).click();

        wait.until(ExpectedConditions.urlContains("checkout"));
        By fieldName = By.xpath("//input-component-v2[1]/div[1]/div[1]/div[1]/input[1]");
        wait.until(ExpectedConditions.elementToBeClickable(fieldName)).click();
        driver.findElement(fieldName).sendKeys("Santiago");
        Assert.assertEquals("Santiago",driver.findElement(fieldName).getAttribute("value"));

        By fieldLastName = By.xpath("//checkout-form[1]/div[1]/form-component[1]/form[1]/div[1]/travelers[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/traveler[1]/div[1]/div[2]/div[1]/div[1]/traveler-last-name-input[1]/div[1]/div[1]/input-component-v2[1]/div[1]/div[1]/div[1]/input[1]");
        driver.findElement(fieldLastName).click();
        driver.findElement(fieldLastName).sendKeys("Espinoza");
        Assert.assertEquals("Espinoza",driver.findElement(fieldLastName).getAttribute("value"));

        WebElement checkTerms = driver.findElement(By.xpath("//terms-checkbox-component[1]/checkbox-component[1]/span[1]/label[1]/i[1]"));
        checkTerms.click();

        if(driver.findElement(By.xpath("//input[@id='terms-checkbox']")).getAttribute("class").contains("ng-valid")){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            //driver.close();
        }
    }
}
