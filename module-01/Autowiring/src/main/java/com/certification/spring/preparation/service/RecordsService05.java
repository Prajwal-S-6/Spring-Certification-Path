package com.certification.spring.preparation.service;

import com.certification.spring.preparation.reader.RecordsReader;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordsService05 {



    @Autowired
    public void setRecordsReaders(List<RecordsReader> recordsReaders) {
        System.out.println(getClass().getSimpleName() + " setRecordsReaders:");
        recordsReaders.stream()
                .map(r -> "\t" + r.getClass().getSimpleName())
                .forEach(System.out::println);
    }
}
