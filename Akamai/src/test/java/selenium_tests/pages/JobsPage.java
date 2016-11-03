package selenium_tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class JobsPage extends Page {

  public final String emptyJobsListId = "job_no_results_list_hldr";
  public final String jobResultsContentClass = "jResultsActive";

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  @FindBy(how = How.ID, using = "keyword")
  @CacheLookup
  public WebElement findJobsTextBox;

  @FindBy(how = How.CLASS_NAME, using = "chzn-choices")
  @CacheLookup
  public WebElement locationList;

  @FindBy(how = How.ID, using = "jLocInputHldr")
  @CacheLookup
  public WebElement locationDiv;

  @FindBy(how = How.ID, using = "jSearchSubmit")
  @CacheLookup
  public WebElement searchButton;

  @FindBy(how = How.ID, using = emptyJobsListId)
  @CacheLookup
  public WebElement emptyJobsList;

  @FindBy(how = How.CLASS_NAME, using = jobResultsContentClass)
  @CacheLookup
  public WebElement filteredJobsResults;


  @FindBy(how = How.CLASS_NAME, using = "search_result_sentence")
  @CacheLookup
  public WebElement emptySearchResults;

  public JobsPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void setJob(String job){
    findJobsTextBox.sendKeys(job);
  }

  public void setLocation(String location){
    locationDiv.click();
    WebElement textBox = locationList.findElement(By.className("default"));
    Actions actions = new Actions(driver);
    actions.moveToElement(textBox);
    actions.sendKeys(location);
    // click enter in order to select element
    Action modifierKey = actions.sendKeys("\uE007").build();
    modifierKey.perform();
  }

  public void clickSearch(){
    searchButton.click();
  }

  public void waitUntilResultsLoad(){
    fluientWaitforElement(filteredJobsResults, 10, 1);
  }

  public Boolean areAnyResults(){
    return !isElementPresent(By.id(emptyJobsListId));
  }

  public Boolean isEmptyListResultsSentensePresent(String searchKeyWorld) {
    String emptyListResultMessage = String.format("Your search matching keyword(s) %s did not return any job results.", searchKeyWorld);
    Boolean isEmptyResultsSentencePresent = emptySearchResults.getText().equals(emptyListResultMessage);
    return isEmptyResultsSentencePresent;
  }
}
