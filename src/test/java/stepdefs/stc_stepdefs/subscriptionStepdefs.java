package stepdefs.stc_stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.stc_pages.SubscriptionPage;

public class subscriptionStepdefs {

    private final SubscriptionPage subscriptionPage;

    public subscriptionStepdefs(){
          subscriptionPage = new SubscriptionPage();
    }

    @When("I switch to specific {string}")
    public void iSwitchToSpecific(String countryCode) {
        subscriptionPage.switchCountry(countryCode);
    }

    @Then("I should see {string} with {string} and {string} and {string}")
    public void iShouldSeeWithAnd(String title, String price, String currency, String recurrency) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(subscriptionPage.getPlanTitle(title),title, "Plan title is not matching");
        softAssert.assertEquals(subscriptionPage.extractPlanPrice(title), price, "Plan price is not matching");
        softAssert.assertEquals(subscriptionPage.extractPlanCurrency(title), currency, "Plan currency is not matching");
        softAssert.assertEquals(subscriptionPage.extractPlanRecurrency(title),recurrency, "Plan recurrency is not matching");
        softAssert.assertAll();
    }

    @Given("I am on subscription page with title {string}")
    public void iAmOnSubscriptionPageWithTitle(String pageTitle) {
        Assert.assertEquals(subscriptionPage.getSubscriptionPageTitle(), pageTitle, "Page title is incorrect");
    }

    @Given("I click on change country button")
    public void iClickOnChangeCountryButton() {
        subscriptionPage.clickOnCountryBtn();
    }

}
