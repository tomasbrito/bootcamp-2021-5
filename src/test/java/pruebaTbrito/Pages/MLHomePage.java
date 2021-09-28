package pruebaTbrito.Pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pruebaTbrito.base.SeleniumBase;

import java.security.Key;
import java.util.Collection;
import java.util.List;

public class MLHomePage extends SeleniumBase {

    public MLHomePage(WebDriver driver) {
        super(driver);
    }

    //localizadores

    By barraBusqueda = By.className("nav-search-input");

    // historial
    By primerPublicacion = By.xpath("//h2[@class='ui-search-item__title']");
    By historialPrimera = By.xpath("//h2[@class='ui-card-ml-label ui-card-ml-title']");
    By historial = By.xpath("//a[contains(text(),'Historial')]");
    By tituloPublicacion = By.xpath("//h1[@class='ui-pdp-title']");

    //Cambiar CP
    By CPactual = By.xpath("(//span[@class='ui-vpp-generic-shipping-list__description'])[1]");
    By cambiarCP = By.xpath("(//span[@class='nav-menu-link-cp'])[1]");
    By fieldCP = By.className("andes-form-control__field");
    By botonCambiarCP = By.xpath("//span[@class='andes-button__content']");
    By enviarACP = By.xpath("(//a[@class='ui-pdp-action-modal__link'])[2]");

    //ordenar por precio
    By ordenar = By.className("andes-dropdown__trigger");
    By menorPrecio = By.xpath("//li[@index='1']");
    By listaPublicaciones = By.xpath("//ol[@class='ui-search-layout ui-search-layout--stack']");
    By publicacionListada = By.className("ui-search-price__second-line");
    By precioFinal = By.className("price-tag-text-sr-only");

    //Login
    By botonIngresa = By.xpath("//a[@data-link-id='login']");
    By user_id = By.id("user_id");
    By fieldPassword = By.id("password");

    //Error pregunta sin loguin
    By fieldPregunta = By.name("query");
    By enviarPregunta = By.xpath("//span[text()='Enviar pregunta']");


    //Keyword Driven
    public void ordenar() {
        exwait(ordenar);
        click(ordenar);
        exwait(menorPrecio);
        click(menorPrecio);
    }

    public void realizarBusqueda(String texto) {
        type(texto, barraBusqueda);
        type(Keys.ENTER, barraBusqueda);
    }

    public String abrirPublicacionYObtenerTexto() {
        exwait(primerPublicacion);
        click(primerPublicacion);
        return obtenerTexto(tituloPublicacion);
    }

    public void abrirPublicacion() {
        exwait(primerPublicacion);
        click(primerPublicacion);
    }


    public String primerPublicacionHistorial() {
        click(historial);
        exwait(historialPrimera);
        return obtenerTexto(historialPrimera).replaceAll("  "," ");
    }

    public void cambiarCP(String CP) {
        click(cambiarCP);
        switchToIframe();
        type(CP, fieldCP);
        click(botonCambiarCP);
    }

    public boolean compararPrecios() {
        boolean resultado = true;
        List<WebElement> publicaciones = encontrarElemento(listaPublicaciones).findElements(publicacionListada);
        for (int i = 0; i < publicaciones.size()-2;i++){
            if ( compararPublicaciones(publicaciones.get(i),publicaciones.get(i+1)) ) {
                resultado = false;
            }
        }
        return resultado;
    }

    private boolean compararPublicaciones(WebElement publicacion1, WebElement publicacion2) {
        String precioFinal1 = obtenerTexto(publicacion1.findElement(precioFinal));
        String precioFinal2 = obtenerTexto(publicacion2.findElement(precioFinal));

        int precioA = Integer.parseInt(precioFinal1.replaceAll( "[^\\d]", "" ));
        int precioB = Integer.parseInt(precioFinal2.replaceAll( "[^\\d]", "" ));
        System.out.println(precioA);
        System.out.println(precioB);
        return precioA > precioB;
    }

    public void login(String email, String contraseña) {
        exwait(botonIngresa);
        click(botonIngresa);
        type(email,user_id);
        type(Keys.ENTER,user_id);
        exwait(fieldPassword);
        type(contraseña,fieldPassword);
        type(contraseña,fieldPassword);
    }

    public String buscarCP() {
        return obtenerTexto(enviarACP);
    }

    public void realizarPregunta(String pregunta) {
        exwait(fieldPregunta);
        type(pregunta,fieldPregunta);
        type(Keys.ENTER,fieldPregunta);
        click(enviarPregunta);
        exwait(By.className("center-card__title"));


    }

    public String urlActual() {
        return URLactual();
    }
}
