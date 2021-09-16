package bdd.lkelly.steps;

import bdd.lkelly.bases.AppHook;
import bdd.lkelly.pages.VFHomePaquetes;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class VFPaquetesSteps  {
    VFHomePaquetes homePaquetes;
    String url = "https://www.viajesfalabella.cl/";

    @Given("estoy en un navegador con la pagina inicial de viajes falabella")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_viajes_falabella() {
        homePaquetes = new VFHomePaquetes(AppHook.getDriver(),AppHook.getWait());
        homePaquetes.goToUrl(url);
    }

    @When("introduzco {string} en el campo origen")
    public void introduzco_en_el_campo_origen(String string) {
        homePaquetes.ingresarCiudadOrigen(string);
    }

    @When("introduzco solo {int} destino {string} en el campo destino")
    public void introduzco_solo_destino_en_el_campo_destino(Integer int1, String string) {
        homePaquetes.ingresarCiudadDestino(string,int1);
    }

    @When("seleccionar Todavía no he decidido la fecha")
    public void seleccionar_todavía_no_he_decidido_la_fecha() {
        homePaquetes.seleccionarBtn("TodaviaNoElegiFecha");
    }


    @When("realizo la busqueda presionando el boton Buscar")
    public void realizo_la_busqueda_presionando_el_boton_buscar() {
        homePaquetes.realizarBusqueda();
    }

    @Then("el navegador me muestra los resultados")
    public void el_navegador_me_muestra_los_resultados() {
        homePaquetes.waitUrlContains("paquetes-a-isla-de-pascua-desde-buenos-aires");
        Assert.assertTrue(homePaquetes.urlContains("paquetes-a-isla-de-pascua-desde-buenos-aires"));
    }

}
