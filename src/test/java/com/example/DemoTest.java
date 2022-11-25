package com.example;

import io.micronaut.serde.ObjectMapper;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

@MicronautTest
class SerdeDemoTest {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void serializeAndParseApiMessage() {
        final ObjectMapper objectMapper = new ObjectMapper.getDefault();
        final ApiMessage message = new ApiMessage("1234",
                                                    PayloadNameEnum.Constant.CONFIG_REQUEST_VALUE,
                                                    new ConfigRequest("HA1"));
        final String json = objectMapper.writeValueAsString(message);
        System.out.println("Merssage Json: " + json);

        final ApiMessage parsed = objectMapper.readValue(result, ApiMessage.class);
        assertNotNull(parsed);
        assertEquals(message.getRequestId(), parsed.getRequestId());
        assertEquals(message.getType(), parsed.getType());
        assertEquals(message.getPayload(), parsed.getPayload());
    }

}
