package pom.grupo5.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.grupo5.base.SeleniumBase;

import java.util.List;

public class VFHomePaquetes extends SeleniumBase {
    public final static String Ida = "ida";
    final static String Vuelta = "vuelta";
    final static String Destino1Desde = "desdeDestino1";
    final static String Destino2Desde = "desdeDestino2";
    final static String Destino1Hasta = "hastaDestino1";
    final static String Destino2Hasta = "hastaDestino2";
    final static String IdaCalendarioLateral = "idaCalendarioLateral";
    final static String VueltaCalendarioLateral = "vueltaCalendarioLateral";

    // Localizadores
    By origen = By.xpath("//input[contains(@class,'sbox-places-first sbox-origin-container')]");
    By destino = By.xpath("//input[contains(@class,'sbox-places-second')]");
    By segundoDestino = By.xpath("//input[contains(@class,'sbox-hotel-second-destination')]");
    By btnBuscar = By.xpath("//a[contains(@class, 'sbox-search')]");
    By checkbox = By.xpath("//*[contains(@class, 'switch-container')]");
    By fechaIda = By.xpath("//input[@placeholder='Ida']");
    By fechaDesdeDestino1 = By.xpath("//input[contains(@class,'sbox-hotel-first-checkin-date')]");
    By fechaDesdeDestino2 = By.xpath("//input[contains(@class,'sbox-hotel-second-checkin-date')]");
    By fechaVuelta = By.xpath("//input[@placeholder='Vuelta']");
    By fechaHastaDestino1 = By.xpath("//input[contains(@class,'sbox-hotel-first-checkout-date')]");
    By fechaHastaDestino2 = By.xpath("//input[contains(@class,'sbox-hotel-second-checkout-date')]");
    By btnVueloMasAuto = By.xpath("//input[@value='va']");
    By btnDosAlojamientos = By.xpath("//input[@value='vhh']");
    By btnApicarCalendario = By.xpath("//button[contains(@class,'_dpmg2--desktopFooter-button-apply')]");
    By resumen = By.xpath("//*[@id=\"pkg-wizard\"]/div/div[4]");
    By ofertasPaquete = By.xpath("//a[contains(@class,'offer-href')]");
    By habitaciones = By.xpath("//div[contains(@class,'sbox-ui-rooms-container sbox-passengers-picker-container')]");
    By btnMenosPersonas = By.xpath("//a[@class='steppers-icon-left sbox-3-icon-minus']");
    By alojamientoSiguiente = By.xpath("//*[@class='eva-3-btn -md -primary -eva-3-fwidth']");
    By localizadorOpcion = By.xpath("//body/div[11]/div[1]/div[1]/ul[1]/li[1]");
    By aplicarHabitaciones = By.xpath("//body[1]/div[4]/div[1]/div[2]/a[1]");
    By btnVerResumen = By.xpath("//body[1]/div[13]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]");
    By headerResumen = By.xpath("//body/div[@id='pkg-wizard']/div[1]/div[4]/div[1]/div[1]/div[1]");
    //  Keyword Driven
    public VFHomePaquetes(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    public String ingresarCiudadOrigen(String ciudad) {
        setText(origen, ciudad);
        String textOrigen = findElement(localizadorOpcion).getText();
        setKeyEnter(origen);
        return textOrigen;
    }

    public String ingresarCiudadDestino(String ciudad, int nDestino) {
        String textDestino ="";
        switch (nDestino){
            case 1:
                setText(destino, ciudad);
                textDestino = findElement(localizadorOpcion).getText();
                setKeyEnter(destino);
            break;
            case 2:
                setText(segundoDestino, ciudad);
                textDestino = findElement(localizadorOpcion).getText();
                setKeyEnter(segundoDestino);
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + nDestino);
        }
        return textDestino;
    }

    public void realizarBusqueda() {
        findElement(btnBuscar).click();
    }

