package com.zis.guavapay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("id")
    private String firstName;
    @JsonProperty("id")
    private String lastName;
}
