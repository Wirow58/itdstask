package com.example.itdstask.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_request_counts")
@Data
@NoArgsConstructor
@SequenceGenerator(name = "USER_REQ_COUNT_ID_SEQ", sequenceName = "user_request_counts_id_seq", allocationSize = 1)
public class UserRequestCount {

    public UserRequestCount(String login, Long requestCount) {
        this.login = login;
        this.requestCount = requestCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_REQ_COUNT_ID_SEQ")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "request_count")
    private Long requestCount = 0L;
}
