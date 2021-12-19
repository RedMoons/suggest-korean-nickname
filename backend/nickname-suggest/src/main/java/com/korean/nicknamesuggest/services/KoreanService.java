package com.korean.nicknamesuggest.services;

import com.korean.nicknamesuggest.models.Korean;
import com.korean.nicknamesuggest.repositories.KoreanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KoreanService {
    @Autowired
    private KoreanRepository koreanRepository;

    public List<Korean> findAll() {
        return koreanRepository.findAll();
    }

    public Korean save(Korean korean) {
        koreanRepository.save(korean);
        return korean;
    }

    public Optional<Korean> findById(Long id) {
        return koreanRepository.findById(id);
    }
}
