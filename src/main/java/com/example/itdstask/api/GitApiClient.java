package com.example.itdstask.api;

import com.example.itdstask.exception.JsonParseException;
import com.example.itdstask.exception.UserNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
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

    public UserApiResponse getUserResponse(String login) throws UserNotFoundException, JsonParseException {
        ResponseEntity<String> rawResponse;
        try {
            rawResponse = restTemplate.getForEntity(baseUrl + "/" + login, String.class);
        } catch (HttpClientErrorException e) {
            throw new UserNotFoundException();
        }
        if (rawResponse.getStatusCode() != HttpStatus.OK) throw new UserNotFoundException();
        try {
            return objectMapper.readValue(rawResponse.getBody(), UserApiResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new JsonParseException();
        }
    }
}
