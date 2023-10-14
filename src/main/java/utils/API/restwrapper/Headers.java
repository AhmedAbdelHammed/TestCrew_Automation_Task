package utils.API.restwrapper;


import utils.reading_helpers.Constants;
import utils.reading_helpers.PropertiesLoader;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    static String SESSION_COOKIE_NAME = PropertiesLoader.readConfig(Constants.SESSION_COOKIE_NAME);

    /**
     * Candidate requests headers
     * @param cookieValue is the session cookie passed through the headers to access the APIs
     */
    public static Map<String, String> candidateHeaders(String cookieValue) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Content-Type","application/json");
        params.put("Cookie", SESSION_COOKIE_NAME + "=" + cookieValue);
        return params;
    }

}
