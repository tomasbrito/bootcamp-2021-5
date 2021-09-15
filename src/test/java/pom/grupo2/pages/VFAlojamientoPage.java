package pom.grupo2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.grupo2.base.SeleniumBase;

public class VFAlojamientoPage extends SeleniumBase {
    public VFAlojamientoPage(WebDriver driver) {
        super(driver);
    }

    By origen = By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Ingresa una ciudad, alojamiento o atracción']");
    By destino = By.xpath("");
    By calendario = By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Entrada']");
    By fechaEntrada = By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Entrada']");
    By fechaSalida = By.xpath("//div[@id='sboxContainer-hotels'] //input[@placeholder='Salida']");
    By listaSugeridaOrigen = By.className("ac-group-title");
    By diaCalendario = By.xpath("_dpmg2--date-number");
    By dropdownEdad= By.className("select-tag");
    By fecha1 = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[22]");
    By fecha2 = By.xpath("//body/div[1]/div[1]/div[5]/div[2]/div[4]/span[12]");
    By primeraSugerencia= By.className("item-text");
    By cuadroHabitaciones = By.xpath("//label[contains(text(),'Habitaciones')]");
    By menosPersonaMayor = By.xpath("//div[@class='_pnlpk-itemBlock'] //a[@class=\"steppers-icon-left sbox-3-icon-minus\"]");
    By masPersonaMenor = By.xpath("//div[@class='_pnlpk-itemBlock'] //div[@class=\"_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg\"] //a[@class=\"steppers-icon-right sbox-3-icon-plus\"]");
    By btnBuscar = By.linkText("Buscar");
    By btnAplicar = By.linkText("Aplicar");


    public void escribirEnOrigen(String mensaje) { type(mensaje, origen); }

    public void buscar(){
        click(btnBuscar);
    }

    public String obtenerMensajeListaSugeridaOrigen(){
        return getText(listaSugeridaOrigen);
    }

    public String obtenerOrigen(){
        return getText(origen);
    }

    public String obtenerFechaEntrada(){
        return getText(fechaEntrada);
    }

    public String obtenerFechaSalida(){
        return getText(fechaSalida);
    }

    public void esribirEnDestino(String mensaje){
        type(mensaje, destino);
    }

    public void escribirEnOrigenYSeleccionar(String mensaje){
        type(mensaje, origen);
        exwait(listaSugeridaOrigen);
        click(primeraSugerencia);
    }

    public void seleccionarFechas(){
        click(calendario);
        click(fecha1);
        click(fecha2);
    }

    public void selectEdadMenor(String value){
        WebElement dropdown = findElement(dropdownEdad);
        Select manejodropdown = new Select(dropdown);
        manejodropdown.selectByValue(value);
        click(btnAplicar);
    }

    public void modificarPersonas(){
        click(cuadroHabitaciones);
        click(menosPersonaMayor);
        click(masPersonaMenor);
    }

    public void navegadorBack() throws InterruptedException {
        Thread.sleep(5000);
        back();
    }

}
