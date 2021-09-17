package pom.grupo3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.grupo3.base.SeleniumBase;

public class VFAlojamientoG3 extends SeleniumBase {


    public VFAlojamientoG3(WebDriver driver) {
        super(driver);
    }

    By btnBuscar = By.linkText("Buscar");
    By origen = By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div/input");
    By destino = By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div/input");
    By FechaIda = By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div/input");
    By destinoContainerBy = By.className("sbox-places");

    public void selectDestino(String place) {

        /*WebElement destinoContainer = encontrarElemento(destinoContainerBy);
        WebElement destinoInput = findChildElement(destinoInputBy, destinoContainer);

        type(place, destinoInput);
        waitElementsToBeMoreThan(0, firstResultBy, GENERAL_TIMEOUT_TIME);
        click(firstResultBy);*/
    }

    public void selectDate(String year_month, String entrada_day, String salida_day) { //elegir fecha inicio,fin, y aplicar

    }


    public void addRoom(int room) {
    }

    public void addAdult(int manyadult) {
    }

    public void addkid(int manychildren) {
    }

    public void setAgeKid(String children_age, int room) {
    }

    public void search() {

    }

    public void selectFirstElement() {
    }

    public void seeRoom() {
    }

    public int getPriceForNight() {
        int price;
        return  0;
    }
}
