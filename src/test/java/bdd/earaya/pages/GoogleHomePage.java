package bdd.earaya.pages;

import bdd.mentoria.bases.SeleniumBase;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends SeleniumBase {

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    //atributos - localizadores
    By barraBusquedaGoogle = By.name("q");
    By btnBuscarConGoogle = By.name("btnK");


    //funciones - keyword Driven
    public void entrarAHomePage(){
        goToUrl("https://www.google.com");
        assertEquals(true, isDisplayed(barraBusquedaGoogle));
    }

    public void busquedaSimpleBarraGoogle(String buscar){
        type(buscar,barraBusquedaGoogle);
    }

    public void presionarEnterABarraGoogle(){
        typeKey(Keys.ENTER,barraBusquedaGoogle);
    }


}
