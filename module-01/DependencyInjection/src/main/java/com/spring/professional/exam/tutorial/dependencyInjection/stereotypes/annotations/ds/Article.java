package com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds;

public class Article {
    private int id;

    public Article(int id) {

        this.id = id;
    }

    public String getName() {
        return "Article-" + id;
    }
}
