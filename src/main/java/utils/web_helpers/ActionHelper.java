package utils.web_helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driver.DriverSingleton;
import utils.reading_helpers.Constants;
import utils.reading_helpers.Logger;
import utils.reading_helpers.PropertiesLoader;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActionHelper {

    static int timeout = Integer.parseInt(PropertiesLoader.readConfig(Constants.TIMEOUT));
    static WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(timeout));

    /**
     * Click on element after wait and scroll
     *
     * @param locator is the locator of the element
     */
    public static void clickOnElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        scrollToElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        DriverSingleton.getDriver().findElement(locator).click();
    }

    /**
     * Force click on element using js after wait and scroll
     *
     * @param locator is the locator of the element
     */
    public static void forceClickOnElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        scrollToElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverSingleton.getDriver();
        jsExecutor.executeScript("arguments[0].click();", DriverSingleton.getDriver().findElement(locator));
    }
    /**
     * Get text of element after wait and scroll
     *
     * @param locator is the locator of the element
     */
    public static String getTextOfElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        scrollToElement(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return DriverSingleton.getDriver().findElement(locator).getText();
    }

    /**
     * Send text to element after wait and scroll
     *
     * @param locator is the locator of the element
     */
    public static void sendTextToElement(By locator, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        scrollToElement(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        DriverSingleton.getDriver().findElement(locator).sendKeys(text);
    }

    /**
     * Check if element is displayed
     *
     * @param locator is the locator of the element
     */
    public static Boolean isDisplayed(By locator){
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * Scroll to element
     *
     * @param locator is the locator of the element
     */
    public static void scrollToElement(By locator){
        JavascriptExecutor js = (JavascriptExecutor) DriverSingleton.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", DriverSingleton.getDriver().findElement(locator));
    }

    /**
     * Get Session Cookie
     *
     * @param cookieName is the cookie name you want to retrieve
     */
    public static String getSessionCookie(String cookieName){
        return DriverSingleton.getDriver().manage().getCookieNamed(cookieName).getValue();
    }

    /**
     * Extract string using regex
     *
     * @param input is the string
     * @param pattern is the pattern of the regex
     */
    public static String extractStringUsingRegex(String input, String pattern){
        Matcher matcher = Pattern.compile(pattern).matcher(input);
        if (matcher.find()) return matcher.group();
        Logger.info("pattern not found in input");
        return "";
    }
}
