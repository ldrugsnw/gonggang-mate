package com.o_a_jeong.gonggang_mate.entity.article;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String articleTitle;
    private String articleContent;
    private String stuName;
    private int articleType;
    // 1 : 스터디, 2 : 운동, 3 : 문화생활, 4 : 식사
    private String majorName;
    private boolean isMajorSame;
    // true == 같은 과 표시
}
