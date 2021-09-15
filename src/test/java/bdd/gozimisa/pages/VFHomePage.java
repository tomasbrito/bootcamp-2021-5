package bdd.gozimisa.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.grupo2.base.SeleniumBase;

public class VFHomePage extends SeleniumBase {

    public VFHomePage(WebDriver driver) {
        super(driver);
    }

    By btnAlojamiento = By.xpath("//a[@product=\"HOTELS\"]");
    By btnBuscar = By.linkText("Buscar");
    By vueloAuto = By.xpath("//*[@id=\"sboxContainer-packages\"] //input[@value='va']");
    By vuelo2Alojamientos = By.xpath("//*[@id=\"sboxContainer-packages\"] //input[@value='vhh']");
    By origen = By.xpath("//*[@id=\"sboxContainer-packages\"] //input[@placeholder=\"Ingresa una ciudad\"]");
    By destino = By.xpath("//*[@id=\"sboxContainer-packages\"] //input[@class=\"input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline\"]");
    By calendario1 = By.xpath("//div[@id='sboxContainer-packages'] //input[@placeholder='Ida']");
    By calendario2 = By.xpath("//div[@id='sboxContainer-packages'] //input[@placeholder='Hasta']");
    By segundoDestino = By.xpath("//*[@id=\"sboxContainer-packages\"] //*[@class=\"input-tag sbox-main-focus sbox-hotel-second-destination sbox-primary undefined\"]");
    By fecha1 = By.xpath("//body/div[5]/div[1]/div[5]/div[1]/div[4]/span[22]");
    By fecha2 = By.xpath("//body/div[5]/div[1]/div[5]/div[2]/div[4]/span[12]");
    By fecha3= By.xpath("//body/div[2]/div[1]/div[5]/div[1]/div[4]/span[26]");
    By primeraSugerencia= By.className("item-text");
    By validacionFechaPartida = By.xpath("//span[contains(text(),'Ingresa una fecha de partida.')]");
    By validacionFechaRegreso = By.xpath("//span[contains(text(),'Ingresa una fecha de regreso.')]");
    By validacionDestino1= By.xpath("//*[@id=\"sboxContainer-packages\"] //*[@class=\"validation-msg sbox-hotel-first-destination-different-from-origin-error\"]");
    By validacionDestino2= By.xpath("//*[@id=\"sboxContainer-packages\"] //*[@class=\"validation-msg sbox-hotel-second-destination-different-from-origin-error\"]");
    //keyword driven

    public void escribirEnOrigenYSeleccionar(String mensaje){
        type(mensaje, origen);
        click(primeraSugerencia);
    }

    public void escribirEnDestinoYSeleccionar(String mensaje){
        type(mensaje, destino);
        click(primeraSugerencia);
    }

    public void escribirEnDestino2YSeleccionar(String mensaje){
        type(mensaje, segundoDestino);
        click(primeraSugerencia);
    }

    public void validacionMensajFechas(String mensaje1, String mensaje2){
        Assert.assertEquals(mensaje1, getText(validacionFechaPartida));
        Assert.assertEquals(mensaje2, getText(validacionFechaRegreso));
    }

    public void seleccionarFechas(){
        click(calendario1);
        click(fecha1);
        click(fecha2);
    }

    public void  selecionarFechaIntermedia(){
        click(calendario2);
        click(fecha3);
    }

    public void validacionMensajeDestino(String mensaje){
        Assert.assertEquals(mensaje, getText(validacionDestino1));
        Assert.assertEquals(mensaje, getText(validacionDestino2));
    }

    public void buscar(){
        click(btnBuscar);
    }

    public void irAlojamiento(){
        click(btnAlojamiento);
    }

    public void irVueloAuto(){
        click(vueloAuto);
    }

    public void irVuelo2Alojamientos(){
        click(vuelo2Alojamientos);
    }
}