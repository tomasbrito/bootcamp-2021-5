package bdd.lkelly.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/bdd/lkelly/features"},
                glue = {"bdd.lkelly.steps","bdd.lkelly.bases"},
                plugin ={"pretty"},
                tags = "@test")
public class VFPaqutesRunner {
}
