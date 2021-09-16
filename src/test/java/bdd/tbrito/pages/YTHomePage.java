package bdd.tbrito.pages;

import bdd.tbrito.bases.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class YTHomePage extends SeleniumBase {

    public YTHomePage(WebDriver driver) {
        super(driver);
    }

    //atributos
    By barraBusqueda = By.id("search");
    By buttonSearch = By.id("search-icon-legacy");

    public void IngresarAYoutubeHomePage() {
        goToUrl("https://www.youtube.com/");
        assertEquals("YouTube",getCurrentTitle());
    }

    public void ingresarPalabra(String string) {
        type(string, barraBusqueda);
    }

    public void buscarConClickeandoBoton() {
        click(buttonSearch);
    }
}
