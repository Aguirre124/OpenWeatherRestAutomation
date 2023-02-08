package org.openweathermap.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openweathermap.interactions.ExecuteGetByCoordinates;

public class GetByCoordinates implements Task {

    private final String resource;

    public GetByCoordinates(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGetByCoordinates.service(resource));
    }

    public static GetByCoordinates service(String resource) {
        return Tasks.instrumented(GetByCoordinates.class, resource);
    }
}
