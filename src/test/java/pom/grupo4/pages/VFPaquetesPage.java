package pom.grupo4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.grupo4.base.SeleniumBase;

import java.util.List;

public class VFPaquetesPage extends SeleniumBase {
    WebDriverWait exwait;

    public VFPaquetesPage(WebDriver driver) {
        super(driver);
        exwait = new WebDriverWait(driver, 10);
    }

    //localizadores
    By btnAlojamiento = By.xpath("//a[@product=\"PACKAGES\"]");
    By btnBuscar = By.linkText("Buscar");
    By inputOrigen = By.xpath("//input[contains(@class,'sbox-places-first sbox-origin-container')]");
    By inputDestino = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By textoErrorOrigen = By.xpath("//span[contains(text(),'Ingresa una fecha de partida.')]");
    By textoErrorRegreso = By.xpath("//span[contains(text(),'Ingresa una fecha de regreso.')]");

    //Keyword Driven


    public void irAPaquetes(){
        click(btnAlojamiento);
    }

    public void realizarBusqueda(){
        click(btnBuscar);
    }
    public void ingresarDatosOrigen() throws InterruptedException {
        tipear("Santiago", inputOrigen);
        Thread.sleep(1000);
        enter(inputOrigen);
    }
    public void ingresarDatosDestino() throws InterruptedException {
        tipear("Viña del mar", inputDestino);
        Thread.sleep(1000);
        enter(inputDestino);
    }

    public String obtenerMensajeFechaEntrada(){
        return encontrarElemento(textoErrorOrigen).getText();
    }
    public String obtenerMensajeFechaSalida(){
        return encontrarElemento(textoErrorRegreso).getText();
    }


}