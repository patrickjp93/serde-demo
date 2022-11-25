package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ConfigRequest extends ApiPayload {

    private final String type;

    @JsonCreator
    public ConfigRequest(@JsonProperty("type") final String type) {
        this.type = type;
    }

    public String getType() { return type; }
}
