package com.example.itdstask.api;

import com.example.itdstask.exception.JsonParseException;
import com.example.itdstask.exception.UserNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitApiClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${client.baseurl}")
    private String baseUrl;

    public GitApiClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public JsonNode getUserJsonResponse(String login) throws UserNotFoundException, JsonParseException {
        ResponseEntity<String> rawResponse = restTemplate.getForEntity(baseUrl + "/" + login, String.class);
        if (rawResponse.getStatusCode() != HttpStatus.OK) throw new UserNotFoundException();
        try {
            return objectMapper.readTree(rawResponse.getBody());
        } catch (JsonProcessingException e) {
            throw new JsonParseException();
        }
    }
}
