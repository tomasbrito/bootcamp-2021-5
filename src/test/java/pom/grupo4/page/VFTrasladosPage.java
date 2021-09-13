package pom.grupo4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.grupo4.base.SeleniumBase;

public class VFTrasladosPage extends SeleniumBase {

    By inputPasajeros = By.xpath("//body[1]/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[9]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]");

    public VFTrasladosPage(WebDriver driver) {
        super(driver);
    }

    public void clickPasajero() {

        click(inputPasajeros);
    }
}

