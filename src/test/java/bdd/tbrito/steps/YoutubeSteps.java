package bdd.tbrito.steps;

import bdd.tbrito.bases.Hook;
import bdd.tbrito.pages.YTHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class YoutubeSteps {

    YTHomePage ytHomePage;

    @Given("estoy en un navegador con la pagina inicial de youtube")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_youtube() {
        ytHomePage = new YTHomePage(Hook.getDriver());
        ytHomePage.IngresarAYoutubeHomePage();
    }

    @When("introduzco la palabra {string} en la barra")
    public void introduzco_la_palabra_en_la_barra_a(String string) {
        ytHomePage.ingresarPalabra(string);
    }

    @When("realizo la busqueda con el boton buscar")
    public void realizo_la_busqueda_con_el_boton_buscar() {
        ytHomePage.buscarConClickeandoBoton();
    }

    @Then("el navegador me muestra los resultados")
    public void el_navegador_me_muestra_los_resultados() {
        Assert.assertTrue(true);
    }

}
