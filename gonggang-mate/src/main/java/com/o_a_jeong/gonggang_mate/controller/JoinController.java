package com.o_a_jeong.gonggang_mate.controller;

import com.o_a_jeong.gonggang_mate.dto.JoinResult;
import com.o_a_jeong.gonggang_mate.entities.articledb.entity.Article;
import com.o_a_jeong.gonggang_mate.form.ArticleForm;
import com.o_a_jeong.gonggang_mate.service.JoinService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class JoinController {
    private final JoinService joinService;

    // Join

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping("/join")
    public List<JoinResult> getJoinResults() {
        return joinService.getJoinedData();
    }
    // 1. 로그인 하는 척!
    // 지호형이 할거에용


    // 2. 게시물 리스트 보여주기
    @GetMapping("/lists")
    public String showLists(Model model){
        List<Article> articles = joinService.showAllArticles();
        model.addAttribute("articles", articles);
        return "demo.html";
    }

    // 3. 필터링
    // 할 지 말 지 모름 html css 박아서 영상 편집할 수도 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ

    // 4. 다른 사람의 게시물 클릭 --> 상세정보를 볼 수 있도록 한다!
    // id 값을 받아오는 것을 프론트가 완성되면 고민 해봐야한다.
    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id) {
        Optional<Article> article = joinService.getArticleById(id);

        // Article이 존재하다면 HTTP 200 응답 반환, 없을 경우 HTTP 404 응답 반환
        // html 파일을 가지고 오는 게 아님.. 일단 이렇게만 구현해놓고 나중에 또 해야됨!!
        return article.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 5. 예약 기능
    // alert 뜨는데 확인 누르면 시간표 창으로 가고 취소 누르면 home 가게 한다..
    @PostMapping("/reserve")
    public String doReserve(){
        return "demo.html";
    }

    // 6. 시간표 보여주기
    @GetMapping("/timeTable")
    public String timeTablePage(){

        return "demo.html";
    }

    // 7. DM창 보여주기
    @GetMapping("/directMessage")
    public String directMessagePage(){

        return "demo.html";
    }

    // 8. 글쓰기 페이지에서 글 쓰기
    @GetMapping("/writeWebPage") // html 에서 a 태그 신준혁이 박아야함 ㅎㅎ!!!!!!
    public String goToWritePage() {
        return "demo.html";
    }

    @PostMapping("/enrollArticle")
    public String enrollArticle(ArticleForm articleForm) {
        Article article = new Article();

        article.setArticleContent(articleForm.getArticleContent());
        article.setArticleType(articleForm.getArticleType());
        article.setArticleTitle(articleForm.getArticleTitle());

        joinService.enrollArticle(article);

        return "demo.html"; // home ? main page?
    }

    // 9. 내 프로필 들어가기
    @GetMapping("/showMyProfile/{username}")
    public String myProfile(){

        return "demo.html";
    }
}