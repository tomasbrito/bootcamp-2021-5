package pom.grupo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.grupo5.base.SeleniumBase;

import java.util.List;

public class VFHomePaquetes extends SeleniumBase {
    final static String Ida = "ida";
    final static String Vuelta = "vuelta";
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
        setText(origen, ciudad);
        String textOrigen = findElement(localizadorOpcion).getText();
        setKeyEnter(origen);
        return textOrigen;
    }
    public String ingresarCiudadDestino(String ciudad) {
        setText(destino, ciudad);
        String textDestino = findElement(localizadorOpcion).getText();
        setKeyEnter(destino);
        return textDestino;
    }
    public void realizarBusqueda() {
        findElement(btnBuscar).click();  }
    public void seleccionarTodaviaNoElegiFecha() { findElement(checkbox).click(); }
    public void seleccionVueloMasAuto() { findElement(btnVueloMasAuto).click();}
    public boolean urlContains(String s) {return getUrl().contains(s);}
    public String seleccionarFecha(String tipoFecha,String dd, String mm, String aaaa) {
        switch (tipoFecha){
            case Ida:
                findElement(fechaIda).click();
                selectDate(2,dd,mm,aaaa);
                return getAttributeValue(fechaIda);
            case Vuelta:
                selectDate(2,dd,mm,aaaa);
                aplicarFecha();
                return getAttributeValue(fechaVuelta);
            default:
                throw new IllegalStateException("Unexpected value: " + tipoFecha);
        }
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
    public String seleccionarFechaVuelta(String dd, String mm, String aaaa) {
        findElement(fechaVuelta).click();
        return getAttributeValue(fechaVuelta);
    }
    public void aplicarFecha(){
        findElement(btnApicarCalendario).click();
    }
}