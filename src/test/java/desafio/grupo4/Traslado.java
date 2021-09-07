package desafio.grupo4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @Test
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
}
