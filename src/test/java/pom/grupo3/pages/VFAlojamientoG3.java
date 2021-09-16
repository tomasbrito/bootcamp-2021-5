package pom.grupo3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pom.grupo3.base.SeleniumBase;

import java.util.List;

public class VFAlojamientoG3 extends SeleniumBase {

    final int GENERAL_TIMEOUT_TIME = 5;

    public VFAlojamientoG3(WebDriver driver) {
        super(driver);
    }

    By btnBuscar = By.linkText("Buscar");
    By origenBy = By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input");
    By destinoBy = By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div/input");
    By FechaIda = By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div/input");
    By entradaInput = By.xpath("//input[@placeholder=\"Entrada\"]");
    By spanTagBy = By.tagName("span");
    By aplicarFechasBy = By.xpath("//button/*[text()=\"Aplicar\"]");
    By primerResultadoBy = By.xpath("//li[@class=\"item -active\"]");
    By habitacionesBy = By.xpath("//label[text()=\"Habitaciones\"]");
    By adultoMas = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/a[2]");
    By menorMas = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/a[2]");
    By btnHabitacionesAplicar = By.linkText("Aplicar");
    By menorListaEdad = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/select");
    By resultContainerBy = By.xpath("//div[@class=\"results-cluster-container\"]");


    public void selectDestino(String place) {
        WebElement destino = encontrarElemento(origenBy);

        tipear(place, destino);
        waitElementsToBeMoreThan(0, primerResultadoBy, GENERAL_TIMEOUT_TIME);
        click(primerResultadoBy);
    }

    public void selecFecha(String year_month, String entrada_day, String salida_day) { //elegir fecha inicio,fin, y aplicar
        click(entradaInput);

        WebElement entradaMonth = encontrarElemento(By.xpath("//div[@data-month='" + year_month + "']"));
        List<WebElement> daysList = findChildrenElements(spanTagBy, entradaMonth);

        for (WebElement day : daysList) {
            if (day.getText().equals(entrada_day)) {
                day.click();
                break;
            }
        }
        for (WebElement day : daysList) {
            if (day.getText().equals(salida_day)) {
                day.click();
                break;
            }
        }
        click(aplicarFechasBy);
    }



    public void addAdult(int cant_adult) {
        click(habitacionesBy);
        for (int i = 0; i < cant_adult; i = i + 2) {
            click(adultoMas);
        }
    }

    public void addkid(int cant_niños) {
        for (int i = 0; i < cant_niños; i = i + 2) {
            click(adultoMas);
        }
        click(btnHabitacionesAplicar);
    }

    public void edadMenor(String children_age) {
        Select edad = new Select(encontrarElemento(menorListaEdad));
        edad.selectByVisibleText(children_age);
        click(btnHabitacionesAplicar);
    }

    public void busqueda() {
        click(btnBuscar);
    }
    public void waitForResultsPage(String expectedUrl) {
        waitUrlContains(expectedUrl, GENERAL_TIMEOUT_TIME);
        waitElementsToBeMoreThan(0, resultContainerBy, GENERAL_TIMEOUT_TIME);
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
