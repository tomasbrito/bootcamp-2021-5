package bdd.gozimisa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/bdd/earaya/features"},
        glue = {"bdd.earaya.steps","bdd.earaya.bases"},
        plugin = {"pretty"},
        tags = "@test"
)
public class RunnerCucumber {
}
