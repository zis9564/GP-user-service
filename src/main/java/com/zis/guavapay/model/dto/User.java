package com.zis.guavapay.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("role")
    private Long role;
    @JsonProperty("phone")
    private String phone;

    @JsonCreator
    public User(@JsonProperty("id")Long id,
                @JsonProperty("name")String name,
                @JsonProperty("lastname")String lastname,
                @JsonProperty("role")Long role,
                @JsonProperty("phone")String phone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
        this.phone = phone;
    }
}
