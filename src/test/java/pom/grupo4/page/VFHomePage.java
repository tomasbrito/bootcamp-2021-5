package pom.grupo4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.earaya.base.SeleniumBase;

import java.util.List;

public class VFHomePage extends SeleniumBase {

    public VFHomePage(WebDriver driver) {
        super(driver);
    }

    //localizadores
    By btnAtraslados = By.xpath("//*[contains(@class, 'TRANSFERS')]");
    By btnBuscar = By.linkText("Buscar");
    By formulario = By.className("sbox-dates");
    By tooltip = By.className("validation-msg");

    //Keyword Driven
    public void irATraslados(){
        click(btnAtraslados);

    }


    public String obtenerMensajeFechaEntrada(){
        List<WebElement> validacion = encontrarElemento(formulario).findElements(tooltip);
        return validacion.get(0).getText();

    }
    public String obtenerMensajeFechaSalida(){
        List<WebElement> validacion = encontrarElemento(formulario).findElements(tooltip);
        return validacion.get(1).getText();
    }


}
