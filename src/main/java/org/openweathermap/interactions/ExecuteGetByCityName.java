package org.openweathermap.interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.openweathermap.models.TestData;

public class ExecuteGetByCityName implements Interaction {

    private final String cityName;

    public ExecuteGetByCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(cityName).with(
                        request -> request
                                .contentType(ContentType.JSON)
                                .queryParam("q", TestData.getData().get("city").toString())
                                .queryParam("appid", TestData.getData().get("apikey").toString())
                                .relaxedHTTPSValidation().log().all()
                )
        );
    }

    public static ExecuteGetByCityName service(String cityName) {
        return Tasks.instrumented(ExecuteGetByCityName.class, cityName);
    }
}
