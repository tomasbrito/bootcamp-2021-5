package pom.grupo5.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.grupo5.base.SeleniumBase;

public class VFReservaPaquetes extends SeleniumBase {
    public VFReservaPaquetes(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Localizadores
        By habitacioElegida = By.xpath("//*[@id=\"roompacks-container-wrapper\"]/aloha-roompacks-container/aloha-roompacks-grid-container/div[2]/div[1]/aloha-roompacks-group-container[2]/div[2]/aloha-roompack-container[1]/div[4]/aloha-roompack-selection");
        By habitacioElegidabtnSiguiente = By.xpath("//body[1]/aloha-app-root[1]/aloha-detail[1]/div[1]/div[4]/div[1]/div[2]/aloha-roompacks-container[1]/aloha-roompacks-grid-container[1]/div[2]/div[2]/aloha-reservation-summary-container[1]/div[1]/aloha-next-step-button[1]/aloha-button[1]");
        By localizadorVuelo =  By.xpath("//body/div[@id='flights-container-wrapper']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[3]/trips-cluster-selected[1]/span[1]/cluster[1]/div[1]/div[1]");
        By btnSiguienteVuelo = By.xpath("//body/div[@id='flights-container-wrapper']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[3]/trips-cluster-selected[1]/span[1]/cluster[1]/div[1]/div[1]/div[2]/fare[1]/span[1]/span[1]/div[2]/buy-button[1]/a[1]");
        By locStepperContainer = By.xpath("//*[@class='wizard-stepper-container']");
        By localizadorAviso = By.xpath("//body/app-root[1]/app-toasts-container[1]/div[1]");
        By trasladoDefault = By.xpath("//body/app-root[1]/div[1]/div[3]/div[1]/app-highlighted-products[1]/div[1]/div[2]/div[2]/div[1]/app-transfer[1]/div[1]/div[1]/div[2]/span[1]/div[1]/a[1]");
        By btnQuitarTraslado =By.xpath("//body/app-root[1]/div[1]/app-confirm-delete-modal[1]/div[1]/div[3]/button[1]");
        By locAvisoText = By.xpath("//body/app-root[1]/app-toasts-container[1]/div[1]/div[1]/app-toast[1]/div[1]/div[2]");
        By traslado = By.xpath("//body/app-root[1]/div[1]/div[3]/div[2]/div[2]/app-products-carousel[1]/div[2]/app-carousel[1]/div[1]/swiper[1]/div[1]/div[2]");
        By btnAgregarTraslado = By.xpath("//body/app-root[1]/div[1]/app-transfer-modal[1]/div[1]/div[3]/app-modal-pricebox-sticky[1]/div[1]/div[2]/a[1]");
        By locResumenViaje = By.xpath("//*[@class='sheet-container']");
        By btnVerViaje = By.xpath("//body/app-root[1]/div[1]/div[1]/app-wizard-ab[1]/wizard[1]/div[1]/div[2]/wizard-step[3]/div[1]/div[1]/div[1]/a[1]");
        By tituloVerViaje = By.xpath("//body/app-root[1]/div[1]/div[1]/app-wizard-ab[1]/wizard[1]/wizard-modal[1]/div[1]/div[1]/div[1]");
    //  Keyword Driven

    public void seleccionarHabitacionSugerida(){
            findElement(habitacioElegida).click();
            findElement(habitacioElegidabtnSiguiente).click();
            waitVisibilityElementLocated(localizadorVuelo);
        }


    public void seleccionarVueloSugerido() {
        findElement(localizadorVuelo).findElement(btnSiguienteVuelo).click();
        waitVisibilityElementLocated(locStepperContainer);
    }

    public void quitarTrasladoDefault(){
        findElement(trasladoDefault).click();
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

    public void agregarTraslado(String nombreTraslado) {
        findElement(traslado).click();
        findElement(btnAgregarTraslado).click();
    }
}
