package com.o_a_jeong.gonggang_mate.service;

import org.springframework.transaction.annotation.Transactional;
import com.o_a_jeong.gonggang_mate.dto.JoinResult;
import com.o_a_jeong.gonggang_mate.entities.articledb.entity.Article;
import com.o_a_jeong.gonggang_mate.entities.articledb.repository.ArticleRepository;
import com.o_a_jeong.gonggang_mate.entities.userdb.entity.User;
import com.o_a_jeong.gonggang_mate.entities.userdb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class JoinService {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public JoinService(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    // 로그인 로직
    public boolean authenticateUser(String username, String password) {
        // 사용자 정보를 찾고 비밀번호를 비교
        Optional<User> userOptional = userRepository.findByStuName(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getPassword().equals(password); // 비밀번호 비교
        }
        return false; // 사용자 없음
    }

    // Join !!
    public List<JoinResult> getJoinedData() {
        List<JoinResult> result = new ArrayList<>();

        // USER 데이터베이스에서 모든 사용자 가져오기
        List<User> users = userRepository.findAll();

        // 각 사용자에 대해 ARTICLE 데이터베이스 검색
        for (User user : users) {
            List<Article> articles = articleRepository.findByStuNameAndMajorName(user.getStuName(), user.getMajorName());

            // 조인 결과를 생성
            for (Article article : articles) {
                JoinResult joinResult = new JoinResult();
                joinResult.setUserId(user.getId());
                joinResult.setUserStuName(user.getStuName());
                joinResult.setUserMajorName(user.getMajorName());
                joinResult.setArticleId(article.getId());
                joinResult.setArticleStuName(article.getStuName());
                joinResult.setArticleMajorName(article.getMajorName());

                result.add(joinResult);
            }
        }

        return result;
    }

    // 1. 필터링 기능 구현을 해야한다.
    public List<JoinResult> getFilteredArticles(){

        List<JoinResult> result = new ArrayList<>();
        result = getJoinedData();

        //이제 프론트에서 int 값을 받아서 필터링 해야됨
        //int flag

        return result;
    }

    //2. 모든 게시물 보여주기
    public List<Article> showAllArticles(){
        return articleRepository.findAll();
    }


    // 3. 게시물 클릭 --> 상세정보를 볼 수 있도록 한다.
    // ID로 Article을 조회하는 메서드
    @Transactional(readOnly = true)
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    // 4. 예약 기능

    // 8. 게시물 등록하기
    public Long enrollArticle(Article article){
        articleRepository.save(article);

        return article.getId();
    }
}
