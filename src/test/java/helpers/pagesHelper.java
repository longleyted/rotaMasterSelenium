package helpers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import utils.DriverManager;

public class pagesHelper extends DriverManager {

    private static final Logger LOG = LogManager.getLogger(pagesHelper.class);

    WebDriver chromeDriver;

    private final long timeoutInSeconds;

    public pagesHelper(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(this.chromeDriver, this);
        timeoutInSeconds = 10;
    }

    public void clickAnElement(WebElement element){
        element.click();
    }

    public void sendText(WebElement textBox, String text){
        textBox.sendKeys(text);
    }

    public void isElementDisplayed(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    }

    public WebElement getElementByText(String text){
        WebElement element = null;
        try{
            element = chromeDriver.findElement(By.xpath("//*[text()=\""+text+"\"]"));
        } catch(Exception e){}
        return element;
    }

    public boolean isTextDisplayed(String text){

        boolean isDisplayed = false;
        long startTime = System.currentTimeMillis();
        long timeout = this.timeoutInSeconds * 1000;

        while(System.currentTimeMillis() - startTime <= timeout){
            WebElement element = getElementByText(text);
            if(element != null){
                isDisplayed = true;
                LOG.info("Found element with text: "+element.getText());
                break;
            }
        }
        if (!isDisplayed){
            LOG.info("Cannot find element with text: "+text);
        }
        return isDisplayed;
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
