package com.zis.guavapay.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.avro.reflect.Nullable;

import java.util.UUID;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Nullable
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("role")
    private UUID role;
    @JsonProperty("phone")
    private String phone;

    @JsonCreator
    public User(
                @Nullable @JsonProperty("id")UUID id,
                @JsonProperty("name")String name,
                @JsonProperty("lastname")String lastname,
                @JsonProperty("role")UUID role,
                @JsonProperty("phone")String phone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
        this.phone = phone;
    }
}
