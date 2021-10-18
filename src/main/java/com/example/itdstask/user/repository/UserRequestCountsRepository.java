package com.example.itdstask.user.repository;

import com.example.itdstask.user.UserRequestCount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRequestCountsRepository extends CrudRepository<UserRequestCount, Long> {

    UserRequestCount findByLogin(String login);

}
