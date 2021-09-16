package bdd.gbecker.steps;

import bdd.earaya.bases.AppHook;
import bdd.earaya.pages.GoogleHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GoogleSteps {

        //atributos
        GoogleHomePage gHomePage;

        @Given("estoy en un navegador con la pagina inicial de google")
        public void estoy_en_un_navegador_con_la_pagina_inicial_de_google() {
            gHomePage = new GoogleHomePage(AppHook.getDriver());
            gHomePage.entrarAHomePage();
        }

        @When("introduzco la palabra {string} en la barra")
        public void introduzco_la_palabra_en_la_barra(String string) {
            gHomePage.busquedaSimpleBarraGoogle(string);
        }

        @When("realizo la busqueda con Enter")
        public void realizo_la_busqueda_con_enter() {
            gHomePage.presionarEnterABarraGoogle();
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

