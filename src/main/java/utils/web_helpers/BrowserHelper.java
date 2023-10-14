package utils.web_helpers;

import utils.driver.DriverSingleton;

public class BrowserHelper {

    /**
     * Navigate to url
     *
     * @param url is the url you want to navigate to
     */
    public static void navigateToURL(String url){
        DriverSingleton.getDriver().get(url);
    }

    /**
     * Maximize browser window
     */
    public static void maximizeWindow(){
        DriverSingleton.getDriver().manage().window().maximize();
    }

}
