package pages.orangehrm_pages;

import org.openqa.selenium.By;
import utils.API.endpoints.Endpoints;
import utils.reading_helpers.Constants;
import utils.reading_helpers.PropertiesLoader;
import utils.web_helpers.ActionHelper;
import utils.web_helpers.BrowserHelper;

public class LoginPage {
    static By USERNAME_TXT_FIELD = By.name("username");
    static By PASSWORD_TXT_FIELD = By.name("password");
    static By LOGIN_BTN = By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");

    public void navigateToLoginPage(){
        BrowserHelper.navigateToURL(PropertiesLoader.readConfig(Constants.ORANGEHRM_URL)+ Endpoints.LOGIN.getValue());
    }

    /**
     * Enter admin username
     * @param  userName is the username you want to send
     */
    public void enterUserName(String userName){
        ActionHelper.sendTextToElement(USERNAME_TXT_FIELD,userName);
    }

    /**
     * Enter admin password
     * @param  password is the username you want to send
     */
    public void enterPassword(String password){
        ActionHelper.sendTextToElement(PASSWORD_TXT_FIELD,password);
    }

    /**
     * click on login
     */
    public void clickOnLogin(){
        ActionHelper.clickOnElement(LOGIN_BTN);
    }

    /**
     * Getting the session cookie to use it in API calls
     */
    public String getSessionCookie(){
        return ActionHelper.getSessionCookie(PropertiesLoader.readConfig(Constants.SESSION_COOKIE_NAME));
    }
}
