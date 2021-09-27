package pruebaTbrito.Pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pruebaTbrito.base.SeleniumBase;

import java.util.List;

public class MLHomePage extends SeleniumBase {

    public MLHomePage(WebDriver driver) {
        super(driver);
    }
    //localizadores
    By barraBusqueda = By.className("nav-search-input");
    By primerPublicacion = By.xpath("//h2[@class='ui-search-item__title']");
    By historialPrimera =  By.xpath("//h2[@class='ui-card-ml-label ui-card-ml-title']");
    By historial = By.xpath("//a[contains(text(),'Historial')]");
    By tituloPublicacion = By.xpath("//h1[@class='ui-pdp-title']");
    By formasDeEntrega = By.xpath("//a[contains(text(),'Ver más formas de entrega')]");
    By elegirUbicacion = By.xpath("//a[@class='ui-pdp-media__action ui-vpp-generic-shipping-list__action']");
    By fieldCP = By.name("zipcode");
    By CPactual = By.xpath("(//span[@class='ui-vpp-generic-shipping-list__description'])[1]");
    By enviarA = By.xpath("//span[@class='nav-menu-link-cp']");
    By llenarCP = By.xpath("//span[contains(text(),'Ingresar un código postal')]");
    By ordenar = By.className("andes-dropdown__trigger");
    By menorPrecio = By.xpath("//li[@index='1']");
    By primerResultado = By.xpath("//span[@class='price-tag-fraction']");
    By segundoResultado = By.xpath("(//span[@class='price-tag-fraction'])[2]");

    //Keyword Driven
    public void ordenar(){
        exwait(ordenar);
        click(ordenar);
        exwait(menorPrecio);
        click(menorPrecio);
        System.out.printf("");
    }

    public void realizarBusqueda(String texto){
        type(texto,barraBusqueda);
        type(Keys.ENTER,barraBusqueda);
    }

    public String abrirPublicacionYObtenerTexto(){
        exwait(primerPublicacion);
        click(primerPublicacion);
        return obtenerTexto(tituloPublicacion);
    }

    public void abrirPublicacion(){
        exwait(primerPublicacion);
        click(primerPublicacion);
    }


    public String primerPublicacionHistorial() {
        click(historial);
        exwait(historialPrimera);
        return obtenerTexto(historialPrimera);
    }

    public void cambiarCP (String CP) {
        switchToIframe();
        click(enviarA);
        exwait(fieldCP);
        type(CP, llenarCP);
        type(Keys.ENTER, llenarCP);
    }

    public String obtenerCPactual() {
        return obtenerTexto(CPactual);
    }

    public boolean compararPrecios() {
        String primerPrecio = obtenerTexto(primerResultado);
        String segundoPrecio = obtenerTexto(segundoResultado);
        int precioA = Integer.parseInt(primerPrecio.replaceAll("\\p{Punct}", ""));
        int precioB = Integer.parseInt(segundoPrecio.replaceAll("\\p{Punct}", ""));
        //int precioa = Integer.parseInt(precioASTR);
        //int preciob = Integer.parseInt(precioBSTR);
        System.out.println("");
        if (precioA<=precioB) {
            return true;
        } else {
            return false;
        }

    }
}
