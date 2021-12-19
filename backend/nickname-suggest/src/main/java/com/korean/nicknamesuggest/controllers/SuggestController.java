package com.korean.nicknamesuggest.controllers;

import com.korean.nicknamesuggest.models.Korean;
import com.korean.nicknamesuggest.models.User;
import com.korean.nicknamesuggest.repositories.KoreanRepository;
import com.korean.nicknamesuggest.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class SuggestController {

    Logger logger = LoggerFactory.getLogger(SuggestController.class);

    @Autowired
    private KoreanRepository koreanRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/female/{name}")
    public ArrayList<String> suggestFemaleController(@PathVariable String name) {
        ArrayList<String> suggestFemaleName = new ArrayList();
        logger.info("Start suggestFemaleController");
        logger.info("name : "+name);
        try {
            String id = name.substring(0,1);
            String country = "korea";
            User user = new User();
            user.setGender("female");
            user.setKey(id);
            user.setName(name);
            user.setCountry(country);

            Optional<Korean> korean = koreanRepository.findById(id);
            userRepository.save(user);

            logger.info("name   : "+user.getName());
            logger.info("id     : "+user.getId());
            logger.info("key    : "+user.getKey());
            logger.info("gender : "+user.getGender());

            suggestFemaleName.add(korean.get().getName());
            suggestFemaleName.add(korean.get().getPronounce());
            return suggestFemaleName;
        } catch (Exception e) {
            logger.error("API cannot make suggest female name");
            suggestFemaleName.add("error");
            return suggestFemaleName;
        }
    }
}
