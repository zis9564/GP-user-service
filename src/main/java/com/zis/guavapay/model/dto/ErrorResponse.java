package com.zis.guavapay.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {

    @JsonProperty("invalidatedFields")
    private final List<String> invalidFieldsList;

    @JsonCreator
    public ErrorResponse(@JsonProperty("invalidatedFields") List<String> fieldsName) {
        this.invalidFieldsList = fieldsName;
    }
}
