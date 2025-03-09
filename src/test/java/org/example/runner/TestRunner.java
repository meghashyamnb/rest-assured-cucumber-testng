package org.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/org/example/runner/features/spotify_api.feature",
        glue = {"org.example.steps"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports/CucumberTestReport.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
