package selenium_tests.testNgTests;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium_tests.pages.JobsPage;

public class JobsSearchTest extends TestBase {

  private JobsPage jobsPage;

  @BeforeMethod
  public void initPageObjects() {
    jobsPage = PageFactory.initElements(driver, JobsPage.class);
  }

  @Test
  public void testSearchForExistedJob() {
    jobsPage.open(baseUrl);
    jobsPage.setJob("Test");
    jobsPage.setLocation("Krakow, Poland");
    jobsPage.clickSearch();
    jobsPage.waitUntilResultsLoad();
    Assert.assertTrue(jobsPage.areAnyResults(), "There are no results while they are expected");
  }

  @Test
  public void testCheckNoOffersMessage() {
    jobsPage.open(baseUrl);
    jobsPage.setJob("XXX");
    jobsPage.clickSearch();
    jobsPage.waitUntilResultsLoad();
    Assert.assertFalse(jobsPage.areAnyResults(), "There were job results");
    Assert.assertTrue(jobsPage.isEmptyListResultsSentensePresent("XXX"), "Message about empty jobs list is wrong");
  }

}
