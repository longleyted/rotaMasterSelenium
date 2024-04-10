package utils;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    protected static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public void createChromeDriver() {

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\chrome-win32\\chrome.exe");
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win32\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        webDriver.set(new ChromeDriver(options));

    }

    public static WebDriver getWebDriver(){
        return webDriver.get();
    }

    public void quitDriver() {
        getWebDriver().quit();
    }
}
