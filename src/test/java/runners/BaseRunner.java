package runners;

import io.cucumber.testng.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.homeSteps;
import utils.DriverManager;


@CucumberOptions(
        glue = "steps",
        features = "src/test/resources/features",
        tags = "not @outOfScope",
        monochrome = true,
        plugin = {
                "summary",
                "pretty"
        },
        publish = true
)
@Test
public class BaseRunner extends AbstractTestNGCucumberTests {

        private static final Logger LOG = LogManager.getLogger(BaseRunner.class);
        DriverManager driverManager;
        homeSteps homeSteps;

        public BaseRunner(){
                homeSteps = new homeSteps();
                this.driverManager = new DriverManager();
                PropertyConfigurator.configure("src/main/resources/log4j.properties");
                LOG.info("Logging");
        }

        @BeforeMethod
        public void beforeTest(){ if(DriverManager.getWebDriver() == null){ driverManager.createChromeDriver(); }}

        @Override
        @DataProvider
        public Object[][]scenarios(){
                return super.scenarios();
        }

        @AfterSuite(alwaysRun = true)
        public void cleanup(){
                homeSteps.tearDown();
                LOG.info("Cleaned up!");
        }

}