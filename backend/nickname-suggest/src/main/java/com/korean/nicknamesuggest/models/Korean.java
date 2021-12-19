package com.korean.nicknamesuggest.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "korean")
public class Korean {

    @Column(name = "korean_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @Column(name = "korean_key")
    private String key;

    @Column(name = "korean_name")
    private String name;

    @Column(name = "korean_pronounce")
    private String pronounce;

    @Column(name = "korean_gender")
    private String gender;

    @OneToMany
    @JoinColumn(name = "user_key")
    private List<User> users = new ArrayList<>();


    public Korean() {

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
