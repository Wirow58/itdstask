package com.example.itdstask.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_request_counts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestCount {

    @Id
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "request_count")
    private Long requestCount;
}
