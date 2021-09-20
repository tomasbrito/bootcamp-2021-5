package pom.grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pom.grupo4.base.SeleniumBase;

import java.util.List;

public class VFAlojamientosPage extends SeleniumBase {
    By botonFechaIda = By.xpath("//body[1]/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By campoFechaIdaTC009 = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[30]/span[1]");
    By campoFechaVueltaTC009 = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[26]/span[1]");
    By campoFechaIdaTC012 = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[27]/span[1]");
    By campoFechaVueltaTC012 = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[30]/span[1]");
    By inputDestino = By.xpath("//*[contains(@class, 'input-tag sbox-main-focus sbox-destination sbox-primary')]");
    By botonHabitaciones = By.xpath("//body[1]/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]");
    By botonAñadirHabitacion = By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/a[2]");
    By botonAplicar = By.xpath("//body/div[2]/div[1]/div[2]/a[1]");
    By botonBuscar = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/a[1]");
    By botonAlquileresVacacionales = By.xpath("//body/aloha-app-root[1]/aloha-results[1]/div[1]/div[1]/div[1]/div[2]/div[2]/aloha-list-view-container[1]/aloha-results-toolbar[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/ul[1]/aloha-tooltip-coachmark[1]/div[1]/li[1]");
    By textoResultado = By.xpath(("//span[contains(text(),'Alquiler vacacional')]"));
    By botonVerDetallePrimerHotel = By.xpath("//body/aloha-app-root[1]/aloha-results[1]/div[1]/div[1]/div[1]/div[2]/div[2]/aloha-list-view-container[1]/div[2]/div[1]/aloha-cluster-container[1]/div[1]/div[1]/div[2]/aloha-cluster-pricebox-container[1]/div[1]/div[2]/div[2]/aloha-button[1]/button[1]");
    By botonModificarFecha = By.xpath("//em[contains(text(),'Modificar')]");
    By fechaIdaModificada = By.xpath("//body/div[@id='component-modals']/div[1]/div[1]/div[2]/div[1]/div[3]/div[25]/div[1]");
    By fechaVueltaModificada = By.xpath("//body/div[@id='component-modals']/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]");
    By botonAplicarFechaModificada = By.xpath("//body/div[@id='component-modals']/div[1]/div[2]/div[1]/button[1]");
    By botonBuscarFechaModificada = By.xpath("//em[contains(text(),'Buscar')]");
    By inputModificarFecha = By.xpath("//body/aloha-app-root[1]/aloha-detail[1]/div[1]/aloha-re-search-container[1]/aloha-re-search[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
    By verDetalleHotelFechaModificada = By.xpath("//body/aloha-app-root[1]/aloha-results[1]/div[1]/div[1]/div[1]/div[2]/div[2]/aloha-list-view-container[1]/div[2]/div[1]/aloha-cluster-container[1]/div[2]/div[1]/div[2]/aloha-cluster-pricebox-container[1]/div[1]/div[2]/div[2]/aloha-button[1]/button[1]");
    By botonVerHabitaciones = By.xpath("//em[contains(text(),'Ver habitaciones')]");
    By botonReservarAhora = By.xpath("//em[contains(text(),'Reservar ahora')]");
    By botonSiguiente = By.xpath("//em[contains(text(),'Siguiente')]");
    By botonAñadirAdulto = By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/a[2]");
    By botonAñadirMenor = By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/a[2]");
    By selectMenor = By.xpath("//body/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/select[1]");
    By selectOrdenarHabitaciones = By.xpath("//select[@id='jr-eva-select']");
    public VFAlojamientosPage(WebDriver driver) {
        super(driver);
    }

    public void clickearInputFecha() throws InterruptedException {
        Thread.sleep(500);
        click(botonFechaIda);
    }
    public void clickearFechaIdaTC009() throws InterruptedException {
        Thread.sleep(500);
        click(campoFechaIdaTC009);
    }
    public void clickearFechaVueltaTC009() throws InterruptedException {
        Thread.sleep(500);
        click(campoFechaVueltaTC009);
    }
    public void clickearFechaIdaTC012(){
        click(campoFechaIdaTC012);
    }
    public void clickearFechaVueltaTC012() throws InterruptedException {
        Thread.sleep(500);
        click(campoFechaVueltaTC012);
    }



    public String getFechaVueltaValue(){
        return encontrarElemento(campoFechaVueltaTC009).getText();
    }

    public void ingresarDatosDestino() throws InterruptedException {
        tipear("Santiago", inputDestino);
        Thread.sleep(1000);
        enter(inputDestino);
    }
    public void clickearBotonHabitaciones(){
        click(botonHabitaciones);
    }
    public void clickearAñadirHabitacion(){
        click(botonAñadirHabitacion);
    }
    public void clickearBotonAplicar(){
        click(botonAplicar);
    }
    public void clickearBotonBuscar(){
        click(botonBuscar);
    }
    public void clickearBotonAlquileresVacacionales() throws InterruptedException {
        Thread.sleep(4500);
        click(botonAlquileresVacacionales);
    }
    public List<WebElement> getListaResultados(){
        WebElement weBotonAlquileresVacacionales = encontrarElemento(botonAlquileresVacacionales);
        List<WebElement> alquileresVacacionales = encontrarElementos(textoResultado);
        return alquileresVacacionales;
    }
    public void clickearBotonVerDetallePrimerHotel() throws InterruptedException {
        click(botonVerDetallePrimerHotel);
        Thread.sleep(1000);
        cambiarPestaña();
    }
    public void modificarFecha() throws InterruptedException {
        click(botonModificarFecha);
        click(inputModificarFecha);
        Thread.sleep(500);
        click(fechaIdaModificada);
        Thread.sleep(500);
        click(fechaVueltaModificada);
        Thread.sleep(500);
        click(botonAplicarFechaModificada);
        click(botonBuscarFechaModificada);
    }
    public void clickearBotonVerDetalleHotelFechaModificada() throws InterruptedException {
        click(verDetalleHotelFechaModificada);
        Thread.sleep(1000);
        cambiarPestaña();
    }
    public void clickearBotonVerHabitaciones(){
        click(botonVerHabitaciones);
    }
    public void clickearBotonReservarAhora(){
        click(botonReservarAhora);
    }
    public void clickearBotonSiguiente(){
        click(botonSiguiente);
    }

    public void clickearBotonAñadirAdulto(){
        click(botonAñadirAdulto);
    }
    public void clickearBotonAñadirMenor(){
        WebElement select = encontrarElemento(selectMenor);
        Select s = new Select(select);
        click(botonAñadirMenor);
        s.selectByValue("9");
    }
    public void ordenarReseñasHabitaciones(){
        WebElement select = encontrarElemento(selectOrdenarHabitaciones);
        Select s = new Select(select);
        s.selectByValue("overall_rating_desc");

    }




}
