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

    @When("seleccionar {string}")
    public void seleccionar(String string) {
        homePaquetes.seleccionarBtn(string);
    }

    @When("introduzco {string} en el campo origen")
    public void introduzco_en_el_campo_origen(String string) {
        homePaquetes.ingresarCiudadOrigen(string);
    }

    @When("introduzco solo {int} destino {string} en el campo destino")
    public void introduzco_solo_destino_en_el_campo_destino(Integer int1, String string) {
        homePaquetes.ingresarCiudadDestino(string,int1);
    }


    @When("realizo la busqueda presionando el boton Buscar")
    public void realizo_la_busqueda_presionando_el_boton_buscar() {
        homePaquetes.realizarBusqueda();
    }

    @Then("el navegador me muestra los resultados de busqueda de paquetes a {string} desde {string}")
    public void el_navegador_me_muestra_los_resultados_de_busqueda_de_paquetes_a_desde(String string, String string2) {
        homePaquetes.waitUrlContains("paquetes-a-"+string+"-desde-"+string2);
        Assert.assertTrue(homePaquetes.urlContains("paquetes-a-"+string+"-desde-"+string2));
    }


    @When("seleccionar fecha ida {string} del {string} de {string}")
    public void seleccionar_fecha_ida_del_de(String string, String string2, String string3) {
       homePaquetes.seleccionarFecha("ida",string,string2,string3);
    }

    @When("seleccionar fecha vuelta {string} del {string} de {string}")
    public void seleccionar_fecha_vuelta_del_de(String string, String string2, String string3) {
        homePaquetes.seleccionarFecha("vuelta",string,string2,string3);
    }

    @Then("el navegador me muestra los resultados de busqueda de vuelos disponibles")
    public void el_navegador_me_muestra_los_resultados_de_busqueda_de_vuelos_disponibles() {
        homePaquetes.waitUrlContains("/trip/flight/");
        Assert.assertTrue(homePaquetes.urlContains("/trip/flight/"));
    }




}
