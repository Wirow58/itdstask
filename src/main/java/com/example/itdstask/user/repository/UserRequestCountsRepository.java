package com.example.itdstask.user.repository;

import com.example.itdstask.user.UserRequestCount;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface UserRequestCountsRepository extends CrudRepository<UserRequestCount, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<UserRequestCount> findByLogin(String login);

}
