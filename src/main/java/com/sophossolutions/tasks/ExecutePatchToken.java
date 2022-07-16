package com.sophossolutions.tasks;
import com.sophossolutions.constants.ApiConstants;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import org.apache.http.HttpHeaders;

import java.util.Map;

public class ExecutePatchToken implements Task  {
    private final String endpoint;
    private final Map<String, String> body;

    public ExecutePatchToken (String endpoint, DataTable body){//Recibe la tabla de valores, pero luego la convierte en un mapa
        this.endpoint = endpoint;
        this.body = body.asMap(String.class, String.class);//Es decir que recibe un mapa con llaves y valores de tipo String
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Patch.to(endpoint).with(request ->
                request.header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                        .auth().oauth2(ApiConstants.TOKEN).body(body)));
        SerenityRest.lastResponse().prettyPeek();
    }

    public static ExecutePatchToken modifyUser(String endpoint, DataTable body){
        return Tasks.instrumented(ExecutePatchToken.class, endpoint, body);
    }
}
