package com.zis.guavapay.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.avro.reflect.Nullable;

import java.util.Objects;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Nullable
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("role")
    private String role;
    @JsonProperty("phone")
    private String phone;

    @JsonCreator
    public User(
                @Nullable @JsonProperty("id")String id,
                @JsonProperty("name")String name,
                @JsonProperty("lastname")String lastname,
                @JsonProperty("role")String role,
                @JsonProperty("phone")String phone) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name required");
        this.lastname = Objects.requireNonNull(lastname, "lastname required");
        this.role = Objects.requireNonNull(role, "role required");
        this.phone = Objects.requireNonNull(phone, "phone required");
    }
}
