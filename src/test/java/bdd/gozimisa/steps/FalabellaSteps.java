package bdd.gozimisa.steps;

import bdd.earaya.bases.AppHook;
import io.cucumber.java.en.*;
import pom.grupo2.pages.VFHomePage;

public class FalabellaSteps {
    VFHomePage homePage;

    @Given("estoy en un navegador con la pagina inicial de viajes falabella en la seccion Vuelo Auto")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_viajes_falabella_en_la_seccion_vuelo_auto() {
        homePage= new VFHomePage(AppHook.getDriver());
        homePage.goToUrl("https://www.viajesfalabella.cl/");
        homePage.irVueloAuto();
    }

    @When("introduzco la palabra {string} en la barra de origen")
    public void introduzco_la_palabra_en_la_barra_de_origen(String string) {
        homePage.escribirEnOrigenYSeleccionar(string);
    }

    @When("introduzco la palabra {string} en la barra de destino")
    public void introduzco_la_palabra_en_la_barra_de_destino(String string) {
        homePage.escribirEnDestinoYSeleccionar(string);
    }

    @When("realizo la busqueda aprentando el boton buscar")
    public void realizo_la_busqueda_aprentando_el_boton_buscar() {
        homePage.buscar();
    }

    @Then("el navegador me muestra un mensaje en los campos de fecha")
    public void el_navegador_me_muestra_un_mensaje_en_los_campos_de_fecha() {
        homePage.validacionMensajFechas("Ingresa una fecha de partida.","Ingresa una fecha de regreso.");
    }
}
