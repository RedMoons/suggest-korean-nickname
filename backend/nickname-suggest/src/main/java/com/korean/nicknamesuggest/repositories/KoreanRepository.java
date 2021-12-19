package com.korean.nicknamesuggest.repositories;

import com.korean.nicknamesuggest.models.Korean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KoreanRepository extends JpaRepository<Korean, Long> {
    public Korean findById(String korean_key);
}
