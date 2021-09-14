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
    By btnBuscar = By.linkText("Buscar");
    By formulario = By.className("sbox-dates");
    By tooltip = By.className("validation-msg");

    By btnTraslados = By.xpath("//a[@product=\"TRANSFERS\"]");
    By desdePopUp = By.xpath("//span[@class='ac-group-title eva-3-overline-2']");
    By hastaPopUp = By.xpath("//div[@class='ac-wrapper -desktop -facet -show']//div[@class='ac-container']");
    By fieldDesde = By.xpath("//input[@placeholder='Ingresa un aeropuerto']");
    By fieldHasta = By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']");
    By checkbox = By.xpath("//label[contains(text(),'Quiero agregar el regreso')]");
    By fieldFechaIda = By.xpath("//input[@class='input-tag sbox-checkin']");
    // CORREGIR LOS XPATH DE LOS DIAS, EN LOS PRIMEROS TEST FUNCIONABAN AHORA NO.
    By diaIda = By.xpath("html[1]/body[1]/div[3]/div[1]/div[5]/div[1]/div[4]/span[26]/span[1]");
    By diaVuelta = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[5]/div[1]/div[4]/span[27]/span[1]");
    By textoResultado = By.xpath("(//span[text()='Salida desde el punto que elegiste:'])[5]");


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

    public void llenarFieldDesde(String texto) {
        tipear(texto, fieldDesde);
        exwait(desdePopUp);
        enter(fieldDesde);
    }

    public void llenarFieldHasta(String texto) {
        tipear(texto, fieldHasta);
        exwait(hastaPopUp);
        enter(fieldHasta);
    }

    public void clickCheckbox() {
        click(checkbox);
    }

    public void seleccionarFechasYBuscar() {
        click(fieldFechaIda);
        exwait(diaIda);
        click(diaIda);
        exwait(diaVuelta);
        click(diaVuelta);
        click(btnBuscar);
    }

    public void validar (String resultado) {
        Assert.assertEquals(resultado,obtenerTexto(textoResultado));
    }


}
