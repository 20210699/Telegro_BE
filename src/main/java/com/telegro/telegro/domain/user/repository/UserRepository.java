package com.telegro.telegro.domain.user.repository;

import com.telegro.telegro.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(String userId);
}
