package pom.grupo5.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.grupo5.base.SeleniumBase;

public class VFHomeTraslados extends SeleniumBase {

    public  VFHomeTraslados(WebDriver driver, WebDriverWait wait){super(driver, wait);}
    // Localizadores
    By fieldDate = By.xpath("//*[contains(@class, 'input-tag sbox-checkin')]");
    By applyDate = By.xpath("//body[1]/div[3]/div[1]/div[6]/div[2]/button[2]/em[1]");
    By fieldPassengers = By.xpath("//app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]");
    By btnApplyPassengers = By.xpath("//a[contains(text(),'Aplicar')]");
    By btnSearch = By.xpath("//em[contains(text(),'Buscar')]");
    By btnSumarAdultos = By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[2]");
    //Keyword Driven
    public void enterDataFieldFrom(By fieldFrom, String place, By placeSelected, String placeComplete){
        click(fieldFrom);
        tipear(place, fieldFrom);
        waitForElementAndClick(placeSelected);
        Assert.assertEquals(placeComplete,obtenerAtributoValue(fieldFrom));
    }
    public void enterDataFieldTo(By fieldTo, String place, By placeSelected, String placeComplete){
        click(fieldTo);
        tipear(place, fieldTo);
        waitForElementAndClick(placeSelected);
        Assert.assertEquals(placeComplete,obtenerAtributoValue(fieldTo));
    }
    public void selectDate(By locatorOptionDate, String optionDate){
        click(fieldDate);
        click(locatorOptionDate);
        waitForElementAndClick(applyDate);
        Assert.assertEquals(optionDate,obtenerAtributoValue(fieldDate));
    }
    public void selectDateAndSearch(By locatorOptionDate, String optionDate){
        click(fieldDate);
        click(locatorOptionDate);
        waitForElementAndClick(applyDate);
        click(btnSearch);
        Assert.assertEquals(optionDate, obtenerAtributoValue(fieldDate));
    }

    public void enterPassengersAdultsAndSearch(int quant){
        click(fieldPassengers);
        for (int i = 0; i < quant; i++) {
            click(btnSumarAdultos);
        }
        click(btnApplyPassengers);
        Assert.assertEquals(quant,obtenerAtributoValue(fieldPassengers));
        click(btnSearch);
    }
}
