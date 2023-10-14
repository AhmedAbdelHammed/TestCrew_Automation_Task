package utils.API.restwrapper;

import java.util.HashMap;
import java.util.Map;

public class QueryParams {

    /**
     * Query params for search candidates using the application status, ex:"shortlisted"
     * @param limit is the limit of search results
     * @param status is the status id for the application
     */
    public static Map<String, String> searchCandidateByStatusQueryParams(String limit, String status) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("limit",limit);
        params.put("offset","0");
        params.put("status", status);
        params.put("model", "list");
        params.put("sortField", "candidate.dateOfApplication");
        params.put("sortOrder", "DESC");
        return params;
    }

}
