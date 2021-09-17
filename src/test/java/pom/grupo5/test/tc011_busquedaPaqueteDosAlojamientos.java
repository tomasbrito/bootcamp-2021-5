package pom.grupo5.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo5.base.TestBase;
import pom.grupo5.pages.VFHomePaquetes;

public class tc011_busquedaPaqueteDosAlojamientos extends TestBase {
    final String url = "https://www.viajesfalabella.cl/";
    final String origen = "Buenos Aires";
    final String destino1 = "Isla Mujeres";
    final String destino2 = "Cancun";

    @Test
    public void tc011 () {
        VFHomePaquetes homePagePaquetes = new VFHomePaquetes(driver,wait);
        homePagePaquetes.goToUrl(url);
        homePagePaquetes.seleccionarBtn("DosAlojamientos");
        // Ingreso Ciudad origen y destino
        Assert.assertEquals("Buenos Aires, Ciudad de Buenos Aires, Argentina",homePagePaquetes.ingresarCiudadOrigen(origen));
        Assert.assertEquals("Isla Mujeres, Quintana Roo, México",homePagePaquetes.ingresarCiudadDestino(destino1,1));
       // Selecciono Fecha ida y vuelta
        Assert.assertEquals("Lun, 4 oct 2021",homePagePaquetes.seleccionarFecha("ida","4","10","2021"));
        Assert.assertEquals("Sáb, 16 oct 2021",homePagePaquetes.seleccionarFecha("vuelta","16","10","2021"));
        // Seleccionamos fechas primer destino
        Assert.assertEquals("Lun, 4 oct 2021",homePagePaquetes.seleccionarFecha("desdeDestino1","4","10","2021"));
        Assert.assertEquals("Sáb, 9 oct 2021",homePagePaquetes.seleccionarFecha("hastaDestino1","9","10","2021"));
        //Seleccionamos segundo destino
        Assert.assertEquals("Cancún, Quintana Roo, México",homePagePaquetes.ingresarCiudadDestino(destino2,2));
        // Seleccionamos fechas segundo destino
        Assert.assertEquals("Sáb, 9 oct 2021",homePagePaquetes.seleccionarFecha("desdeDestino2","9","10","2021"));
        Assert.assertEquals("Sáb, 16 oct 2021",homePagePaquetes.seleccionarFecha("hastaDestino2","16","10","2021"));
        // Presionar boton Buscar
        homePagePaquetes.realizarBusqueda();
        homePagePaquetes.seleccionarBtn("VerResumen");
        // Validamos titulo resumen
        Assert.assertEquals("El resumen de tu viaje", homePagePaquetes.getResumenText());

    }

}
