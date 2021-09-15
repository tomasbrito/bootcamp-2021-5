package bdd.mentoria.steps;


import bdd.mentoria.bases.Hook;
import bdd.mentoria.pages.GHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GoogleSteps {

    //atributos
    GHomePage gHomePage;


    @Given("estoy en un navegador con la pagina inicial de google")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_google() {
        gHomePage = new GHomePage(Hook.getDriver());
        gHomePage.IngresarAGoogleHomePage();

    }

    @When("introduzco la palabra {string} en la barra")
    public void introduzco_la_palabra_en_la_barra(String string) {
        gHomePage.ingresarPalabraABuscarEnBarraGoogle(string);
    }

    @When("realizo la busqueda con Enter")
    public void realizo_la_busqueda_con_enter() {
        gHomePage.busquedaConBotonEnterEnBarraDeGoogle();
    }

    @Then("el navegador me muestra los resultados")
    public void el_navegador_me_muestra_los_resultados() {
        Assert.assertTrue(true);
    }

    @When("realizo la busqueda con el boton {string}")
    public void realizo_la_busqueda_con_el_boton(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
