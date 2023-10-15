package stepdefs.orangehrm_stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.orangehrm_pages.LoginPage;
import utils.API.endpoints_utils.CandidateUtils;
import utils.API.models.response.CreateCandidateResponseModel;
import utils.API.models.response.DeleteCandidateResponseModel;
import utils.API.models.response.SearchCandidateResponseModel;
import utils.reading_helpers.Constants;
import utils.reading_helpers.Logger;
import utils.reading_helpers.PropertiesLoader;

import java.util.ArrayList;
import java.util.List;

public class OrangeHrmCandidateStepdefs {

    private final LoginPage loginPage;
    private String cookieValue = "";
    public Integer candidateId = 0;
    private CreateCandidateResponseModel createCandidateResponseModel;
    private SearchCandidateResponseModel searchCandidateResponseModel;
    private DeleteCandidateResponseModel deleteCandidateResponseModel;

    public OrangeHrmCandidateStepdefs(){
        loginPage = new LoginPage();
        createCandidateResponseModel = new CreateCandidateResponseModel();
        searchCandidateResponseModel = new SearchCandidateResponseModel();
        deleteCandidateResponseModel = new DeleteCandidateResponseModel();
    }

    @Given("I navigate to OrangeHRM login page")
    public void iNavigateToOrangeHRMLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("I login with admin user name and password")
    public void iLoginWithAdminUserNameAndPassword() {
        try {
            loginPage.enterUserName(PropertiesLoader.readConfig(Constants.ORANGEHRM_USERNAME));
            loginPage.enterPassword(PropertiesLoader.readConfig(Constants.ORANGEHRM_PASSWORD));
            loginPage.clickOnLogin();
        } catch (Exception e){
            Logger.info("Already logged in");
        }
    }

    @Then("I should get the session cookie")
    public void iShouldGetTheSessionCookie() {
        cookieValue = loginPage.getSessionCookie();
    }

    @Given("I create candidate using API with {string} and {string} and {string} with {string} and receive {int}")
    public void iCreateACandidateUsingOrangeHRMAPIWithAndAndWith(String firstName, String lastName, String email, String consent, int statusCode) throws JsonProcessingException {
        createCandidateResponseModel = CandidateUtils.getCreateCandidateResponse(cookieValue,firstName,lastName,email,Boolean.parseBoolean(consent),statusCode);
        candidateId = createCandidateResponseModel.data.id;
    }


    @And("I should receive creation response with the same {string} and {string} and {string}")
    public void iShouldReceiveCreationResponseWithTheSameAndAnd(String firstName, String lastName, String email) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(createCandidateResponseModel.data.firstName,firstName,"first name is not correct in the creation response");
        softAssert.assertEquals(createCandidateResponseModel.data.lastName, lastName, "last name is not correct in the creation response");
        softAssert.assertEquals(createCandidateResponseModel.data.email, email, "email is not correct in the creation response");
        softAssert.assertAll();
    }

    @Given("I search candidates using API with shortlisted status {string} and limit {string} and receive {int} status code")
    public void iSearchCandidatesUsingAPIWithShortlistedStatusAndLimitAndReceiveStatusCode(String applicationStatus, String resultsLimit, int statusCode) {
        searchCandidateResponseModel = CandidateUtils.searchCandidateUsingApplicationStatus(cookieValue,resultsLimit,applicationStatus,statusCode);
    }

    @Then("I should receive search response with all the applicants having {string} application status {string}")
    public void iShouldReceiveSearchResponseWithAllTheApplicantsHavingApplicationStatus(String applicationStatus, String statusId) {
        SoftAssert softAssert = new SoftAssert();
        for(int i=0 ; i<searchCandidateResponseModel.data.size();i++){
            softAssert.assertEquals(searchCandidateResponseModel.data.get(i).status.id.toString(),statusId,"Status id is not correct in results");
            softAssert.assertEquals(searchCandidateResponseModel.data.get(i).status.label.toLowerCase(),applicationStatus.toLowerCase(),"Application status is not correct in results");
        }
        softAssert.assertAll();
    }

    @Given("I delete candidate created above using API with the candidate id and receive {int} status code")
    public void iDeleteCandidateCreatedAboveUsingAPIWithTheIdAndReceiveStatusCode(int statusCode) throws JsonProcessingException {
        List<Integer> ids = new ArrayList<>();
        ids.add(candidateId);
        deleteCandidateResponseModel = CandidateUtils.deleteCandidate(cookieValue,ids,statusCode);
    }

    @Then("I should receive successful delete response with the same candidate id")
    public void iShouldReceiveSuccessfulDeleteResponseWithTheSameId() {
        Assert.assertEquals(deleteCandidateResponseModel.data.get(0),candidateId, "deleted id is not correct in the response");
    }
}