    public void seleccionarBtn(String elemento) {
        switch (elemento){
            case "TodaviaNoElegiFecha": findElement(checkbox).click();
                break;
            case "VueloMasAuto": findElement(btnVueloMasAuto).click();
                break;
            case "DosAlojamientos": findElement(btnDosAlojamientos).click();
                break;
            case "VerResumen":
                waitElementClickable(btnVerResumen);
                findElement(btnVerResumen).click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + elemento);
        }
    }

    public boolean urlContains(String s) {return getUrl().contains(s);}

    public String seleccionarFecha(String tipoFecha,String dd, String mm, String aaaa) {
        switch (tipoFecha){
            case Ida:
                findElement(fechaIda).click();
                selectDate(2,dd,mm,aaaa);
                return getAttributeValue(fechaIda);
            case Vuelta:
                selectDate(2,dd,mm,aaaa);
                aplicarFecha(4);
                return getAttributeValue(fechaVuelta);
            case Destino1Desde:
                return getAttributeValue(fechaDesdeDestino1);
            case Destino2Desde:
                return getAttributeValue(fechaDesdeDestino2);
            case Destino1Hasta:
                findElement(fechaHastaDestino1).click();
                selectDate(1,dd,mm,aaaa);
                aplicarFecha(1);
                return getAttributeValue(fechaHastaDestino1);
            case Destino2Hasta:
                return getAttributeValue(fechaHastaDestino2);
            case IdaCalendarioLateral:
                findElement(fechaIda).click();
                selectDate(4,dd,mm,aaaa);
                return getAttributeValue(fechaIda);
            case VueltaCalendarioLateral:
                selectDate(4,dd,mm,aaaa);
                aplicarFecha(4);
                return getAttributeValue(fechaVuelta);
            default:
                throw new IllegalStateException("Unexpected value: " + tipoFecha);
        }
    }

    public void seleccionarOferta(int i) {
        WebElement paquete = findElements(ofertasPaquete).get(i);
        paquete.click();
        waitUrlContains("trip/accommodations/results/");
        Assert.assertTrue(urlContains("trip/accommodations/results/"));
    }

    public String getResumenText(){
       return findElement(resumen).findElement(headerResumen).getText();
    }
    private void aplicarFecha(int indice){
        List<WebElement> btnApply = findElements(btnApicarCalendario);
        btnApply.get(indice).click();
    }

    private void selectDate(int nCalendar, String dd, String mm, String aaaa) {
        By actualM = By.xpath("//div[contains(@class,'_dpmg2--month-active')]");
        List<WebElement> actualMonth = findElements(actualM);
        int actual = Integer.parseInt(actualMonth.get(nCalendar).getAttribute("data-month").substring(5));
        int clicks =  Integer.parseInt(mm)- actual;
        WebElement btnNext = findElement(By.xpath("//body/div[5]/div[1]/div[2]/div[2]"));
        for (int i =1;i<=clicks;i++) btnNext.click();
        By locMes = By.xpath("//*[@data-month='"+ aaaa +"-"+ mm + "']");
        List<WebElement> month = findElements(locMes);
        List<WebElement> days = month.get(nCalendar).findElements(By.tagName("span"));
        for (WebElement day : days) {
            if(day.getText().equals(dd)){
                day.click();
                break;
            }
        }
    }


    public void seleccionarCantidadDeAdultos(int cant) {
        findElement(habitaciones).click();
        int clicks;
        if(cant < 2){
             findElement(btnMenosPersonas).click();
        }else if(cant > 2){
            //clicks = cant -2;
           // for (int i=0; i< clicks; i++)
            // Falta implementar para sumar + de 2 personas
        }
        findElement(aplicarHabitaciones).click();
    }

    public void seleccionarAlojamientoSugerido() {
        waitElementClickable(alojamientoSiguiente);
        findElement(alojamientoSiguiente).click();
    }
}