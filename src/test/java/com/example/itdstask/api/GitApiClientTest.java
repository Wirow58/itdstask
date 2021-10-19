package com.example.itdstask.api;

import com.example.itdstask.exception.JsonParseException;
import com.example.itdstask.exception.UserNotFoundException;
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
        //given api client
        //when
        UserApiResponse response = client.getUserResponse("octocat");
        //then
        assertNotNull(response.getName());
        assertEquals("User", response.getType());
    }

}
