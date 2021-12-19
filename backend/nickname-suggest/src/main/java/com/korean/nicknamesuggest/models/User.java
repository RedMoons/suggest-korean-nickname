package com.korean.nicknamesuggest.models;

import javax.persistence.*;

@Entity(name="users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_key")
    private String key;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "korean_key")
    private String koreanKey;

    public User() {

    }

    public String getKoreanKey() {
        return koreanKey;
    }

    public void setKoreanKey(String koreanKey) {
        this.koreanKey = koreanKey;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
