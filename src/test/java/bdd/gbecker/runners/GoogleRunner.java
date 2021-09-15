package bdd.gbecker.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/bdd/gbecker/features"},
        glue = {"bdd.mentoria.steps","bdd.mentoria.bases"},
        plugin = {"pretty"},
        tags = "@testfalso"
)
public class GoogleRunner {


}
