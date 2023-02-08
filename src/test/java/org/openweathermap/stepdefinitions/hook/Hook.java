package org.openweathermap.stepdefinitions.hook;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class Hook {

    private EnvironmentVariables environmentVariables;

    @Before
    public void configureBaseUrl() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
        String theRestApiBaseUrl = environmentVariables.optionalProperty("environments.qa.base.url")
                .orElse("https://api.openweathermap.org/data/2.5/");
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
}
