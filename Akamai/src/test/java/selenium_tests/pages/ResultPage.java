package selenium_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Vera on 30.10.2016.
 */
public class ResultPage extends Page {

    public ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.ID, using = "job_results_list_hldr")
    @CacheLookup
    public WebElement jobsContainer;

    @FindBy(how = How.ID, using = "job_no_results_list_hldr")
    @CacheLookup
    public WebElement emptyJobsList;
}
