package com.sophossolutions.stepdefinitions;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

import com.sophossolutions.tasks.ExecutePatchToken;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
public class PatchGorestStepDefinitions {

    @When("consulta en el endpoint {string} por id {string} y propociona la informacion")
    public void consultaEnElEndpointPorIdYPropocionaLaInformacion(String endpoint, String id, DataTable userInformation) {
        theActorInTheSpotlight().attemptsTo(ExecutePatchToken.modifyUser(endpoint.concat(id), userInformation));
    }

    @Then("valida que la respuesta tenga el nombre {string} y el status {string} y el status code sea {int}")
    public void validaQueLaRespuestaTengaElNombreYElStatusYElStatusCodeSea(String name, String status, Integer statusCode) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(statusCode)
                .body("name", equalTo(name)).body("status", equalTo(status))));
    }
}
