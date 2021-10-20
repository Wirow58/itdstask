package com.example.itdstask.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String validLogin = "octocat";
    private final String invalidLogin = "ThereIsNoWayThatUserWithSuchANameWillEverExist";

    @Test
    public void shouldReturnUserDataWithCalculation() throws Exception {
        mockMvc.perform(
                get("/users/" + validLogin)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().is(200));
    }

    @Test
    public void shouldReturn404() throws Exception {
        mockMvc.perform(
                get("/users/" + invalidLogin)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().is(404));
    }


}
