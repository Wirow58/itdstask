package com.example.itdstask.api;

import com.example.itdstask.exception.JsonParseException;
import com.example.itdstask.exception.UserNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GitApiClientTest{

    @Autowired
    private GitApiClient client;

    @Test
    public void shouldReturnValidResponse() throws UserNotFoundException, JsonParseException {
        //when
        JsonNode response = client.getUserJsonResponse("octocat");
        //then
        assertNotNull(response.path("name").asText());
        assertEquals("User", response.path("type").asText());
    }

}
