package com.korean.nicknamesuggest.repositories;

import com.korean.nicknamesuggest.models.Korean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KoreanRepository extends JpaRepository<Korean, String> {
    @Override
    public Optional<Korean> findById(String korean_key);
}
