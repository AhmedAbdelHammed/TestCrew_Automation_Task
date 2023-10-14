package utils.API.restwrapper;

import utils.API.endpoints.Endpoints;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class RestHelper {

    /**
     * Rest post wrapper method
     */
    public static <T> T restPost(String URL, Endpoints endpoint, Map<String, String> headers, Object bodyData, Class<T> responseClass, int statusCode) {
        return given().log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(bodyData)
                .when()
                .post(URL.concat(endpoint.getValue()))
                .then().assertThat().statusCode(statusCode)
                .extract()
                .as(responseClass);
    }

    /**
     * Rest get wrapper method
     */
    public static <T> T restGet(String URL, Endpoints endpoint, Map<String, String> headers,Map<String, String> queryParameters, Class<T> responseClass, int statusCode) {
        return given().log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .queryParams(queryParameters)
                .when()
                .get(URL.concat(endpoint.getValue()))
                .then().assertThat().statusCode(statusCode)
                .extract()
                .as(responseClass);
    }

    /**
     * Rest delete wrapper method
     */
    public static <T> T restDelete(String URL, Endpoints endpoint, Map<String, String> headers, Object bodyData, Class<T> responseClass, int statusCode) {
        return given().log().all()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(bodyData)
                .when()
                .delete(URL.concat(endpoint.getValue()))
                .then().assertThat().statusCode(statusCode)
                .extract()
                .as(responseClass);
    }
}
