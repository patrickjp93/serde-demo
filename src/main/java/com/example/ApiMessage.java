package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class ApiMessage {

    private final String requestId;
    private final String type;

    @JsonTypeInfo(  use = JsonTypeInfo.Id.NAME,
                    include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
                    property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = ConfigRequest.class, name="configRequest")
    })
    private final ApiPayload payload;

    @JsonCreator
    public ApiMessage(@JsonProperty("requestId") final String requestId,
                      @JsonProperty("type") final String type,
                      @JsonProperty("payload") final ApiPayload payload) {
        this.requestId = requestId;
        this.type = type;
        this.payload = payload;
    }

    public String getRequestId() { return requestId; }

    public String getType() { return type; }

    public ApiPayload getPayload() { return payload; }
}
