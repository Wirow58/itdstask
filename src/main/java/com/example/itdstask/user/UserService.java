package com.example.itdstask.user;

import com.example.itdstask.api.GitApiClient;
import com.example.itdstask.api.UserApiResponse;
import com.example.itdstask.exception.JsonParseException;
import com.example.itdstask.exception.UserNotFoundException;
import com.example.itdstask.user.mapper.UserMapper;
import com.example.itdstask.user.repository.UserRequestCountsRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    private final GitApiClient apiClient;
    private final UserRequestCountsRepository repository;
    private final UserMapper mapper;

    public UserService(GitApiClient apiClient, UserRequestCountsRepository repository, UserMapper mapper) {
        this.apiClient = apiClient;
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserDTO getUser(String login) throws UserNotFoundException, JsonParseException {
        UserApiResponse response = apiClient.getUserResponse(login);
        Optional<UserRequestCount> userCountOpt = repository.findByLogin(response.getLogin());
        UserRequestCount userCount;
        if (userCountOpt.isEmpty()) {
            userCount = new UserRequestCount(response.getLogin(), 1L);
        } else {
            userCount = userCountOpt.get();
            userCount.setRequestCount(userCount.getRequestCount() + 1);
        }
        repository.save(userCount);
        return mapper.toUserDTO(response);
    }


}
