package org.openweathermap.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openweathermap.interactions.ExecuteGet;

public class ConsumeGet implements Task {

    private final String resource;

    public ConsumeGet(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGet.service(resource));
    }

    public static ConsumeGet service(String resource) {
        return Tasks.instrumented(ConsumeGet.class, resource);
    }
}
