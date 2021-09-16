package pom.grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo4.base.TestBase;
import pom.grupo4.pages.VFTrasladosPage;

public class atc08_cambiarTarjetaElegida extends TestBase{
        final String BASE_URL = "https://www.viajesfalabella.cl/";
        final String TRASLADOS_URL = "https://www.viajesfalabella.cl/traslados";
        final String URL_OBJETIVO = "https://www.viajesfalabella.cl/transfer/shopping/#!/search/roundtrip/airport/SCL/geo_place/";
        final String URL_FINAL = "https://www.viajesfalabella.cl/checkout/";
        final String MENSAJE_ESPERADO = "Visa Banco Santander";

        @Test
        public void atc08() throws InterruptedException {

            VFTrasladosPage trasladosPage = new VFTrasladosPage(driver);
            trasladosPage.goToUrl(BASE_URL);
            trasladosPage.goToUrl(TRASLADOS_URL);
            Assert.assertEquals(TRASLADOS_URL, trasladosPage.getUrl());
            trasladosPage.clickearCasillaHaciaElAeropuerto();
            trasladosPage.ingresarDatosInputDesde();
            trasladosPage.ingresarDatosInputHasta();
            trasladosPage.ingresarFechaHaciaElAeropuerto();
            trasladosPage.clickearBotonBuscar();
            Assert.assertTrue(URL_OBJETIVO, trasladosPage.urlContiene(trasladosPage.getUrl()));
            trasladosPage.clickearBotonComprarHaciaElAeropuerto();
            Assert.assertTrue(URL_FINAL, trasladosPage.urlContiene(trasladosPage.getUrl()));
            trasladosPage.clickearBotonSeleccionarTarjeta();
            trasladosPage.seleccionarTarjetaFalabella();
            trasladosPage.clickearBotonCambiarTarjeta();
            trasladosPage.seleccionarTarjetaSantander();
            Assert.assertEquals(MENSAJE_ESPERADO, trasladosPage.getTextoTarjetaFinal());

        }
}
