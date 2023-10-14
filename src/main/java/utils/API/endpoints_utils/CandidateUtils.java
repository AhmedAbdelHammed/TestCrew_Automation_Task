package utils.API.endpoints_utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import utils.API.endpoints.Endpoints;
import utils.API.helpers.CleanObject;
import utils.API.models.request.CreateCandidateRequestModel;
import utils.API.models.request.DeleteCandidateRequestModel;
import utils.API.models.response.CreateCandidateResponseModel;
import utils.API.models.response.DeleteCandidateResponseModel;
import utils.API.models.response.SearchCandidateResponseModel;
import utils.API.restwrapper.Headers;
import utils.API.restwrapper.QueryParams;
import utils.API.restwrapper.RestHelper;
import utils.reading_helpers.Constants;
import utils.reading_helpers.PropertiesLoader;

import java.util.List;

public class CandidateUtils {

    public static String BASE_URL = PropertiesLoader.readConfig(Constants.ORANGEHRM_URL);

    /**
     * Create body request for create candidate API
     * @param  firstName candidate first name
     * @param  lastName candidate last name
     * @param  email candidate email
     * @param consent candidate consent agreement
     */
    public static String createCandidatePayload(String firstName, String lastName, String email, boolean consent) throws JsonProcessingException {
        CreateCandidateRequestModel createCandidateRequestModel = new CreateCandidateRequestModel();
        createCandidateRequestModel.firstName = firstName;
        createCandidateRequestModel.lastName = lastName;
        createCandidateRequestModel.email = email;
        createCandidateRequestModel.consentToKeepData = consent;
        return CleanObject.getCleanObject(createCandidateRequestModel);
    }

    /**
     * Delete body request for delete candidate API
     * @param  ids list of ids to delete
     */
    public static String deleteCandidatePayload(List<Integer> ids) throws JsonProcessingException {
        DeleteCandidateRequestModel deleteCandidateRequestModel = new DeleteCandidateRequestModel();
        deleteCandidateRequestModel.ids = ids;
        return CleanObject.getCleanObject(deleteCandidateRequestModel);
    }

    /**
     * Create candidate post request
     */
    public static CreateCandidateResponseModel getCreateCandidateResponse(String cookieValue, String firstName, String lastName, String email, boolean consent, int statusCode) throws JsonProcessingException {
        return RestHelper.restPost(BASE_URL, Endpoints.CANDIDATE, Headers.candidateHeaders(cookieValue),
                createCandidatePayload(firstName, lastName, email, consent), CreateCandidateResponseModel.class, statusCode);
    }

    /**
     * Search candidates get request
     */
    public static SearchCandidateResponseModel searchCandidateUsingApplicationStatus(String cookieValue, String limit, String status, int statusCode){
        return RestHelper.restGet(BASE_URL, Endpoints.CANDIDATE, Headers.candidateHeaders(cookieValue),
                QueryParams.searchCandidateByStatusQueryParams(limit, status),SearchCandidateResponseModel.class, statusCode);
    }

    /**
     * Delete candidate delete request
     */
    public static DeleteCandidateResponseModel deleteCandidate(String cookieValue, List<Integer> ids, int statusCode) throws JsonProcessingException {
        return RestHelper.restDelete(BASE_URL, Endpoints.CANDIDATE, Headers.candidateHeaders(cookieValue)
                ,deleteCandidatePayload(ids), DeleteCandidateResponseModel.class,statusCode);
    }
}
