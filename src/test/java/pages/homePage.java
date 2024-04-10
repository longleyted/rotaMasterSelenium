package pages;

import org.openqa.selenium.support.*;
import org.openqa.selenium.*;
import utils.DriverManager;
import helpers.*;


public class homePage extends DriverManager {

    pagesHelper pagesHelper;

    WebDriver chromeDriver;

    public homePage(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        pagesHelper = new pagesHelper(this.chromeDriver);
        PageFactory.initElements(this.chromeDriver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Book a demo')]")
    @CacheLookup
    WebElement bookADemoButton;

    public void navigateToBookADemoPage(){ pagesHelper.clickAnElement(bookADemoButton); }
}
