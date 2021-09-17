package pom.grupo5.test;

import org.junit.Assert;
import org.junit.Test;
import pom.grupo5.base.TestBase;
import pom.grupo5.pages.VFHomePaquetes;
import pom.grupo5.pages.VFReservaPaquetes;

public class tc012_reservaPaqueteDesdeHome extends TestBase {
    final String url = "https://www.viajesfalabella.cl/";

    @Test
    public void tc012() throws InterruptedException {
        VFHomePaquetes homePagePaquetes = new VFHomePaquetes(driver,wait);
        homePagePaquetes.goToUrl(url);
        homePagePaquetes.seleccionarOferta(6);
        Assert.assertEquals("Lun, 6 dic 2021",homePagePaquetes.seleccionarFecha("idaCalendarioLateral","6","12","2021"));
        Assert.assertEquals("Jue, 16 dic 2021",homePagePaquetes.seleccionarFecha("vueltaCalendarioLateral","16","12","2021"));
        Thread.sleep(2000);
        homePagePaquetes.seleccionarCantidadDeAdultos(1);
        homePagePaquetes.realizarBusqueda();
        Thread.sleep(2000);
        homePagePaquetes.seleccionarAlojamientoSugerido();
        Thread.sleep(2000);
        homePagePaquetes.switchWindows();
        String urlNuevaPestaña = homePagePaquetes.getUrl();
        Assert.assertTrue(urlNuevaPestaña.contains("trip/accommodations/detail"));
        VFReservaPaquetes pageReservaPaquetes = new VFReservaPaquetes(driver,wait);
        Thread.sleep(2000);
        Assert.assertEquals("Esplendor by Wyndham Cervantes", driver.getTitle());
        pageReservaPaquetes.seleccionarHabitacion(2);
        pageReservaPaquetes.seleccionarVueloSugerido(1);
        pageReservaPaquetes.quitarTrasladoDefault();
        pageReservaPaquetes.agregarTraslado(2);
        Thread.sleep(2000);
        pageReservaPaquetes.seleccionarVerViaje();
    }
}
