package selenium_tests.stepDefinitions;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import ru.stqa.selenium.factory.WebDriverFactory;
import selenium_tests.pages.JobsPage;
import selenium_tests.util.PropertyLoader;

import java.io.IOException;

public class ParentScenario {

    protected WebDriver driver;
    protected static String gridHubUrl;
    protected static String baseUrl;
    protected static Capabilities capabilities;

    protected JobsPage jobsPage;

    protected void startBrowser(String baseUrl) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = WebDriverFactory.getDriver(capabilities);
        jobsPage = PageFactory.initElements(driver, JobsPage.class);
    }

    protected void closeBrowser() {
        driver.quit();
    }

        protected   void initTestSuite() throws IOException {
        baseUrl = PropertyLoader.loadProperty("site.url");
        gridHubUrl = PropertyLoader.loadProperty("grid.url");
        if ("".equals(gridHubUrl)) {
            gridHubUrl = null;
        }
        capabilities = PropertyLoader.loadCapabilities();
        //WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    }
}