package utils.API.models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreateCandidateRequestModel {
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("middleName")
    public Object middleName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("email")
    public String email;
    @JsonProperty("contactNumber")
    public Object contactNumber;
    @JsonProperty("keywords")
    public Object keywords;
    @JsonProperty("comment")
    public Object comment;
    @JsonProperty("dateOfApplication")
    public String dateOfApplication;
    @JsonProperty("consentToKeepData")
    public Boolean consentToKeepData;
}
