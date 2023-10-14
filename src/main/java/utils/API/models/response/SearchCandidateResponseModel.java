package utils.API.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class SearchCandidateResponseModel {
    @JsonProperty("data")
    public List<Data> data;
    @JsonProperty("meta")
    public Meta meta;
    @JsonProperty("rels")
    public List<Object> rels;

    public static class Data {
        @JsonProperty("id")
        public Integer id;
        @JsonProperty("firstName")
        public String firstName;
        @JsonProperty("middleName")
        public String middleName;
        @JsonProperty("lastName")
        public String lastName;
        @JsonProperty("dateOfApplication")
        public String dateOfApplication;
        @JsonProperty("vacancy")
        public Vacancy vacancy;
        @JsonProperty("status")
        public Status status;
        @JsonProperty("hasAttachment")
        public Boolean hasAttachment;
        @JsonProperty("deletable")
        public Boolean deletable;
    }

    public static class Meta {
        @JsonProperty("total")
        public Integer total;
    }

    public static class Status {
        @JsonProperty("id")
        public Integer id;
        @JsonProperty("label")
        public String label;
    }

    public static class Vacancy {
        @JsonProperty("id")
        public Integer id;
        @JsonProperty("name")
        public String name;
        @JsonProperty("status")
        public Boolean status;
        @JsonProperty("hiringManager")
        public HiringManager hiringManager;
    }

    public static class HiringManager {
        @JsonProperty("id")
        public Integer id;
        @JsonProperty("firstName")
        public String firstName;
        @JsonProperty("middleName")
        public String middleName;
        @JsonProperty("lastName")
        public String lastName;
        @JsonProperty("terminationId")
        public Object terminationId;
    }

}
