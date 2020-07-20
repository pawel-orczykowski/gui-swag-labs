package gui_tests.step_defs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucumber_scenarios",
        plugin = {"pretty", "html:target/CucumberReport", "json:target/CucumberReport.json"},
        glue = "gui_tests",
        strict = true,
        monochrome = true
)

public class TestRunner { };
