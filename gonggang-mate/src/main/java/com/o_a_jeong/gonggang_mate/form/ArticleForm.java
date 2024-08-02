package com.o_a_jeong.gonggang_mate.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleForm {
    private String articleTitle;
    private String articleContent;
    private String stuName;
    private int articleType;
    private String majorName;
    private boolean isMajorSame;

}
