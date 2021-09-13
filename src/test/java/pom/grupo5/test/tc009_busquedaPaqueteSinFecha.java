package pom.grupo5.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo5.base.TestBase;
import pom.grupo5.pages.VFHomePaquetes;

public class tc009_busquedaPaqueteSinFecha extends TestBase {
    final String url = "https://www.viajesfalabella.cl/";
    final  String origen ="Buenos Aires";
    final  String destino ="Isla de Pascua";

    @Test
    public void tc009 () throws InterruptedException {
        VFHomePaquetes homePagePaquetes = new VFHomePaquetes(driver,wait);
        homePagePaquetes.goToUrl(url);
        Assert.assertEquals("Buenos Aires, Ciudad de Buenos Aires, Argentina",homePagePaquetes.ingresarCiudadOrigen(origen));
        Assert.assertEquals("Isla de Pascua, Valparaíso, Chile",homePagePaquetes.ingresarCiudadDestino(destino,1));
        homePagePaquetes.seleccionarBtn("TodaviaNoElegiFecha");
        homePagePaquetes.realizarBusqueda();
        homePagePaquetes.waitUrlContains("paquetes-a-isla-de-pascua-desde-buenos-aires");
        Assert.assertTrue(homePagePaquetes.urlContains("paquetes-a-isla-de-pascua-desde-buenos-aires"));
    }

}
