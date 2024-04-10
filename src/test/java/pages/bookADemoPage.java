package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.Assert;
import utils.DriverManager;
import helpers.*;

public class bookADemoPage extends DriverManager {

    pagesHelper pagesHelper;

    WebDriver chromeDriver;

    public bookADemoPage(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        pagesHelper = new pagesHelper(this.chromeDriver);
        PageFactory.initElements(this.chromeDriver, this);
    }

    @FindBy(xpath = "//*[@id=\"gform_wrapper_2\"]/div[2]/p")
    @CacheLookup
    WebElement indicatesRequiredFields;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div/div/form/div[1]/div/fieldset[1]/div/span[1]/input")
    WebElement firstNameTextBox;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div/div/form/div[1]/div/fieldset[1]/div/span[2]/input")
    WebElement secondNameTextBox;

    @CacheLookup
    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div/div/div/form/div[1]/div/div[1]/div/input")
    WebElement organisationNameTextBox;

    @CacheLookup
    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div/div/div/form/div[1]/div/div[3]/div/input")
    WebElement emailTextBox;

    @CacheLookup
    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div/div/div/form/div[1]/div/div[4]/div/input")
    WebElement phoneNumberTextBox;

    @CacheLookup
    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div/div/div/form/div[1]/div/div[5]/div/textarea")
    WebElement messageTextBox;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"gform_submit_button_2\"]")
    WebElement requestDemoButton;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div/div/form/div[1]/div/div[2]/div/select")
    WebElement numberOfStaffBox;


    public void assertBookADemoPage() { pagesHelper.isElementDisplayed(indicatesRequiredFields); }

    public void enterFirstName() { pagesHelper.sendText(firstNameTextBox, "This is some sample text"); }

    public void enterLastName(){ pagesHelper.sendText(secondNameTextBox, "This is some more sample text"); }

    public void clickRequestDemoButton(){
        pagesHelper.scrollToElement(requestDemoButton);
        pagesHelper.clickAnElement(requestDemoButton);
    }

    public void assertErrorMessage(String error){ Assert.assertTrue(pagesHelper.isTextDisplayed(error)); }

    public void enterOrganisationName() { pagesHelper.sendText(organisationNameTextBox, "This, again, is more text"); }

    public void enterValidEmailAddress(){ pagesHelper.sendText(emailTextBox, "yetAgainMore@Text.com"); }

    public void enterInvalidEmailAddress(){ pagesHelper.sendText(emailTextBox, "yetAgainMoreText.com"); }

    public void enterPhoneNumber(){ pagesHelper.sendText(phoneNumberTextBox, "123"); }

    public void enterMessage() { pagesHelper.sendText(messageTextBox, "This is text"); }

    public void clickNumberOfStaffBox() { pagesHelper.clickAnElement(numberOfStaffBox);
    }

    public void clickNumberOfStaff(String amount) {
        pagesHelper.clickAnElement(pagesHelper.getElementByText(amount));
    }
}
