package selenium_tests.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public void open(String url){
    driver.get(url);
  }
  public boolean isElementPresent(By by){
    try{
      driver.findElement(by);
      return true;
    }
    catch(NoSuchElementException e){
      return false;
    }
  }

  public WebElement fluientWaitforElement(WebElement element, int timoutSec, int pollingSec) {


    FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(timoutSec, TimeUnit.SECONDS)
            .pollingEvery(pollingSec, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class, TimeoutException.class).ignoring(StaleElementReferenceException.class);

    for (int i = 0; i < 2; i++) {
      try {
       // fWait.until(ExpectedConditions.visibilityOf(element));
        fWait.until(ExpectedConditions.elementToBeClickable(element));
      } catch (Exception e) {

        System.out.println("Element Not found trying again - " + element.toString().substring(70));
        e.printStackTrace();

      }
    }

    return element;

  }
}
