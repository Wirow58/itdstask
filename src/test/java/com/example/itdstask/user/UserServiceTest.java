package com.example.itdstask.user;

import com.example.itdstask.api.GitApiClient;
import com.example.itdstask.api.UserApiResponse;
import com.example.itdstask.exception.JsonParseException;
import com.example.itdstask.exception.UserNotFoundException;
import com.example.itdstask.user.mapper.UserMapper;
import com.example.itdstask.user.repository.UserRequestCountsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserServiceTest {

    private final GitApiClient apiClient = Mockito.mock(GitApiClient.class);
    private final UserRequestCountsRepository repository = Mockito.mock(UserRequestCountsRepository.class);
    private final UserMapper mapper = Mockito.mock(UserMapper.class);
    private final String login = "octocat";
    private final UserRequestCount requestCount = new UserRequestCount(login, 35L);
    private final UserRequestCount incrementedRequestCount = new UserRequestCount(login, 36L);
    private final UserRequestCount freshRequestCount = new UserRequestCount(login, 1L);
    private final UserDTO userDTO = new UserDTO(1L, login, "Test Testowski", "User", "google.com", LocalDateTime.now(), 1.23F);
    private final UserApiResponse response = new UserApiResponse(
            1,
            "octocat",
            "Test Testowski",
            "User",
            "https://google.com",
            LocalDateTime.now(),
            8,
            4072);

    private final UserService service = new UserService(apiClient, repository, mapper);

    @Test
    public void shouldCallAllMethodsSaveUsersAndReturnDTO() throws UserNotFoundException, JsonParseException {
        //given
        Mockito.when(apiClient.getUserResponse(login)).thenReturn(response);
        Mockito.when(repository.findByLogin(login)).thenReturn(Optional.of(requestCount));
        Mockito.when(repository.save(incrementedRequestCount)).thenReturn(incrementedRequestCount);
        Mockito.when(mapper.toUserDTO(response)).thenReturn(userDTO);
        //when
        service.getUser(login);
        //then
        InOrder inOrder = Mockito.inOrder(apiClient, repository, repository, mapper);
        inOrder.verify(apiClient).getUserResponse(login);
        inOrder.verify(repository).findByLogin(login);
        inOrder.verify(repository).save(incrementedRequestCount);
        inOrder.verify(mapper).toUserDTO(response);
    }

    @Test
    public void shouldCreateNewUserRequestCountObject() throws UserNotFoundException, JsonParseException {
        //given
        Mockito.when(apiClient.getUserResponse(login)).thenReturn(response);
        Mockito.when(repository.findByLogin(login)).thenReturn(Optional.empty());
        Mockito.when(repository.save(freshRequestCount)).thenReturn(freshRequestCount);
        Mockito.when(mapper.toUserDTO(response)).thenReturn(userDTO);
        //when
        service.getUser(login);
        //then
        InOrder inOrder = Mockito.inOrder(apiClient, repository, repository, mapper);
        inOrder.verify(apiClient).getUserResponse(login);
        inOrder.verify(repository).findByLogin(login);
        inOrder.verify(repository).save(freshRequestCount);
        inOrder.verify(mapper).toUserDTO(response);
    }
}
