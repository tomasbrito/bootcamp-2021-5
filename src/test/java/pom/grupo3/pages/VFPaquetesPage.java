package pom.grupo3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pom.grupo3.base.SeleniumBase;

public class VFPaquetesPage extends SeleniumBase {

    public VFPaquetesPage(WebDriver driver) {
        super(driver);
    }


    //localizadores
    By fieldDesde = By.xpath("(//input[contains(@class,'input-tag sbox-main-focus')])[1]");
    By fieldHasta = By.xpath("(//input[contains(@class,'input-tag sbox-main-focus')])[2]");
    By firstOptionBy = By.xpath("//li[@class=\"item -active\"]");
    By popUpFecha = By.xpath("(//div[@class='_dpmg2--controlsWrapper'])[3]");
    By fieldFechaIda = By.xpath("//div[@class='input-container sbox-checkin-input-container']//input[@type='text']");
    // CORREGIR LOS XPATH
    By diaIda = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[5]/div[1]/div[4]/span[29]/span[1]");
    By diaVuelta =  By.xpath("/html[1]/body[1]/div[5]/div[1]/div[5]/div[1]/div[4]/span[30]/span[1]");

    By btnBuscar = By.xpath("(//a[contains(@class,'sbox-3-btn -primary')])[3]");
    By hotel = By.xpath("(//div[@class='cluster-description cluster-description-top'])[1]");
    By seleccionarHotel = By.xpath("(//button[contains(@class,'eva-3-btn -md')])[2]");
    By verServicios = By.xpath("//div[contains(text(),'Ver todos los servicios')]");
    By ofrece = By.xpath("//h4[contains(text(),'El alojamiento ofrece')]");
    By aceptarHabitacion = By.xpath("//div[@class='pricebox-action -eva-3-mt-lg pricebox-button']//aloha-next-step-button//aloha-button//button[@class='eva-3-btn -md -primary -eva-3-fwidth']");
    By vuelo = By.xpath("//a[@class='-md eva-3-btn -primary']//div");
    By botonFinal = By.xpath("//button[@class='eva-3-btn -lg pricebox-sticky-button -secondary']");
    By detallePago = By.xpath("//ul[@class='detail-price']");
    By rutaDetalleBy = By.xpath("//div[contains(text(),'Buenos Aires - Mendoza')]");
    By nochesDetalleBy = By.xpath("(//div[contains(@class,'dm-d-text eva-3-p')]//span)[2]");

    public void llenarFieldDesde(String texto) {
        exwait(fieldDesde);
        tipear(texto, fieldDesde);
        exwait(firstOptionBy);
        enter(fieldDesde);
    }

    public void llenarFieldHasta(String texto) {
        tipear(texto, fieldHasta);
        exwait(firstOptionBy);
        enter(fieldHasta);
    }

    public void seleccionarFechasYBuscar() {
        click(fieldFechaIda);
        exwait(diaIda);
        click(diaIda);
        exwait(diaVuelta);
        click(diaVuelta);
        click(btnBuscar);
    }

    public void elegirHotelYMostrarDetalle(){
        exwait(hotel);
        click(seleccionarHotel);
        cambiarANuevaPestaña();
        exwait(verServicios);
        click(verServicios);
    }

    public void elegirHotel(){
        exwait(hotel);
        click(seleccionarHotel);
        cambiarANuevaPestaña();
    }

    public String obtenerTextoVentanaDetalle() {
        return obtenerTexto(ofrece);
    }

    public void aceptarHabitacionYVuelo() {
        exwait(aceptarHabitacion);
        click(aceptarHabitacion);
        exwait(vuelo);
        click(vuelo);
        exwait(botonFinal);
        click(botonFinal);
        System.out.println("");

    }

    public boolean comparar(String origen, String destino, String noches) {
        exwait(detallePago);
        WebElement rutaDetalle = encontrarElemento(rutaDetalleBy);
        WebElement nochesDetalle = encontrarElemento(nochesDetalleBy);
        return rutaDetalle.getText().contains(origen) || rutaDetalle.getText().contains(destino) || nochesDetalle.getText().contains(noches);
    }
}