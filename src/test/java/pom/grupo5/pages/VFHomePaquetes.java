package pom.grupo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.grupo5.base.SeleniumBase;

public class VFHomePaquetes extends SeleniumBase {

    By origen = By.xpath("//input[contains(@class,'sbox-places-first sbox-origin-container')]");
    By destino = By.xpath("//input[contains(@class,'sbox-places-second')]");
    By localizadorOpcion = By.xpath("//body/div[11]/div[1]/div[1]/ul[1]/li[1]");
    By btnBuscar = By.xpath("//a[contains(@class, 'sbox-search')]");
    By checkbox = By.xpath("//*[contains(@class, 'switch-container')]");
    By fechaIda = By.xpath("//input[@placeholder='Ida']");
    By fechaVuelta = By.xpath("//input[@placeholder='Vuelta']");
    By btnVueloMasAuto = By.xpath("//input[@value='va']");
    By btnNextCalendario = By.xpath("//body/div[5]/div[1]/div[2]/div[2]");
    By btnApicarCalendario = By.xpath("/html/body/div[7]/div/div[6]/div[2]/button[2]");

    public VFHomePaquetes(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }
    public String ingresarCiudadOrigen(String ciudad) {
        ingresarTexto(origen, ciudad);
        String textOrigen = encontrarElemento(localizadorOpcion).getText();
        ingresarEnter(origen);
        return textOrigen;
    }
    public String ingresarCiudadDestino(String ciudad) {
        ingresarTexto(destino, ciudad);
        String textDestino = encontrarElemento(localizadorOpcion).getText();
        ingresarEnter(destino);
        return textDestino;
    }
    public void realizarBusqueda() {encontrarElemento(btnBuscar).click();  }
    public void seleccionarTodaviaNoElegiFecha() { encontrarElemento(checkbox).click(); }
    public void seleccionVueloMasAuto() { encontrarElemento(btnVueloMasAuto).click();}
    public boolean urlContains(String s) {return obtenerUrl().contains(s);}
    public String seleccionarFechaIda(String dd, String mm, String aaaa) {
        encontrarElemento(fechaIda).click();
        return obtenerAtributoValue(fechaIda);
    }
    public String seleccionarFechaVuelta(String dd, String mm, String aaaa) {
        encontrarElemento(fechaVuelta).click();
        return obtenerAtributoValue(fechaVuelta);
    }
    public void aplicarFecha(){encontrarElemento(btnApicarCalendario).click();}
}