package com.example.itdstask.user;

import com.example.itdstask.api.GitApiClient;
import com.example.itdstask.exception.JsonParseException;
import com.example.itdstask.exception.UserNotFoundException;
import com.example.itdstask.user.repository.UserRequestCountsRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final GitApiClient apiClient;
    private final UserRequestCountsRepository repository;

    public UserService(GitApiClient apiClient, UserRequestCountsRepository repository) {
        this.apiClient = apiClient;
        this.repository = repository;
    }

    public UserDTO getUser(String login) throws UserNotFoundException, JsonParseException {
        JsonNode root = apiClient.getUserJsonResponse(login);

    }
}
