package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Features"},
        plugin = {"html:target/cucumber-reports"},
        glue = "Steps")
public class TestRunner extends AbstractTestNGCucumberTests {
}
