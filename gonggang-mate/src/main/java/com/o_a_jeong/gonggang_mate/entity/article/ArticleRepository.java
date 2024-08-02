package com.o_a_jeong.gonggang_mate.entity.article;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    // To Join
    List<Article> findByStuNameAndMajorName(String stuName, String majorName);
    // 아이디를 통해 article 반환
    Optional<Article> findById(Long id);
    //
}