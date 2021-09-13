package pom.grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo4.page.VFHomePage;
import pom.grupo4.base.TestBase;
import pom.grupo4.page.VFTrasladosPage;

public class tc005realizarBusquedaSinIngresarEdad extends TestBase {

    final String BASE_URL = "https://www.viajesfalabella.cl/";


    @Test
    public void tc5(){

        VFHomePage homePage = new VFHomePage(driver);
        homePage.goToUrl(BASE_URL);
        homePage.irATraslados();
        VFTrasladosPage trasladosPage = new VFTrasladosPage(driver);
        Assert.assertEquals(BASE_URL + "traslados/", trasladosPage.getUrl());

    }



}
