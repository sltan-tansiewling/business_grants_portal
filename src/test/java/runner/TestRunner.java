package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

// @RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Features/ContactDetailsSection.feature"},
        plugin = {"html:target/cucumber-reports"},
        glue = "Steps")
public class TestRunner extends AbstractTestNGCucumberTests {
}
