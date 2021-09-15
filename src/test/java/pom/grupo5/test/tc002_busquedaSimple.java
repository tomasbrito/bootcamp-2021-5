package pom.grupo5.test;

import org.junit.Test;
import org.openqa.selenium.By;
import pom.grupo5.base.TestBase;
import pom.grupo5.pages.VFHomeTraslados;
import pom.grupo5.base.SeleniumBase;

import java.util.Date;

public class tc002_busquedaSimple extends TestBase {
    final String TRASLADOS_URL = "https://www.viajesfalabella.cl/traslados/";
    final String placeToComplete = "Cecil Hotel, South Main Street, Los Ángeles, California, EE. UU.";
    final String placeFromComplete = "Aeropuerto Southern California Logistics, Victorville, Estados Unidos";

    By localizadorTo = By.xpath("//span[contains(text(),'Cecil Hotel, South Main Street, Los Ángeles, Calif')]");
    By localizadorFrom = By.xpath("//span[contains(text(),'Aeropuerto Southern')]");
    By DateSelected = By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[4]/span[21]/span[1]");
    @Test
    public void test02() {
        VFHomeTraslados trasladosPage = new VFHomeTraslados(driver, wait);
        trasladosPage.goToUrl(TRASLADOS_URL);

        trasladosPage.enterDataFieldFrom("Cali",placeFromComplete,localizadorFrom);
        trasladosPage.enterDataFieldTo("Cecil",placeToComplete,localizadorTo);
        trasladosPage.selectDate("Mar, 21 sep 2021", DateSelected);
        trasladosPage.enterPassengersAdultsAndSearch(2);
        trasladosPage.waitUrlContains("search");

    }
}
