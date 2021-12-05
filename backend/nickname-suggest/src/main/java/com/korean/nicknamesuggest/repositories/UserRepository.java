package com.korean.nicknamesuggest.repositories;

import com.korean.nicknamesuggest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
