package utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.reading_helpers.Constants;
import utils.reading_helpers.Logger;
import utils.reading_helpers.PropertiesLoader;


public class DriverSingleton {

    private static WebDriver driver;
    private static final String browserType = PropertiesLoader.readConfig(Constants.BROWSER_TYPE);
    private static final String headless = PropertiesLoader.readConfig(Constants.HEADLESS);

    /**
     * Private constructor to prevent instantiation
     */
    private DriverSingleton() {
    }

    /**
     * Public function to get driver and configure chrome options
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            driverSetup();
        }
        return driver;
    }

    /**
     * Public function to set up the driver according to the browser type in config
     */
    public static void driverSetup(){
        switch (browserType.toLowerCase()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (Boolean.parseBoolean(headless)) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (Boolean.parseBoolean(headless)) {
                    edgeOptions.addArguments("--headless");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (Boolean.parseBoolean(headless)){
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--window-size=1920,1080");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                Logger.info("browser type is not passed correctly");
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
