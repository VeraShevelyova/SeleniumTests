package selenium_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium_tests.pages.HomePage;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    homepage.setJob("Test");
    homepage.setLocation("Krakow, Poland");
    homepage.clickSearch();
    homepage.waitUntilResultsLoad();
    Assert.assertTrue(homepage.areAnyResults());
  }

  @Test
  public void testInvalidVacancy() {
    driver.get(baseUrl);
    homepage.setJob("XXX");
    homepage.clickSearch();
    homepage.waitUntilResultsLoad();
    Assert.assertFalse(homepage.areAnyResults());
    Assert.assertTrue(homepage.isEmptyListResultsSentensePresent());
  }

}
