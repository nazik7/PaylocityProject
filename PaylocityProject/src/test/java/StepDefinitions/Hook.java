package StepDefinitions;

import Utils.BrowserUtils;
import Utils.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hook {

    WebDriver driver;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            BrowserUtils.takeScreenShot();
        }
    }
}
