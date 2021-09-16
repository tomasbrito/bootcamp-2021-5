package pom.grupo5.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.grupo5.base.SeleniumBase;

import java.util.List;

public class VFReservaPaquetes extends SeleniumBase {
    public VFReservaPaquetes(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Localizadores

        By locStepperContainer = By.xpath("//*[@class='wizard-stepper-container']");
        By locResumenViaje = By.xpath("//*[@class='sheet-container']");
        By adicionales = By.xpath("//*[@class='xs-card-component -eva-3-shadow-1 TRANSFER']");
        By btnConfirmarTraslado = By.xpath("//a[@class='eva-3-btn-ghost -lg -primary']");
        By btnVerViaje = By.xpath("//a[@class='button -md eva-3-btn -primary']");
        By tituloVerViaje = By.className("texts");
        By checkboxHabitaciones = By.tagName("aloha-roompack-selection");
        By btnSiguienteHabitaciones = By.xpath("//*[@class='eva-3-btn -md -primary -eva-3-fwidth']");
        By btnSiguienteVuelo = By.xpath("//a[@class='-md eva-3-btn -primary']");
        By localizadorVuelo = By.xpath("//div[@class='itineraries']");
        By localizadorAviso = By.xpath(" //*[@class='eva-3-message eva-3-message--toast -eva-3-shadow-static -success -loading']");
        By locAvisoText = By.xpath("//h5[@class='message-title']");
        By quitarTrasladoDefault = By.xpath("//div[@class='remove-container -eva-3-tc-gray-0']");
        By btnQuitarTraslado = By.xpath("//button[@class='eva-3-btn -md -primary']");




        //  Keyword Driven

    public void seleccionarHabitacion(int i) throws InterruptedException {
            i--;
            List<WebElement> habitaciones = findElements(checkboxHabitaciones);
            WebElement habitacionElegida = habitaciones.get(i);
            habitacionElegida.click();
            findElement(btnSiguienteHabitaciones).click();
            waitVisibilityElementLocated(localizadorVuelo);
        }


    public void seleccionarVueloSugerido(int i) {
        i--;
       List<WebElement> vuelos = findElements(localizadorVuelo);
       vuelos.get(i).findElement(btnSiguienteVuelo).click();
        waitVisibilityElementLocated(locStepperContainer);
    }

    public void quitarTrasladoDefault(){
        findElement(quitarTrasladoDefault).click();
        findElement(btnQuitarTraslado).click();
        waitVisibilityElementLocated(localizadorAviso);
        String aviso = findElement(locAvisoText).getText();
        Assert.assertEquals("Quitaste el transfer de tu paquete",aviso);

    }

    public void seleccionarVerViaje() {
        findElement(btnVerViaje).click();
        waitVisibilityElementLocated(locResumenViaje);
        String titulos = findElement(tituloVerViaje).getText();
        String titulo = titulos.split("\n")[0];
        Assert.assertEquals("Tu itinerario de viaje",titulo);
    }

    public void agregarTraslado(int nTraslado) {
        nTraslado--;
        List<WebElement> adds = findElements(adicionales);
        adds.get(nTraslado).click();
        findElement(btnConfirmarTraslado).click();
    }
}
