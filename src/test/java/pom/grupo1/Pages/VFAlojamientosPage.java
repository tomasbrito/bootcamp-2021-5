package pom.grupo1.Pages;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.grupo1.base.SeleniumBase;

import java.util.ArrayList;
import java.util.List;

public class VFAlojamientosPage extends SeleniumBase {

    public VFAlojamientosPage(WebDriver driver) {
        super(driver);
    }

    final int GENERAL_TIMEOUT_TIME = 3;

    //test1
    By btnBuscarBy = By.linkText("Buscar");
    By alojamientosFormBy = By.className("sbox-dates");
    By fechaTooltipsBy = By.className("validation-msg");
    //test2
    By destinoContainerBy = By.className("sbox-places");
    By destinoInputBy = By.tagName("input");
    By firstResultBy = By.xpath("//li[@class=\"item -active\"]");
    By noHeDecididoFechaCheckboxBy = By.xpath("//label[text()=\"Todavía no he decidido la fecha\"]");
    By resultContainerBy = By.xpath("//div[@class=\"results-cluster-container\"]");
    By currencySelectBy = By.xpath("//select[@name=\"currency\"]");
    By pricesListBy = By.className("landing-inline");
    By loadingSpinnerBy = By.id("fullLoader");

    public void makeSearch() {
        click(btnBuscarBy);
    }

    public void waitForResultsPage(String expectedUrl) {
        waitUrlContains(expectedUrl, GENERAL_TIMEOUT_TIME);
        waitElementsToBeMoreThan(0, resultContainerBy, GENERAL_TIMEOUT_TIME);
    }

    public List<String> getFechasTooltipsMsgs() {
        WebElement alojamientosForm = findElement(alojamientosFormBy);
        List<WebElement> fechasTooltips = findChildrenElements(fechaTooltipsBy, alojamientosForm);

        List<String> tooltipsMsgs = new ArrayList<>();

        for (WebElement tooltip : fechasTooltips) {
            tooltipsMsgs.add(getText(tooltip));
        }

        return tooltipsMsgs;
    }

    public void selectDestino(String place) {
        WebElement destinoContainer = findElement(destinoContainerBy);
        WebElement destinoInput = findChildElement(destinoInputBy, destinoContainer);

        type(place, destinoInput);
        waitElementsToBeMoreThan(0, firstResultBy, GENERAL_TIMEOUT_TIME);
        click(firstResultBy);
    }

    public void checkNoHeDecididoFecha() {
        click(noHeDecididoFechaCheckboxBy);
    }

    public void selectCurrencyType(String currency) {
        selectByValue(currencySelectBy, currency);
    }

    public void waitResultsRefresh() {
        waitInvisibilityOf(loadingSpinnerBy, GENERAL_TIMEOUT_TIME);
    }

    public boolean isCurrencyIn(String displayedCurrency) {
        List<WebElement> pricesList = findElements(pricesListBy);

        try {
            for (WebElement price : pricesList) {
                boolean isDisplayedCurrency = getText(price).contains(displayedCurrency);
                Assert.assertTrue(isDisplayedCurrency);
            }
            return true;

        } catch (AssertionFailedError e) {
            return false;
        }

    }
}
