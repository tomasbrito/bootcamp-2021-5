package pom.grupo2.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.grupo2.base.SeleniumBase;

public class VFTrasladoPage extends SeleniumBase {
    public VFTrasladoPage(WebDriver driver) {
        super(driver);
    }

    By cuadroPasajeros= By.xpath("//*[@id=\"sboxContainer-transferspoi\"] //div[@class=\"sbox-distri-container\"]");
    By btnMasMenor= By.xpath("//div[@class=\"_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg\"] //a[@class=\"steppers-icon-right sbox-3-icon-plus\"]");
    By btnBuscar = By.linkText("Buscar");
    By avisoEdad = By.xpath("//div[@class=\"_pnlpk-panel-scroll\"] //div[@class=\"sbox-3-message -error _pnlpk-minors-without-age\"]");
    By origen = By.xpath("//div[@id='sboxContainer-transferspoi'] //input[@placeholder='Ingresa un aeropuerto']");
    By destino = By.xpath("//div[@id='sboxContainer-transferspoi'] //input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']");
    By primeraSugerencia= By.className("item-text");
    By sheratonMiramar= By.xpath("//span[contains(text(),'Sheraton Miramar - Avenida Marina, Viña del Mar, C')]");
    By checkRegreso = By.xpath("//*[@id=\"sboxContainer-transferspoi\"] //label[@class=\"checkbox-label\"]");
    By calendario = By.className("sbox-moment-input");
    By fecha1 = By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[4]/span[22]");
    By fecha2 = By.xpath("//body/div[3]/div[1]/div[5]/div[2]/div[4]/span[12]");
    By btnAplicar = By.xpath("//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]");
    By dropHoraIda = By.xpath("//*[@id=\"sboxContainer-transferspoi\"] //select[@class=\"select-tag sbox-time-arrival\"]");
    By dropHoraVuelta = By.xpath("//*[@id=\"sboxContainer-transferspoi\"] //select[@class=\"select-tag sbox-time-departure\"]");

    By btnModificar=By.linkText("Modificar");
    By modificarIda= By.xpath("//*[@id=\"bodyID\"] //*[@placeholder='Ingresa un aeropuerto']");
    By modificarVuelta= By.xpath("//*[@id=\"bodyID\"] //*[@placeholder='Ingresa un hotel o dirección adónde quieras ir']");
    By modificarFechaIda = By.xpath("//*[@id=\"bodyID\"] //*[@placeholder='Arribo']");
    By modificarFechaVuelta =By.xpath("//*[@id=\"bodyID\"] //*[@placeholder='Partida']");
    By modificarHoraIda = By.xpath("//*[@id=\"bodyID\"] //*[@class=\"select-tag sbox-time-arrival\"]");
    By modificarHoraVuelta= By.xpath("//*[@id=\"bodyID\"] //*[@class=\"select-tag sbox-time-departure\"]");


    public void agregarMenorEnPasajeros(){
        click(cuadroPasajeros);
        click(btnMasMenor);
    }

    public void validacionMensajeEdadDeMenor(String mensaje){
        click(cuadroPasajeros);
        Assert.assertEquals(mensaje, getText(avisoEdad));
    }

    public void escribirEnOrigenYSeleccionar(String mensaje){
        type(mensaje, origen);
        click(primeraSugerencia);
    }

    public void escribirEnDestinoYSeleccionarMiramar(String mensaje){
        type(mensaje, destino);
        click(sheratonMiramar);
    }

    public void seleccionarFechas(){
        click(calendario);
        click(fecha1);
        click(fecha2);
        click(btnAplicar);
    }

    public void seleccionarHoras(String value1, String value2){
        selectByValue(dropHoraIda,value1);
        selectByValue(dropHoraVuelta,value2);
    }

    public void verificarModificaciones(){
        click(btnModificar);
        Assert.assertEquals("input", getTagName(modificarIda));
        Assert.assertEquals("input", getTagName(modificarVuelta));
        Assert.assertEquals("input", getTagName(modificarFechaIda));
        Assert.assertEquals("input", getTagName(modificarFechaVuelta));
        Assert.assertEquals("select", getTagName(modificarHoraIda));
        Assert.assertEquals("select", getTagName(modificarHoraVuelta));
    }




    public void clickEnCheck(){
        click(checkRegreso);
    }

    public void buscar() throws InterruptedException {
        click(btnBuscar);
        Thread.sleep(1000);
    }
}
