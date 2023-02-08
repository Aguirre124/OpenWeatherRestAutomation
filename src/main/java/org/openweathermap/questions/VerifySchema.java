package org.openweathermap.questions;

import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class VerifySchema implements Question<Boolean> {

    private final String schema;

    public VerifySchema(String schema) {
        this.schema = schema;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(ResponseConsequence.seeThatResponse("schema",
                response -> response.assertThat()
                        .body(JsonSchemaValidator
                                .matchesJsonSchemaInClasspath("schemas/" + schema + ".json"))));
        return true;
    }

    public static VerifySchema isExpected(String schemaResponse) {
        return new VerifySchema(schemaResponse);
    }
}
