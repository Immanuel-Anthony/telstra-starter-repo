package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// This tells JUnit to run the Cucumber tests
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",   // Path to your .feature files
        glue = "stepDefinitions",                  // Path to your step definitions
        plugin = {"pretty", "html:target/cucumber-report.html"}  // Optional: Generates a report
)
public class CucumberTestRunner {
}
