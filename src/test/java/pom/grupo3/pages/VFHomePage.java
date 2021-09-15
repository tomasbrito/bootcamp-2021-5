package pom.grupo3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.grupo3.base.SeleniumBase;

import java.util.List;

public class VFHomePage extends SeleniumBase {

    public VFHomePage(WebDriver driver) {
        super(driver);
    }

    //localizadores
    By btnAlojamiento = By.xpath("//a[@product=\"HOTELS\"]");
    By btnPaquetes = By.xpath("//a[@product=\"PACKAGES\"]");
    By btnBuscar = By.linkText("Buscar");
    By formulario = By.className("sbox-dates");
    By tooltip = By.className("validation-msg");

    By btnTraslados = By.xpath("//a[@product=\"TRANSFERS\"]");



    //Keyword Driven
    public void irAAlojamiento(){
        click(btnAlojamiento);
        click(btnBuscar);
    }


    public String obtenerMensajeFechaEntrada(){
        List<WebElement> validacion = encontrarElemento(formulario).findElements(tooltip);
        return validacion.get(0).getText();

    }
    public String obtenerMensajeFechaSalida(){
        List<WebElement> validacion = encontrarElemento(formulario).findElements(tooltip);
        return validacion.get(1).getText();
    }
    public void irATraslado() {
        click(btnTraslados);
    }

    public void irAPaquetes() {
    }
}
