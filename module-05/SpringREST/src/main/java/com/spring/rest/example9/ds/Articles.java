package com.spring.rest.example9.ds;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@JacksonXmlRootElement(localName = "articles")
public class Articles {

    @JacksonXmlProperty(localName = "articles")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Article> articles = new LinkedList<>();


    public Articles() {
    }

    public Articles(Iterable<Article> customers) {
        this.articles = StreamSupport.stream(customers.spliterator(), false)
                .collect(Collectors.toList());
    }
}
