package selenium_tests.stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;
import selenium_tests.util.PropertyLoader;

import java.io.IOException;


public class StepDefinitions extends ParentScenario {

    private boolean beforeAllDone = false;

    @Before
    public void beforeScenario() throws IOException {
        if(!beforeAllDone){
            initTestSuite();
            beforeAllDone = true;
        }

        startBrowser(baseUrl);
    }

    @Given("^Customer is on 'http://akamaijobs.referrals.selectminds.com/'$")
    public void I_am_on_the_Akamai_jobspage() {
        driver.get(baseUrl);
    }

    @When("^Customer specifies job title (.+)$")
    public void I_set_job(String job) {

        jobsPage.setJob(job);
    }

    @And("^Location (.+)$")
    public void I_set_location(String location) {
        jobsPage.setLocation(location);
    }

    @And("^clicks on 'Search'")
    public void I_click_search() {

        jobsPage.clickSearch();
        jobsPage.waitUntilResultsLoad();
    }

    @Then("^Any job offers are found$")
    public void any_job_offers_are_found() {
        Assert.assertTrue(jobsPage.areAnyResults(), "There aren't results");
    }

    @Then("^Notification about no offers found is displayed for (.+)$")
    public void no_job_offers_are_found(String searchKeyWorld) {
        Assert.assertFalse(jobsPage.areAnyResults(), "Empty results message is not displayed");
        Assert.assertTrue(jobsPage.isEmptyListResultsSentensePresent(searchKeyWorld), "No results message is is wrong");
    }

    @After
    public void afterScenario() {
        closeBrowser();
    }

}