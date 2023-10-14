package utils.API.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreateCandidateResponseModel {
    @JsonProperty("data")
    public Data data;
    @JsonProperty("meta")
    public List<Object> meta;
    @JsonProperty("rels")
    public List<Object> rels;

    public static class Data {
        @JsonProperty("id")
        public Integer id;
        @JsonProperty("firstName")
        public String firstName;
        @JsonProperty("middleName")
        public Object middleName;
        @JsonProperty("lastName")
        public String lastName;
        @JsonProperty("email")
        public String email;
    }
}
