package pom.grupo5.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo5.base.TestBase;
import pom.grupo5.pages.VFHomePaquetes;

public class tc010_busquedaPaqueteVueloMasAuto extends TestBase {
    final String url = "https://www.viajesfalabella.cl/";
    final  String origen ="Buenos Aires";
    final  String destino ="Bariloche";

    @Test
    public void tc_010(){
        VFHomePaquetes homePagePaquetes = new VFHomePaquetes(driver,wait);
        homePagePaquetes.goToUrl(url);
        homePagePaquetes.seleccionarBtn("VueloMasAuto");
        Assert.assertEquals("Buenos Aires, Ciudad de Buenos Aires, Argentina",homePagePaquetes.ingresarCiudadOrigen(origen));
        Assert.assertEquals("San Carlos de Bariloche, Rio Negro, Argentina",homePagePaquetes.ingresarCiudadDestino(destino,1));
        Assert.assertEquals("Lun, 6 dic 2021",homePagePaquetes.seleccionarFecha("ida","6","12","2021"));
        Assert.assertEquals("Jue, 16 dic 2021",homePagePaquetes.seleccionarFecha("vuelta","16","12","2021"));
        homePagePaquetes.realizarBusqueda();
        homePagePaquetes.waitUrlContains("/trip/flight/");
        Assert.assertTrue(homePagePaquetes.urlContains("/trip/flight/"));
    }
}
