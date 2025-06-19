package com.spring.mvc.example5.ds;

public class ArticleCriteria {

    private String bodyLike;

    public ArticleCriteria() {
    }

    public ArticleCriteria(String bodyLike) {
        this.bodyLike = bodyLike;
    }

    public String getBodyLike() {
        return bodyLike;
    }

    public void setBodyLike(String bodyLike) {
        this.bodyLike = bodyLike;
    }
}
