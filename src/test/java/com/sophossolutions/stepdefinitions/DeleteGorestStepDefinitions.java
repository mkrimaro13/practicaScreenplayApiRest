package com.sophossolutions.stepdefinitions;

import com.sophossolutions.tasks.ExecuteDeleteToken;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteGorestStepDefinitions {
    @When("consulta en el endpoint {string} por id {string} y elimina la informacion")
    public void consultaEnElEndpointPorIdYEliminaLaInformacion(String endpoint, String id) {
        theActorInTheSpotlight().attemptsTo(ExecuteDeleteToken.deleteToken(endpoint, id));
    }
    @Then("valida que el status code sea {int}")
    public void validaQueElStatusCodeSea(int status) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(status)));
    }
}

