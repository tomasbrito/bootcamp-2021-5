package bdd.mentoria.pages;

import bdd.mentoria.bases.SeleniumBase;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GHomePage extends SeleniumBase {

    public GHomePage(WebDriver driver) {
        super(driver);
    }

    //atributos - localizadores
    By barraBusquedaGoogle = By.name("q");
    By btnBusquedaGoogle = By.name("btnK");


    //funciones - keyword driven
    public void IngresarAGoogleHomePage(){
        goToUrl("https://www.google.com/");
        assertEquals("Google",getCurrentTitle());
    }

    public void ingresarPalabraABuscarEnBarraGoogle(String palabraABuscar){
        type(palabraABuscar,barraBusquedaGoogle);
    }

    public void busquedaConBotonEnterEnBarraDeGoogle(){
        typeKey(Keys.ENTER,barraBusquedaGoogle);
        assertTrue(getCurrentUrl().contains("search?q="));
    }

}
