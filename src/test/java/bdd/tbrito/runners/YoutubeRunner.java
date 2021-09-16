package bdd.tbrito.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/bdd/tbrito/"},
        glue = {"bdd.tbrito.steps","bdd.tbrito.bases"},
        plugin = {"pretty"},
        tags = "@test"
)
public class YoutubeRunner {
}
