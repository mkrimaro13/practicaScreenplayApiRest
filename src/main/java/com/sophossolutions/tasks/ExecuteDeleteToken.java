package com.sophossolutions.tasks;
import com.sophossolutions.constants.ApiConstants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class ExecuteDeleteToken implements Task {
    private final String endpoint;
    private final String id;

    public ExecuteDeleteToken (String endpoint, String id){
        this.endpoint = endpoint;
        this.id = id;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(endpoint.concat(id)).with(
                request -> request.auth().oauth2(ApiConstants.TOKEN)
        ));
    }

    public static ExecuteDeleteToken deleteToken (String endpoint, String id){
        return Tasks.instrumented(ExecuteDeleteToken.class, endpoint, id);
    }
}
