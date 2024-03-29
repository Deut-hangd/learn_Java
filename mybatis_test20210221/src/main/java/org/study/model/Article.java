package org.study.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Article {
    private Integer id;

    private String title;

    private String content;

    private Integer viewCount;

    private Integer userId;

    private Date createTime;
}
