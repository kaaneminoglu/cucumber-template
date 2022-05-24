package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/"},
        glue = {"classpath:steps"},
        monochrome = true,
        plugin = {
                "pretty:target/reports/prettyReport.txt",
                "html:target/reports/HtmlReport.html",
                "json:target/reports/cucumber.json"
        }
)

public class TestRunner {
}
