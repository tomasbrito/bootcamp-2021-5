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
    By inputFecha = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/input[1]");
    By fechaIdaSeleccionada = By.xpath("//body/div[5]/div[1]/div[5]/div[1]/div[4]/span[27]");
    By fechaVueltaSeleccionada = By.xpath("//body/div[5]/div[1]/div[5]/div[1]/div[4]/span[30]/span[1]");
    By botonAplicarFecha = By.xpath("//body/div[7]/div[1]/div[6]/div[2]/button[2]/em[1]");
    By botonOpcionesAvanzadas = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[8]/div[1]/span[1]/input[1]");
    By checkboxAlojamientoOtraCiudad = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[10]/div[1]/div[1]/span[1]/label[1]/i[1]");
    By inputAlojamientoOtraCiudad = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[10]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By botonSeleccionarHotel = By.xpath("//body/aloha-app-root[1]/aloha-results[1]/div[1]/div[1]/div[2]/div[2]/div[2]/aloha-list-view-container[1]/div[2]/aloha-cluster-container[1]/div[1]/div[1]/div[2]/aloha-cluster-pricebox-container[1]/div[1]/div[2]/div[2]/aloha-button[1]/button[1]");
    By botonReservarHotel = By.xpath("//body/aloha-app-root[1]/aloha-detail[1]/div[1]/div[3]/div[2]/div[1]/aloha-infobox-container[1]/aloha-infobox-wrapper-container[1]/div[1]/div[1]/div[1]/aloha-infobox-shopping-content[1]/div[1]/div[2]/aloha-next-step-button[1]/aloha-button[1]/button[1]/em[1]");
    By botonSiguienteVuelo = By.xpath("//body[1]/div[14]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[3]/trips-cluster-selected[1]/span[1]/cluster[1]/div[1]/div[1]/div[2]/fare[1]/span[1]/span[1]/div[2]/buy-button[1]/a[1]/div[1]");
    By botonReservarVuelo = By.xpath("//body/div[@id='flights-container-wrapper']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[3]/trips-cluster-selected[1]/span[1]/cluster[1]/div[1]/div[1]/div[2]/fare[1]/span[1]/span[1]/div[2]/buy-button[1]/a[1]/div[1]/em[1]");
    By botonVerViaje = By.xpath("//body/app-root[1]/div[1]/div[1]/app-wizard-ab[1]/wizard[1]/div[1]/div[2]/wizard-step[3]/div[1]/div[1]/div[1]/a[1]/em[1]");
    By botonDosAlojamientos = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/span[2]/input[1]");
    By inputOrigenDosAlojamientos = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By inputDestinoDosAlojamientos = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By inputFechaDosAlojamientos = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/input[1]");
    By fechaIdaDosAlojamientos = By.xpath("//body/div[5]/div[1]/div[5]/div[1]/div[4]/span[25]");
    By fechaVueltaDosAlojamientos = By.xpath("//body/div[5]/div[1]/div[5]/div[1]/div[4]/span[30]");
    By botonAplicarFechaDosAlojamientos = By.xpath("//body/div[7]/div[1]/div[6]/div[2]/button[2]/em[1]");
    By inputFechaPrimerDestino = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[7]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]");
    By fechaElegidaPrimerDestino = By.xpath("//body/div[2]/div[1]/div[5]/div[1]/div[4]/span[27]");
    By botonAplicarFechaPrimerDestino = By.xpath("//body/div[2]/div[1]/div[6]/div[2]/button[2]/em[1]");
    By inputSegundoDestino = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[7]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

    public void irAPaquetes(){
        click(btnAlojamiento);
    }

    public void realizarBusqueda(){
        click(btnBuscar);
    }
    public void ingresarDatosOrigen(String origen) throws InterruptedException {
        tipear(origen, inputOrigen);
        Thread.sleep(1000);
        enter(inputOrigen);
    }
    public void ingresarDatosDestino(String destino) throws InterruptedException {
        tipear(destino, inputDestino);
        Thread.sleep(1000);
        enter(inputDestino);
    }
    public void ingresarFechas(){
        click(inputFecha);
        click(fechaIdaSeleccionada);
        click(fechaVueltaSeleccionada);
        click(botonAplicarFecha);
    }
    public void clickearBotonOpcionesAvanzadas(){
        click(botonOpcionesAvanzadas);
        click(checkboxAlojamientoOtraCiudad);
    }
    public void ingresarAlojamientoEnOtraCiudad(String destino) throws InterruptedException {
        tipear(destino, inputAlojamientoOtraCiudad);
        Thread.sleep(500);
        enter(inputAlojamientoOtraCiudad);
    }
    public void seleccionarHotel() throws InterruptedException {
        Thread.sleep(4000);
        click(botonSeleccionarHotel);
        Thread.sleep(4000);
        cambiarPestaña();
    }
    public void reservarHotel() throws InterruptedException {
        Thread.sleep(2000);
        click(botonReservarHotel);
    }
    public void seleccionarVuelo(){
        click(botonSiguienteVuelo);
    }
    public void reservarVuelo() throws InterruptedException {
        Thread.sleep(1500);
        click(botonReservarVuelo);
    }
    public void clickearBotonVerViaje(){
        click(botonVerViaje);
    }

    public void clickearBotonDosAlojamientos(){
        click(botonDosAlojamientos);
    }
    public void ingresarOrigenDosAlojamientos(String origen) throws InterruptedException {
        tipear(origen, inputOrigenDosAlojamientos);
        Thread.sleep(500);
        enter(inputOrigenDosAlojamientos);

    }
    public void ingresarDestinoDosAlojamientos(String destino) throws InterruptedException {
        tipear(destino, inputDestinoDosAlojamientos);
        Thread.sleep(500);
        enter(inputDestinoDosAlojamientos);
    }
    public void ingresarFechasDosAlojamientos(){
        click(inputFechaDosAlojamientos);
        click(fechaIdaDosAlojamientos);
        click(fechaVueltaDosAlojamientos);
        click(botonAplicarFechaDosAlojamientos);
    }
    public void ingresarFechaPrimerDestino(){
        click(inputFechaPrimerDestino);
        click(fechaElegidaPrimerDestino);
        click(botonAplicarFechaPrimerDestino);

    }
    public void ingresarSegundoDestino(String destino) throws InterruptedException {
        tipear(destino, inputSegundoDestino);
        Thread.sleep(500);
        enter(inputSegundoDestino);
    }

    public String obtenerMensajeFechaEntrada(){
        return encontrarElemento(textoErrorOrigen).getText();
    }
    public String obtenerMensajeFechaSalida(){
        return encontrarElemento(textoErrorRegreso).getText();
    }


}