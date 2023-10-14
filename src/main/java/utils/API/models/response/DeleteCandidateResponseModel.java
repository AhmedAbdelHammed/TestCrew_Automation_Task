package utils.API.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DeleteCandidateResponseModel {
    @JsonProperty("data")
    public List<Integer> data;
    @JsonProperty("meta")
    public List<Object> meta;
    @JsonProperty("rels")
    public List<Object> rels;
}
