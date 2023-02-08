package org.openweathermap.stepdefinitions;

import io.cucumber.java.en.When;
import org.openweathermap.tasks.GetByCityName;
import org.openweathermap.tasks.GetByCoordinates;
import org.openweathermap.utils.resources.WebServicesEndPoints;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetInfoByCityNameStepDefinition {

    @When("use the service with the name of the city as a parameter")
    public void useTheServiceWithTheNameOfTheCityAsAParameter() {
        theActorInTheSpotlight().attemptsTo(
                GetByCityName.service(WebServicesEndPoints.URI.getUrl())
        );
    }
}
