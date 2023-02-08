package org.openweathermap.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/getInfoByCityName.feature",
        glue = {
                "org.openweathermap.stepdefinitions.hook",
                "org.openweathermap.stepdefinitions"
        }
)
public class GetInfoByCityName {
}
