package com.azure.test.azureDemo.persistence;

import com.azure.test.azureDemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, String> {
    /**
     *
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);
}
