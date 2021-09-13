package pom.grupo2.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.grupo2.base.SeleniumBase;

import java.util.List;

public class VFHomePage extends SeleniumBase {

    public VFHomePage(WebDriver driver) {
        super(driver);
    }



    By btnAlojamiento = By.xpath("//a[@product=\"HOTELS\"]");
    By btnBuscar = By.linkText("Buscar");
    By formulario = By.className("sbox-dates");
    By tooltip = By.className("validation-msg");

    public void irAlojamiento(){
        click(btnAlojamiento);
        click(btnBuscar);
    }

    public String obtenerMensajeFechaEntrada(){
        List<WebElement> validacion= encontrarElemento(formulario).findElements(tooltip);
        return validacion.get(0).getText();
    }

    public String obtenerMensajeFechaSalida(){
        List<WebElement> validacion=encontrarElemento(formulario).findElements(tooltip);
        return validacion.get(1).getText();
    }

}