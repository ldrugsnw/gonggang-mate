package com.o_a_jeong.gonggang_mate.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JoinResult {
    private Long userId;
    private String userStuName;
    private String userMajorName;
    private Long articleId;
    private String articleStuName;
    private String articleMajorName;
}
