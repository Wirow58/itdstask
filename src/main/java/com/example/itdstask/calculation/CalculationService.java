package com.example.itdstask.calculation;

import com.example.itdstask.api.UserApiResponse;
import org.springframework.stereotype.Component;

@Component
public class CalculationService {

    public Float calculate(UserApiResponse apiResponse) {
        Integer repos = apiResponse.getPublicRepos();
        if (apiResponse.getPublicRepos() == null) repos = 0;
        if (apiResponse.getFollowers() == 0 || apiResponse.getFollowers() == null) return Float.NaN;
        return (float) 6 / apiResponse.getFollowers() * (2 + repos);
    }

}
