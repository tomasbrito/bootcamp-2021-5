package pom.grupo5.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pom.grupo5.base.TestBase;
import pom.grupo5.pages.VFHomeTraslados;

public class tc003_busquedaCambioTarjeta extends TestBase {
    final String TRASLADOS_URL = "https://www.viajesfalabella.cl/traslados/";
    final String placeCompleteFrom = "Aeropuerto La Guardia, Nueva York, Estados Unidos";
    final String placeCompleteTo = "Seaport Hotel Boston, Seaport Lane, Boston, Massachusetts, EE. UU.";

    By localizadorFrom = By.xpath("//span[contains(text(),'Aeropuerto La Guardia, Nueva York,')]");
    By localizadorTo = By.xpath("//span[contains(text(),'Seaport Hotel Boston, Seaport Lane, Boston, Massac')]");
    By localizadorFecha = By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[4]/span[16]/span[1]");
    By localizadorCard = By.xpath("//h6[contains(text(),'Visa Banco Santander')]");
    By localizadorCard2 = By.xpath("//h6[contains(text(),'Visa Banco Falabella')]");

    @Test
    public void tc03(){
        VFHomeTraslados trasladosPage = new VFHomeTraslados(driver, wait);
        trasladosPage.goToUrl(TRASLADOS_URL);
        trasladosPage.enterDataFieldFrom("New",placeCompleteFrom,localizadorFrom);
        trasladosPage.enterDataFieldTo("Sea",placeCompleteTo,localizadorTo);
        trasladosPage.selectDateAndSearch(localizadorFecha,"Jue, 16 sep 2021");
        trasladosPage.waitUrlContains("search");
        trasladosPage.buyVehicle();
        trasladosPage.waitUrlContains("checkout");
        trasladosPage.selectCard();
        Assert.assertTrue(trasladosPage.getText(localizadorCard).contains("Santander"));
        trasladosPage.changeCard();
        Assert.assertTrue(trasladosPage.getText(localizadorCard2).contains("Falabella"));
    }


}
