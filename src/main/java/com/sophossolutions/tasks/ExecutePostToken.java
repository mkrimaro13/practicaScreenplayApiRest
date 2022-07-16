package com.sophossolutions.tasks;

import com.sophossolutions.constants.ApiConstants;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;

import java.util.Map;

public class ExecutePostToken implements Task {

    private String endpoint;
    private Map<String, String> body;

    public ExecutePostToken (String endpoint, DataTable body){//Recibe la tabla de valores, pero luego la convierte en un mapa
        this.endpoint = endpoint;
        this.body = body.asMap(String.class, String.class);//Es decir que recibe un mapa con llaves y valores de tipo String
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(endpoint).with(request ->
                request.header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                    .auth().oauth2(ApiConstants.TOKEN).body(body)));
        SerenityRest.lastResponse().prettyPeek();
    }

    public static ExecutePostToken createUser(String endpoint, DataTable body){
        return Tasks.instrumented(ExecutePostToken.class, endpoint, body);
    }

}
