package pom.grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo4.base.TestBase;
import pom.grupo4.pages.VFTrasladosPage;

public class atc07_buscarTrasladoHaciaAeropuerto extends TestBase {
    final String BASE_URL = "https://www.viajesfalabella.cl/";
    final String PAQUETES_URL = "https://www.viajesfalabella.cl/traslados";
    final String URL_OBJETIVO = "https://www.viajesfalabella.cl/transfer/shopping/#!/search/oneway/airport/SCL/geo_place/ChIJRVH0jU7WYpYRIcPQyFFUXC4/27-09-2021/00:00/2";

    @Test
    public void atc05() throws InterruptedException {

        VFTrasladosPage trasladosPage = new VFTrasladosPage(driver);
        trasladosPage.goToUrl(BASE_URL);
        trasladosPage.goToUrl(PAQUETES_URL);
        Assert.assertEquals(PAQUETES_URL, trasladosPage.getUrl());
        trasladosPage.ingresarDatosInputDesde();
        trasladosPage.ingresarDatosInputHasta();
        trasladosPage.ingresarFecha();
        //trasladosPage.ingresarHora();
        trasladosPage.clickearBotonPasajeros();
        trasladosPage.clickearAñadirPasajeroMayor();
        trasladosPage.clickearBotonAplicarPasajeros();
        trasladosPage.clickearBotonBuscar();
        Assert.assertEquals(URL_OBJETIVO, trasladosPage.getUrl());


    }
}
