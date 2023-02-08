package org.openweathermap.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openweathermap.interactions.ExecuteGetByCityName;
import org.openweathermap.interactions.ExecuteGetByCoordinates;

public class GetByCityName implements Task {

    private final String resource;

    public GetByCityName(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGetByCityName.service(resource));
    }

    public static GetByCityName service(String resource) {
        return Tasks.instrumented(GetByCityName.class, resource);
    }
}
