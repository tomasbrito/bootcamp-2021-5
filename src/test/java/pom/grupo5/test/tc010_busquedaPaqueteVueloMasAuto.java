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
        Assert.assertEquals("Buenos Aires, Ciudad de Buenos Aires, Argentina",homePagePaquetes.ingresarCiudadOrigen(origen));
        Assert.assertEquals("San Carlos de Bariloche, Rio Negro, Argentina",homePagePaquetes.ingresarCiudadOrigen(destino));
        //TODO Seleccionar fecha ida --> Falta desarrollarlo en VFHomePaquetes
        Assert.assertEquals("Lun, 6 dic 2021",homePagePaquetes.seleccionarFechaIda("6","12","2021"));
        //TODO Seleccionar fecha vuelta --> Falta desarrollarlo en VFHomePaquetes
        Assert.assertEquals("Jue, 16 dic 2021",homePagePaquetes.seleccionarFechaVuelta("16","12","2021"));
        homePagePaquetes.aplicarFecha();
        homePagePaquetes.realizarBusqueda();
        homePagePaquetes.esperarUrlContains("/trip/flight/");
        Assert.assertTrue(homePagePaquetes.urlContains("/trip/flight/"));
    }
}
