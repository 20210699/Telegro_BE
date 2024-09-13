package com.telegro.telegro.domain.user.repository;

import com.telegro.telegro.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
