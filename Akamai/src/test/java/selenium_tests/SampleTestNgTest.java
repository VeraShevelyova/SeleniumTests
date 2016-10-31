package selenium_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium_tests.pages.HomePage;
import selenium_tests.pages.ResultPage;

import java.awt.*;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;
  private ResultPage resultPage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
    resultPage = PageFactory.initElements(driver, ResultPage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    homepage.findJobsTextBox.sendKeys("Test");
    homepage.locationDiv.click();
    WebElement textBox = homepage.locationList.findElement(By.className("default"));
    Actions actions = new Actions(driver);
    actions.moveToElement(textBox);
    actions.sendKeys("Krakow, Poland");
    Action modifierkey = actions.sendKeys("\uE007").build();
    modifierkey.perform();
    homepage.searchButton.click();
    Assert.assertNotNull(resultPage.jobsContainer);
    Assert.assertNotNull(resultPage.emptyJobsList);
  }

  @Test
  public void testInvalidVacancy() {
    driver.get(baseUrl);
    homepage.findJobsTextBox.sendKeys("XXX");
    homepage.searchButton.click();
    //Assert.asser(resultPage.emptyJobsList.);
  }

}
