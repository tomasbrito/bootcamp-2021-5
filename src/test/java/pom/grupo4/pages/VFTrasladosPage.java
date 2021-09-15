package pom.grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.grupo4.base.SeleniumBase;

public class VFTrasladosPage extends SeleniumBase {
    WebDriverWait exwait;
    By botonPasajeros = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]");
    By botonAñadirMenor = By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[2]");
    By botonAplicarPasajeros = By.xpath("//a[contains(text(),'Aplicar')]");
    By mensajeError = By.xpath("//p[contains(text(),'Ingresa la edad del menor')]");
    By inputDesde = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By inputHasta = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By inputFecha = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By inputHora = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]");
    By fechaElegida = By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[4]/span[27]/span[1]");
    By botonAñadirPasajero = By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[2]");
    By botonBuscar = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/a[1]");
    By botonAplicarFecha = By.xpath("//body/div[3]/div[1]/div[6]/div[2]/button[2]");

    public VFTrasladosPage(WebDriver driver) {
        super(driver);
    }

    public void clickearBotonPasajeros() {
        click(botonPasajeros);
    }
    public void clickearAñadirMenor(){
        click(botonAñadirMenor);
    }
    public void clickearBotonAplicarPasajeros(){
        click(botonAplicarPasajeros);
    }
    public String getMensajeError(){
        return encontrarElemento(mensajeError).getText();
    }
    public void ingresarDatosInputDesde() throws InterruptedException {
        tipear("Santiago", inputDesde);
        Thread.sleep(1000);
        enter(inputDesde);
    }
    public void ingresarDatosInputHasta() throws InterruptedException {
        tipear("Hotel Mercure", inputHasta);
        Thread.sleep(1000);
        enter(inputHasta);
    }
    public void ingresarFecha() {
        click(inputFecha);
        click(fechaElegida);
        click(botonAplicarFecha);
    }
    public void ingresarHora(){
        WebElement selectHora = encontrarElemento(inputHora);
        Select s = new Select(selectHora);
        click(inputHora);
        s.selectByValue("960");
    }
    public void clickearAñadirPasajeroMayor(){
        click(botonAñadirPasajero);
    }
    public void clickearBotonBuscar(){
        click(botonBuscar);

    }
}
