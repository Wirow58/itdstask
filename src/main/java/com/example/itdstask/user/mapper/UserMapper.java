package com.example.itdstask.user.mapper;

import com.example.itdstask.api.UserApiResponse;
import com.example.itdstask.calculation.CalculationService;
import com.example.itdstask.user.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final CalculationService calculationService;

    public UserMapper(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public UserDTO toUserDTO(UserApiResponse response) {
        return new UserDTO(
                response.getId(),
                response.getLogin(),
                response.getName(),
                response.getType(),
                response.getAvatarUrl(),
                response.getCreatedAt(),
                calculationService.calculate(response)
        );
    }
}
