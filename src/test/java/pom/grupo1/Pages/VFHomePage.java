package pom.grupo1.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.grupo1.base.SeleniumBase;

public class VFHomePage extends SeleniumBase {

    public VFHomePage(WebDriver driver) {
        super(driver);
    }

    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String ALOJAMIENTOS_URL = "https://www.viajesfalabella.cl/hoteles/";
    final String VUELOS_URL = "https://www.viajesfalabella.cl/vuelos/";

    By btnAlojamientos = By.xpath("//a[@product=\"HOTELS\"]");
    By btnVuelos = By.xpath("//a[@product=\"FLIGHTS\"]");

    public void goToHome(){
        goToUrl(BASE_URL);
        Assert.assertEquals(BASE_URL, getCurrentUrl());
    }

    public void goToAlojamientos(){
        click(btnAlojamientos);
        Assert.assertEquals(ALOJAMIENTOS_URL, getCurrentUrl());
    }

    public void goToVuelos(){
        click(btnVuelos);
        Assert.assertEquals(VUELOS_URL, getCurrentUrl());
    }

}
