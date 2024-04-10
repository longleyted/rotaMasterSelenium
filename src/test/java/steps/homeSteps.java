package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverManager;
import org.apache.log4j.*;

public class homeSteps extends DriverManager {

    static WebDriver chromeDriver;
    homePage homePage;
    private static final Logger LOG = LogManager.getLogger(homeSteps.class);

    public homeSteps(){
        chromeDriver = getWebDriver();
        homePage = new homePage(chromeDriver);
    }

    @Given("I am on the rotaMaster website")
    public void iAmOnTheRotaMasterWebsite() {
        chromeDriver.get("https://rotamaster.co.uk");
        LOG.info("Navigating to rotamaster website");
     }

    public void tearDown() {
        chromeDriver.close();
        chromeDriver.quit();
    }

}
