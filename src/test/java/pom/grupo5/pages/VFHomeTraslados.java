package pom.grupo5.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.grupo5.base.SeleniumBase;

public class VFHomeTraslados extends SeleniumBase {

    public  VFHomeTraslados(WebDriver driver, WebDriverWait wait){super(driver, wait);}
    // Localizadores
    By fieldTo = By.xpath("//*[contains(@class, 'sbox-places-second')]");
    By fieldFrom = By.xpath("//*[contains(@class, 'sbox-places-first places-inline')]");
    By fieldDate = By.xpath("//*[contains(@class, 'input-tag sbox-checkin')]");
    By applyDate = By.xpath("//body[1]/div[3]/div[1]/div[6]/div[2]/button[2]/em[1]");
    By fieldPassengers = By.xpath("//app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]");
    By cantPassengers = By.xpath("//*[contains(@class, 'sbox-distri-tag sbox-passengers')]");
    By btnApplyPassengers = By.xpath("//a[contains(text(),'Aplicar')]");
    By btnSearch = By.xpath("//em[contains(text(),'Buscar')]");
    By btnSumarAdultos = By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[2]");
    By localizadorBtnComprar = By.xpath("//body/div[6]/div[1]/div[1]/div[2]/main[1]/div[3]/div[1]/div[2]/div[5]/search-item[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/button[1]");
    By localizadorBtnTarjeta = By.xpath("//card-container[1]/div[1]/div[2]/card-storage[1]/div[1]/card-empty-slot[1]/div[1]/div[1]");
    By btnChangeCard = By.xpath("//em[contains(text(),'Cambiar')]");
    By locatorSelect = By.id("currency-select");
    By fieldName = By.xpath("//input-component-v2[1]/div[1]/div[1]/div[1]/input[1]");
    By fieldLastName = By.xpath("//traveler-last-name-input[1]/div[1]/div[1]/input-component-v2[1]/div[1]/div[1]/div[1]/input[1]");
    By checkbox = By.xpath("//terms-checkbox-component[1]/checkbox-component[1]/span[1]/label[1]/i[1]");
    By checkboxToValidate = By.xpath("//input[@id='terms-checkbox']");
    //Keyword Driven
    public void enterDataFieldFrom(String place, String placeComplete, By localizadorFrom){
        click(fieldFrom);
        setText(fieldFrom, place);
        waitForElementAndClick(localizadorFrom);
        Assert.assertEquals(placeComplete,getAttributeValue(fieldFrom));
    }
    public void enterDataFieldTo(String place, String placeComplete, By localizadorTo){
        click(fieldTo);
        setText(fieldTo, place);
        waitForElementAndClick(localizadorTo);
        Assert.assertEquals(placeComplete,getAttributeValue(fieldTo));
    }
    public void selectDate(String optionDate, By dateSelected){
        click(fieldDate);
        click(dateSelected);
        waitForElementAndClick(applyDate);
        Assert.assertEquals(optionDate,getAttributeValue(fieldDate));
    }
    public void selectDateAndSearch(By locatorOptionDate, String optionDate){
        click(fieldDate);
        click(locatorOptionDate);
        waitForElementAndClick(applyDate);
        Assert.assertEquals(optionDate, getAttributeValue(fieldDate));
        click(btnSearch);
    }

    public void enterPassengersAdultsAndSearch(int quant){
        click(fieldPassengers);
        for (int i = 0; i < quant; i++) {
            click(btnSumarAdultos);
        }
        click(btnApplyPassengers);
        Assert.assertEquals(quant + 1, Integer.parseInt(getAttributeValue(cantPassengers)));
        click(btnSearch);
    }

    public void buyVehicle(){
        click(localizadorBtnComprar);
    }

    public void selectCard(){
        click(localizadorBtnTarjeta);
        waitForElementAndClick(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[2]/div[1]"));
        waitForElementAndClick(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[3]/div[1]"));
        waitForElementAndClick(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[2]/h5[1]"));
    }

    public void changeCard(){
        click(btnChangeCard);
        waitForElementAndClick(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[1]/div[1]"));
        waitForElementAndClick(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[2]/div[1]"));
        waitForElementAndClick(By.xpath("//payment-option-selector[1]/div[2]/ul[1]/li[2]/h5[1]"));
    }

    public void changeToUSD(){
        Select menu = getSelect(locatorSelect);
        menu.selectByVisibleText("Dólares");
    }

    public void enterNameAndLastname(String name, String lastname){
        click(fieldName);
        setText(fieldName,name);
        setText(fieldLastName,lastname);
        Assert.assertEquals(name, getAttributeValue(fieldName));
        Assert.assertEquals(lastname, getAttributeValue(fieldLastName));
    }

    public void checkboxAccept(){
        click(checkbox);
        Assert.assertTrue(getAttributeClass(checkboxToValidate).contains("ng-valid"));
    }
}
