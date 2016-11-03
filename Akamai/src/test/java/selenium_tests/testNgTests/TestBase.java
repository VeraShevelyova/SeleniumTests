package selenium_tests.testNgTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import selenium_tests.util.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class TestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
    //WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
  }

  @BeforeMethod
  public void initWebDriver() {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    driver =  WebDriverFactory.getDriver(gridHubUrl, capabilities);
  }

  @AfterMethod
  public void afterMethod() {
    driver.quit();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown(){
    WebDriverFactory.dismissAll();
  }
}
