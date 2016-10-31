package selenium_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class HomePage extends Page {

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

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }
}
