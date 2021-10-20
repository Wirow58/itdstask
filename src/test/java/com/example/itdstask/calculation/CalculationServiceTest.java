package com.example.itdstask.calculation;

import com.example.itdstask.api.UserApiResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculationServiceTest {

    private final UserApiResponse response = new UserApiResponse(
            1,
            "someLogin",
            "Test Testowski",
            "User",
            "https://google.com",
            LocalDateTime.now(),
            8,
            4072);

    private final UserApiResponse noFollowersResponse = new UserApiResponse(
            1,
            "someLogin",
            "Test Testowski",
            "User",
            "https://google.com",
            LocalDateTime.now(),
            8,
            0);

    private final UserApiResponse nullDataFollowersResponse = new UserApiResponse(
            1,
            "someLogin",
            "Test Testowski",
            "User",
            "https://google.com",
            LocalDateTime.now(),
            null,
            null);

    private final float eps = 0.0001F;

    private final CalculationService service = new CalculationService();

    @Test
    public void shouldReturnCalculationFloat() {
        //given service instance and valid api response
        //when
        float result = service.calculate(response);
        //then
        assertTrue(Math.abs(result - 0.0147) < eps);
    }

    @Test
    public void shouldReturnNan() {
        //given service instance and response with no followers
        //when
        float result = service.calculate(noFollowersResponse);
        //then
        assertTrue(Float.isNaN(result));
    }

    @Test
    public void givenNullShouldReturnNan() {
        //given service instance and response with null numeric fields
        //when
        float result = service.calculate(nullDataFollowersResponse);
        //then
        assertTrue(Float.isNaN(result));

    }

}
