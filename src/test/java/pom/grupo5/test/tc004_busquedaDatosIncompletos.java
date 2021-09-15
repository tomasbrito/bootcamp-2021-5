package pom.grupo5.test;

import org.junit.Test;
import org.openqa.selenium.By;
import pom.grupo5.base.TestBase;
import pom.grupo5.pages.VFHomeTraslados;

public class tc004_busquedaDatosIncompletos extends TestBase{
    final String TRASLADOS_URL = "https://www.viajesfalabella.cl/traslados/";
    final String placeFromComplete = "Aeropuerto Internacional Miami, Miami, Estados Unidos";
    final String placeToComplete = "Sanibel Beach, Sanibel, Florida, EE. UU.";

    By LocalizadorTo = By.xpath("//span[contains(text(),'Sanibel Beach, Sanibel, Florida')]");
    By localizadorFrom = By.xpath("//body/div[7]/div[1]/div[1]/ul[1]/li[1]/span[1]");
    By localizadorFecha = By.xpath("//body[1]/div[3]/div[1]/div[5]/div[1]/div[4]/span[30]/span[1]");
    @Test
    public void test04() throws InterruptedException {
        VFHomeTraslados trasladosPage = new VFHomeTraslados(driver, wait);
        trasladosPage.goToUrl(TRASLADOS_URL);
        trasladosPage.enterDataFieldFrom("Mia",placeFromComplete,localizadorFrom);
        trasladosPage.enterDataFieldTo("San",placeToComplete,LocalizadorTo);
        trasladosPage.selectDateAndSearch(localizadorFecha,"Jue, 30 sep 2021");
        trasladosPage.waitUrlContains("search");
        trasladosPage.changeToUSD();
        trasladosPage.buyVehicle();
        trasladosPage.waitUrlContains("checkout");
        trasladosPage.enterNameAndLastname("Santiago","Espinoza");
        trasladosPage.checkboxAccept();
    }
}
