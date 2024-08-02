package com.o_a_jeong.gonggang_mate.entities.userdb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stuName;
    private int stuNumber;
    private String majorName;


    // 로그인 password 추가
    private String password;

    public String getPassword() {
        return password;
    }
}
