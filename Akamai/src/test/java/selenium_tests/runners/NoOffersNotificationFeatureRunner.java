package selenium_tests.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features/NoOffersNotification.feature",
        glue = "selenium_tests.stepDefinitions",
        format = {"pretty"})
public class NoOffersNotificationFeatureRunner extends AbstractTestNGCucumberTests {
}
