package com.example.itdstask.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserApiResponse {

    private long id;
    private String login;
    private String name;
    private String type;
    @JsonAlias(value = "avatar_url")
    private String avatarUrl;
    @JsonAlias(value = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdAt;
    @JsonAlias(value = "public_repos")
    private Integer publicRepos;
    private Integer followers;

}
