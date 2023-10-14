package stepdefs;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import utils.driver.DriverSingleton;
import utils.reading_helpers.Constants;
import utils.reading_helpers.Logger;
import utils.reading_helpers.PropertiesLoader;
import utils.web_helpers.BrowserHelper;

public class Hooks {

    static String url = PropertiesLoader.readConfig(Constants.STC_URL);


    public static void embedScreenshot(Scenario scenario) {
        try {
            final byte[] screenshot = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "embedScreenShot");
        } catch (WebDriverException | NullPointerException e) {
            Logger.info("Failed to take embed Screenshot");
        }
    }

    /**
     * Run once at the start of the test
     */
    @BeforeAll
    public static void beforeAll(){
        BrowserHelper.maximizeWindow();
    }

    /**
     * Run before every scenario
     */
    @Before
    public static void beforeScenario(Scenario scenario){
        if(scenario.getSourceTagNames().toString().contains("STCWeb")) BrowserHelper.navigateToURL(url);
    }

    /**
     * Run before every scenario
     */
    @After
    public static void afterScenario(Scenario scenario){
        embedScreenshot(scenario);
    }

    /**
     * Run once at the end of the test
     */
    @AfterAll
    public static void afterAll(){
        DriverSingleton.quitDriver();
    }
}
