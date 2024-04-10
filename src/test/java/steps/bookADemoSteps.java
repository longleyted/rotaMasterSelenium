package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverManager;
import org.apache.log4j.*;


public class bookADemoSteps extends DriverManager {

    WebDriver chromeDriver;

    bookADemoPage bookADemoPage;

    homePage homePage;

    private static final Logger LOG = LogManager.getLogger(bookADemoSteps.class);


    public bookADemoSteps(){
        this.chromeDriver = getWebDriver();
        bookADemoPage = new bookADemoPage(this.chromeDriver);
        homePage = new homePage(this.chromeDriver);
    }

    @And("I navigate to book a demo")
    public void iNavigateToBookADemo() {
        homePage.navigateToBookADemoPage();
        LOG.info("Navigating to book a demo page");
    }

    @And("I assert book a demo page old")
    public void iAssertBookADemoPageOld() {
        bookADemoPage.assertBookADemoPage();
        LOG.info("Book a demo page visible");
    }

    @And("I assert book a demo page")
    public void iAssertBookADemoPage() throws InterruptedException {
        Thread.sleep(3000);
        bookADemoPage.assertBookADemoPage();
        LOG.info("Book a demo page visible");
    }

    @And("I enter a first name")
    public void iEnterAFirstName() {
        bookADemoPage.enterFirstName();
        LOG.info("Entering a first name");
    }

    @And("I enter a last name")
    public void iEnterALastName() {
        bookADemoPage.enterLastName();
        LOG.info("Entering a last name");
    }

    @And("I click on request demo")
    public void iClickOnRequestDemo() {
        bookADemoPage.clickRequestDemoButton();
        LOG.info("Clicking request demo");
    }

    @Then("^I see the error message \"([^\"]*)\"$")
    public void iSeeAnErrorMessage(String error) {
        bookADemoPage.assertErrorMessage(error);
        LOG.info("Asserting: "+error+" is displayed");
    }

    @And("I enter an organisation name")
    public void iEnterAnOrganisationName() {
        bookADemoPage.enterOrganisationName();
        LOG.info("Entering an organisation name");
    }

    @And("I enter a valid email address")
    public void iEnterAValidEmailAddress(){
        bookADemoPage.enterValidEmailAddress();
        LOG.info("Entering an email address");
    }

    @And("I enter an invalid email address")
    public void iEnterAnInvalidEmailAddress(){
        bookADemoPage.enterInvalidEmailAddress();
        LOG.info("Entering an email address");
    }

    @And("I enter a phone number")
    public void iEnterAPhoneNumber(){
        bookADemoPage.enterPhoneNumber();
        LOG.info("Entering a phone number");
    }

    @And("I enter a message")
    public void iEnterAMessage() {
        bookADemoPage.enterMessage();
        LOG.info("Entering a message");
    }

    @Then("^I change amount of staff \"([^\"]*)\"$")
    public void iChangeNumberOfStaff(String amount) {
        bookADemoPage.clickNumberOfStaffBox();
        bookADemoPage.clickNumberOfStaff(amount);
    }
}
