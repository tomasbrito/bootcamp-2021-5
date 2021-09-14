package pom.grupo5.test;

import org.junit.Test;
import org.openqa.selenium.By;
import pom.grupo5.base.TestBase;
import pom.grupo5.pages.VFHomeTraslados;
import pom.grupo5.base.SeleniumBase;

public class tc002_busquedaSimple extends TestBase {
    final String TRASLADOS_URL = "https://www.viajesfalabella.cl/traslados/";
    final String placeToComplete = "Cecil Hotel, South Main Street, Los Ángeles, California, EE. UU.";
    final String placeFromComplete = "Aeropuerto Southern California Logistics, Victorville, Estados Unidos";

    By fieldTo = By.xpath("//*[contains(@class, 'sbox-places-second')]");
    By fieldFrom = By.xpath("//*[contains(@class, 'sbox-places-first places-inline')]");
    By localizadorFrom = By.xpath("//span[contains(text(),'Aeropuerto Southern')]");
    By localizadorTo = By.xpath("//span[contains(text(),'Cecil Hotel, South Main Street, Los Ángeles, Calif')]");
    By FechaElegida = By.xpath("//body/div[3]/div[1]/div[5]/div[1]/div[4]/span[21]/span[1]");

    @Test
    public void test02() {
        VFHomeTraslados trasladosPage = new VFHomeTraslados(driver, wait);
        trasladosPage.goToUrl(TRASLADOS_URL);

        trasladosPage.enterDataFieldFrom(fieldFrom,"Cali",localizadorFrom,placeFromComplete);
        trasladosPage.enterDataFieldTo(fieldTo,"Cecil",localizadorTo,placeToComplete);
        trasladosPage.selectDate(FechaElegida,"Mar, 21 sep 2021");
        trasladosPage.enterPassengersAdultsAndSearch(2);
        trasladosPage.esperarUrlContains("search");

    }
}
