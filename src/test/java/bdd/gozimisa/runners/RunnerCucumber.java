package bdd.gozimisa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/bdd/gozimisa/features"},
        glue = {"bdd.gozimisa.steps","bdd.gozimisa.bases"},
        plugin = {"pretty"},
        tags = "@test"
)
public class RunnerCucumber {
}
