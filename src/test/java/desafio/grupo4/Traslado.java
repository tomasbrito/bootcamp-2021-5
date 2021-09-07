package desafio.grupo4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Traslado {
    static final String url = "https://www.viajesfalabella.cl/";
    WebDriver driver;
    @BeforeClass
    public static void init(){
        WebDriverManager.edgedriver().setup();

    }

    @Before
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @After
    public void close(){
        System.out.println("After");
        if(driver !=null){
            //driver.close();
        }
    }

    @Test //TODO TC-005
    public void realizarBusquedaSinIngresarEdad(){
        //atributos
        WebDriverWait exwait = new WebDriverWait(driver, 10);

        //localizadores
        By btnTraslados = By.xpath("//*[contains(@class, 'TRANSFERS')]");
        By inputPasajeros = By.xpath("//body[1]/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]");
        By btnAgregarMenor = By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[2]");
        By contadorMenores = By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]");
        By btnAplicar = By.xpath("//body/div[1]/div[1]/div[2]/a[1]");
        By mensajeError = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/p[1]");
        //navego al home
        driver.get(url);

        //navego hasta la página de traslados
        driver.findElement(btnTraslados).click();

        //Valido que esté en la URL correcta
        exwait.until(ExpectedConditions.urlContains("/traslados"));
        Assert.assertEquals("https://www.viajesfalabella.cl/traslados/", driver.getCurrentUrl());

        //clickeo el botón de pasajeros
        driver.findElement(inputPasajeros).click();

        //Espero a que el botón de agregar pasajeros pueda ser clickeado, y cuando se pueda se clickea.
        exwait.until(ExpectedConditions.elementToBeClickable(btnAgregarMenor)).click();

        //Valido que se haya agregado un menor
        //Assert.assertEquals("1", driver.findElement(contadorMenores).getText());

        //Espero a que el botón de Aplicar pueda ser clickeado, y cuando se pueda se clickea.
        exwait.until(ExpectedConditions.elementToBeClickable(btnAplicar)).click();

        //Valido que salga el mensaje de error 'Ingresa la edad del menor'
        Assert.assertEquals("Ingresa la edad del menor", driver.findElement(mensajeError).getText());

    }

    @Test //TODO TC-007
    public void buscarTrasladoHaciaElAeropuerto() throws InterruptedException {
        //atributos
        WebDriverWait exwait = new WebDriverWait(driver, 10);



        //localizadores
        By btnTraslados = By.xpath("//*[contains(@class, 'TRANSFERS')]");
        By inputHasta = By.xpath("//*[contains(@class, 'input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline')]");
        By inputDesde = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
        By opcionAElegirHasta = By.xpath("//span[contains(text(),\"Hotel Mercure Santiago Centro - Bernardo O'Higgins\")]");
        By opcionAElegirDesde = By.xpath("//span[contains(text(),'Aeropuerto Arturo Merino Benitez, Santiago de Chil')]");
        By inputFecha = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/i[1]");
        By inputHora = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]");
        By inputPasajeros = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]");
        By fechaElegida = By.xpath("//body[1]/div[2]/div[1]/div[5]/div[1]/div[4]/span[27]/span[1]");
        By botonAplicarFecha = By.xpath("//body/div[2]/div[1]/div[6]/div[2]/button[2]");
        By botonAñadirPasajero = By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[2]");
        By botonAplicarPasajeros = By.xpath("//a[contains(text(),'Aplicar')]");
        By botonAplicar = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/a[1]");
        String URLObjetivo = "https://www.viajesfalabella.cl/transfer/shopping/#!/search/oneway/geo_place/ChIJRVH0jU7WYpYRIcPQyFFUXC4/airport/SCL/27-09-2021/16:00/2";
        By textoObjetivo = By.xpath("//body/div[6]/div[1]/div[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/search-item[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/span[1]");

        //navego al home
        driver.get(url);

        //navego hasta la página de traslados
        driver.findElement(btnTraslados).click();

        //Valido que esté en la URL correcta
        exwait.until(ExpectedConditions.urlContains("/traslados"));
        Assert.assertEquals("https://www.viajesfalabella.cl/traslados/", driver.getCurrentUrl());


        //Localizadores de la página
        WebElement checkboxHaciaElAeropuerto = driver.findElement(By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/span[2]/label[1]"));
        WebElement selectHora = driver.findElement(inputHora);
        WebElement elementoInputFecha = driver.findElement(inputFecha);
        Select s = new Select(selectHora);

        //Clickeo el checkbox de 'Hacia el aeropuerto'
        checkboxHaciaElAeropuerto.click();

        //Ingreso 'Hotel Mercure santiago' en el campo de hasta
        driver.findElement(inputDesde).sendKeys("Hotel Mercure santiago");
        exwait.until(ExpectedConditions.elementToBeClickable(opcionAElegirHasta)).click();

        //Ingreso 'Santiago' en el campo de destino de desde
        driver.findElement(inputHasta).sendKeys("Santiago");
        Thread.sleep(500);
        driver.findElement(inputHasta).sendKeys(Keys.ENTER);

        //Ingreso 27/09 y 16:00 en el campo de fecha
        Thread.sleep(1500);
        elementoInputFecha.click();
        exwait.until(ExpectedConditions.elementToBeClickable(fechaElegida)).click();
        exwait.until(ExpectedConditions.elementToBeClickable(botonAplicarFecha)).click();
        driver.findElement(inputHora).click();
        s.selectByValue("960");

        //Clickeo el botón de pasajeros y añado uno
        exwait.until(ExpectedConditions.elementToBeClickable(inputPasajeros)).click();
        exwait.until(ExpectedConditions.elementToBeClickable(botonAñadirPasajero)).click();
        exwait.until(ExpectedConditions.elementToBeClickable(botonAplicarPasajeros)).click();

        //Termino el flujo apretando el boton de aplicar, mandando la request al servidor
        exwait.until(ExpectedConditions.elementToBeClickable(botonAplicar)).click();

        //Verifico estar en la URL correcta
        exwait.until(ExpectedConditions.urlContains(URLObjetivo));
        Assert.assertEquals(URLObjetivo, driver.getCurrentUrl());

        //Verifico que haya al menos un resultado
        Assert.assertEquals("Precio final por vehículo, solo ida", driver.findElement(textoObjetivo).getText());
















    }

}
