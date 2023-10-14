package pages.stc_pages;

import org.openqa.selenium.By;
import utils.reading_helpers.Logger;
import utils.web_helpers.ActionHelper;


public class SubscriptionPage {
    static By LITE_PLAN_TITLE = By.id("name-lite");
    static By CLASSIC_PLAN_TITLE = By.id("name-classic");
    static By PREMIUM_PLAN_TITLE = By.id("name-premium");
    static By SUBSCRIPTION_PAGE_TITLE = By.className("mobile-hidden");
    static By COUNTRY_BTN = By.id("country-btn");
    static By BH_COUNTRY_BTN = By.id("bh");
    static By SA_COUNTRY_BTN = By.id("sa");
    static By KW_COUNTRY_BTN = By.id("kw");
    static By LITE_PLAN_PRICE = By.id("currency-lite");
    static By CLASSIC_PLAN_PRICE = By.id("currency-classic");
    static By PREMIUM_PLAN_PRICE = By.id("currency-premium");

    /**
     * Getting plan title
     * @param  planType pass the plan type you want to return its text
     */
    public String getPlanTitle(String planType){
        switch (planType.toLowerCase()){
            case "lite":
                return ActionHelper.getTextOfElement(LITE_PLAN_TITLE);
            case "classic":
                return ActionHelper.getTextOfElement(CLASSIC_PLAN_TITLE);
            case "premium":
                return ActionHelper.getTextOfElement(PREMIUM_PLAN_TITLE);
            default:
                return null;
        }
    }


    /**
     * Click on country button to switch country
     */
    public void clickOnCountryBtn(){
        ActionHelper.clickOnElement(COUNTRY_BTN);
    }

    /**
     * Switch country through the country popup
     * @param  country pass the country code you want to switch to
     */
    public void switchCountry(String country){
        switch (country.toLowerCase()){
            case "sa":
                ActionHelper.clickOnElement(SA_COUNTRY_BTN);
                break;
            case "bh":
                ActionHelper.clickOnElement(BH_COUNTRY_BTN);
                break;
            case "kw":
                ActionHelper.clickOnElement(KW_COUNTRY_BTN);
                break;
            default:
                Logger.info("Country code is not passed correctly");
        }
    }

    /**
     * Getting subscription page title
     */
    public String getSubscriptionPageTitle(){
        return ActionHelper.getTextOfElement(SUBSCRIPTION_PAGE_TITLE);
    }

    /**
     * Getting plan whole price string ex: 15 SAR/month
     * @param  planType pass the plan type you want to return its whole price
     */
    public String getWholePlanPrice(String planType){
        switch (planType.toLowerCase()){
            case "lite":
                return ActionHelper.getTextOfElement(LITE_PLAN_PRICE);
            case "classic":
                return ActionHelper.getTextOfElement(CLASSIC_PLAN_PRICE);
            case "premium":
                return ActionHelper.getTextOfElement(PREMIUM_PLAN_PRICE);
            default:
                Logger.info("plan type is passed incorrectly");
                return null;
        }
    }

    /**
     * Getting plan price from the whole string ex: 15
     * @param  planType pass the plan type you want to return its extracted price
     */
    public String extractPlanPrice(String planType){
        return ActionHelper.extractStringUsingRegex(getWholePlanPrice(planType),"\\d+(\\.\\d+)?");
    }

    /**
     * Getting plan currency from the whole string ex: SAR
     * @param  planType pass the plan type you want to return its extracted currecy
     */
    public String extractPlanCurrency(String planType){
        return ActionHelper.extractStringUsingRegex(getWholePlanPrice(planType),"\\b\\p{L}+\\b");
    }

    /**
     * Getting plan recurrency from the whole string ex: month
     * @param  planType pass the plan type you want to return its extracted recurrency
     */
    public String extractPlanRecurrency(String planType){
        return ActionHelper.extractStringUsingRegex(getWholePlanPrice(planType),"\\b\\p{L}+$");
    }

}
