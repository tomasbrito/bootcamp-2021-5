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
        Thread.sleep(2000);
        homePagePaquetes.seleccionarAlojamientoSugerido();
        Thread.sleep(2000);
        String urlNuevaPestaña = homePagePaquetes.getUrl();
        //cleanup();
        //Cambio Pestaña
        //setupBrowser();
        VFReservaPaquetes pageReservaPaquetes = new VFReservaPaquetes(driver,wait);
        //pageReservaPaquetes.goToUrl(urlNuevaPestaña);
        Thread.sleep(2000);
        Assert.assertEquals("Esplendor by Wyndham Cervantes", driver.getTitle());
        pageReservaPaquetes.seleccionarHabitacionSugerida();
        pageReservaPaquetes.seleccionarVueloSugerido();
        pageReservaPaquetes.quitarTrasladoDefault();
        pageReservaPaquetes.agregarTraslado("AutoPremium");
        Thread.sleep(2000);
        pageReservaPaquetes.seleccionarVerViaje();
    }
}
