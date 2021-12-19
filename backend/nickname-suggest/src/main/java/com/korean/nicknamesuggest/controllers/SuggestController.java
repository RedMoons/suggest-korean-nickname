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

@RestController
public class SuggestController {

    Logger logger = LoggerFactory.getLogger(SuggestController.class);

    @Autowired
    private KoreanRepository koreanRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/female/{name}")
    public ArrayList<String> suggestFemaleController(@PathVariable String name) {
        logger.info("Start suggestFemaleController");
        logger.info("name : "+name);



        String key = name.substring(0,1);
        User user = new User();
        user.setGender("female");
        user.setKey(key);
        user.setName(name);

        Korean korean = koreanRepository.findById(key);
        user.setKorean(korean);
        userRepository.save(user);

        logger.info("name   : "+user.getName());
        logger.info("id     : "+user.getId());
        logger.info("key    : "+user.getKey());
        logger.info("gender : "+user.getGender());

        ArrayList<String> list = new ArrayList();
        list.add(korean.getName());
        list.add(korean.getPronounce());
        return list;
    }


    @GetMapping("/test")
    public void test() {
        try {

            Korean k1 = new Korean();
            k1.setKey("da");
            k1.setName("다은");
            k1.setGender("female");
            k1.setPronounce("da-un");
            koreanRepository.save(k1);

            Korean k2 = new Korean();
            k2.setKey("aa");
            k2.setName("이유");
            k2.setGender("female");
            k2.setPronounce("iu");
            koreanRepository.save(k2);


            User user = new User();
            user.setGender("female");
            user.setKey("aa");
            user.setName("aajin");
            Korean k = koreanRepository.findById("a");
            user.setKorean(k);
            userRepository.save(user);

            User user2 = new User();
            user2.setGender("female");
            user2.setKey("da");
            user2.setName("darkman");
            Korean korean2 = koreanRepository.findById("d");
            user2.setKorean(korean2);
            userRepository.save(user2);

        } catch (Exception e){
            System.out.println("exception");
        }
    }

}
