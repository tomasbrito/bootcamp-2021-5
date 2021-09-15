package pom.grupo3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pom.grupo3.base.SeleniumBase;

public class VFTrasladosPage extends SeleniumBase {

    public VFTrasladosPage(WebDriver driver) {
        super(driver);
    }


    //localizadores
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
    By btnBuscar = By.linkText("Buscar");
    By moneda = By.xpath("(//span[@class='pricebox-currency ng-binding'])[5]");
    By select = By.id("currency-select");


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

    public void seleccionarFechaYBuscar() {
        click(fieldFechaIda);
        exwait(diaIda);
        click(diaIda);
        click(btnBuscar);
    }

    public String obtenerTextoTrasladoVuelta () {
        return obtenerTexto(textoResultado);
    }

    public String obtenerMoneda(){
       return obtenerTexto(moneda);
    }

    public void cambiarMonedaADolares() {
        Select dropDown = new Select(encontrarElemento(select));
        dropDown.selectByValue("string:USD");
    }
}