package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/main/resources/features/login.feature",
        glue = "stepsdef",
        tags = "@happyScenarios",
        plugin = {"pretty", "html:target/cucumber-reports/login.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
