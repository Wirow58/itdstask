package com.example.itdstask.calculation;

import com.example.itdstask.api.UserApiResponse;
import org.springframework.stereotype.Component;

@Component
public class CalculationService {

    public Float calculate(UserApiResponse apiResponse) {
        Integer repos = apiResponse.getPublicRepos();
        if (repos == null) repos = 0;
        if (apiResponse.getFollowers() == null || apiResponse.getFollowers() == 0) return Float.NaN;
        return (float) 6 / apiResponse.getFollowers() * (2 + repos);
    }

}
