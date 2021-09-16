package pom.grupo5.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pom.grupo5.base.SeleniumBase;
import pom.grupo5.pages.VFHomeTraslados;
import pom.grupo5.base.TestBase;

public class tc001_busquedaCampoIncompleto extends TestBase{

    final String TRASLADOS_URL = "https://www.viajesfalabella.cl/traslados/";
    final String placeToComplete = "Sheraton Pilar Hotel & Convention Center, Pilar, Provincia de Buenos Aires, Argentina";
    By fieldTo = By.xpath("//*[contains(@class, 'sbox-places-second')]");
    By localizadorTo = By.xpath("//span[contains(text(),'Sheraton Pilar Hotel & Convention Center, Pilar, P')]");
    By dateSelected = By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[4]/span[21]/span[1]");
    By localizadorAlerta = By.xpath("//span[contains(text(),'Ingresa un origen.')]");


    @Test
    public void atc01(){
        VFHomeTraslados trasladosPage = new VFHomeTraslados(driver, wait);
        trasladosPage.goToUrl(TRASLADOS_URL);
        trasladosPage.enterDataFieldTo("Sheraton Pilar",placeToComplete,localizadorTo);
        trasladosPage.selectDateAndSearch(dateSelected, "Mar, 21 sep 2021");

        Assert.assertEquals("https://www.viajesfalabella.cl/traslados",driver.getCurrentUrl());
        Assert.assertEquals("Ingresa un origen.", driver.findElement(localizadorAlerta).getText());
    }
}
