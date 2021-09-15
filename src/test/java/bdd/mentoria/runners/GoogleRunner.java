package bdd.mentoria.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/bdd/mentoria/features"},
        glue = {"bdd.mentoria.steps","bdd.mentoria.bases"},
        plugin = {"pretty"},
        tags = "@test"
)
public class GoogleRunner {
}
