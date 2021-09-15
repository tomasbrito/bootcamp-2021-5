package pom.grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo4.page.VFHomePage;
import pom.grupo4.base.TestBase;
import pom.grupo4.pages.VFPaquetesPage;
import pom.grupo4.pages.VFTrasladosPage;

public class atc05_realizarBusquedaSinIngresarEdad extends TestBase {

    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String TRASLADOS_URL = "https://www.viajesfalabella.cl/traslados";
    final String mensajeError = "Ingresa la edad del menor";


    @Test
    public void atc05(){

        VFTrasladosPage trasladosPage = new VFTrasladosPage(driver);
        trasladosPage.goToUrl(BASE_URL);
        trasladosPage.goToUrl(TRASLADOS_URL);
        Assert.assertEquals(TRASLADOS_URL, trasladosPage.getUrl());
        trasladosPage.clickearBotonPasajeros();
        trasladosPage.clickearAñadirMenor();
        trasladosPage.clickearBotonAplicarPasajeros();
        Assert.assertEquals(mensajeError, trasladosPage.getMensajeError());

    }



}
