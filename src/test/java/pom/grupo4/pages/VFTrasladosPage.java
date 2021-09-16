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
    By inputFechaPartida = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By fechaPartidaElegida = By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[4]/span[30]/span[1]");
    By botonAplicarFechaPartida = By.xpath("//body/div[3]/div[1]/div[6]/div[2]/button[2]");
    By selectMoneda = By.xpath("//select[@id='currency-select']");
    By textoEnDolares = By.xpath("//body/div[6]/div[1]/div[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/search-item[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/span[1]");
    By botonComprar = By.xpath("//body/div[6]/div[1]/div[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[1]/search-item[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/button[1]");
    By casillaHaciaElAeropuerto = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/span[2]/label[1]/i[1]");
    By casillaRegresoIncluido = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[3]/span[1]/label[1]/i[1]");
    By inputFechaHastaElAeropuerto = By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By fechaElegidaHastaElAeropuerto = By.xpath("//body/div[2]/div[1]/div[5]/div[1]/div[4]/span[27]/span[1]");
    By botonAplicarFechaHastaElAeropuerto = By.xpath("//body/div[2]/div[1]/div[6]/div[2]/button[2]/em[1]");
    By botonComprarHaciaElAeropuerto = By.xpath("//body/div[6]/div[1]/div[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/search-item[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/button[1]");
    By botonSeleccionarTarjeta = By.xpath("//div[contains(text(),'Selecciona tu tarjeta')]");
    By tarjetaFalabella = By.xpath("//h5[contains(text(),'Banco Falabella')]");
    By textoMastercard = By.xpath("//h5[contains(text(),'MasterCard')]");
    By textoUnPago = By.xpath("//span[contains(text(),'1 pago')]");
    By botonCambiarTarjeta = By.xpath("//em[contains(text(),'Cambiar')]");
    By textoSantander = By.xpath("//h5[contains(text(),'Santander')]");
    By textoVisa = By.xpath("//h5[contains(text(),'Visa')]");
    By textoTresCuotas = By.xpath("//span[contains(text(),'3 cuotas')]");
    By textoVisaBancoSantander = By.xpath("//h6[contains(text(),'Visa Banco Santander')]");
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
    public void clickearCasillaRegresoIncluido(){
        click(casillaRegresoIncluido);
    }
    public void ingresarFechaPartida(){
        click(inputFechaPartida);
        click(fechaPartidaElegida);
        click(botonAplicarFechaPartida);
    }

    public void cambiarMonedaADolares(){
        WebElement select = encontrarElemento(selectMoneda);
        Select s = new Select(select);
        s.selectByValue("string:USD");
    }
    public String getMonedaUtilizada(){
        return obtenerTexto(textoEnDolares);
    }
    public void clickearBotonComprar(){
        click(botonComprar);
    }
    public void clickearBotonComprarHaciaElAeropuerto(){
        click(botonComprarHaciaElAeropuerto);
    }
    public void clickearCasillaHaciaElAeropuerto(){
        click(casillaHaciaElAeropuerto);
    }
    public void ingresarFechaHaciaElAeropuerto(){
        click(inputFechaHastaElAeropuerto);
        click(fechaElegidaHastaElAeropuerto);
        click(botonAplicarFechaHastaElAeropuerto);
    }
    public void clickearBotonSeleccionarTarjeta(){
        click(botonSeleccionarTarjeta);
    }
    public void seleccionarTarjetaFalabella(){
        click(tarjetaFalabella);
        click(textoMastercard);
        click(textoUnPago);
    }
    public void clickearBotonCambiarTarjeta(){
        click(botonCambiarTarjeta);
    }
    public void seleccionarTarjetaSantander(){
        click(textoSantander);
        click(textoVisa);
        click(textoTresCuotas);
    }
    public String getTextoTarjetaFinal(){
        return obtenerTexto(textoVisaBancoSantander);
    }

}
