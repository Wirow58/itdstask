package com.example.itdstask.user.repository;

import com.example.itdstask.user.UserRequestCount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRequestCountsRepository extends CrudRepository<UserRequestCount, Long> {

    Optional<UserRequestCount> findByLogin(String login);

}
