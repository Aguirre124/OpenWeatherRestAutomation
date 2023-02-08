package org.openweathermap.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import org.openweathermap.exceptions.AssertionsErrorMessages;
import org.openweathermap.questions.VerifySchema;
import org.openweathermap.questions.VerifyStatusCode;
import org.openweathermap.tasks.GetByCoordinates;
import org.openweathermap.tasks.Load;
import org.openweathermap.utils.resources.WebServicesEndPoints;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.openweathermap.exceptions.AssertionsErrorMessages.THE_SCHEMA_IS_NOT_EXPECTED;
import static org.openweathermap.exceptions.AssertionsErrorMessages.THE_STATUS_CODE_IS_NOT_EXPECTED;

public class GetInfoByLatitudeStepDefinition {

    @Given("load the data for the test")
    public void loadTheDataForTheTest(List<Map<String, String>> data) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(data.get(0))
        );
    }

    @When("use the service with the Latitude and Longitude parameters")
    public void useTheServiceWithTheLatitudeAndLongitudeParameters() {
        theActorInTheSpotlight().attemptsTo(
                GetByCoordinates.service(WebServicesEndPoints.URI.getUrl())
        );


    }
    @Then("see the status code is {int}")
    public void seeTheStatusCodeIs(int responseCode) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifyStatusCode.is(responseCode))
                .orComplainWith(AssertionsErrorMessages.class, THE_STATUS_CODE_IS_NOT_EXPECTED));
    }

    @Then("validate the schema response {string}")
    public void validateTheSchemaResponse(String schemaResponse) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerifySchema.isExpected(schemaResponse))
                .orComplainWith(AssertionsErrorMessages.class, THE_SCHEMA_IS_NOT_EXPECTED));
    }
}
