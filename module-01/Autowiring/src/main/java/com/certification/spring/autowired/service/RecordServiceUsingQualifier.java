package com.certification.spring.autowired.service;

import com.certification.spring.autowired.reader.RecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceUsingQualifier {

    @Autowired
    @Qualifier("dbRecordsReader")
    private RecordsReader recordsReader;
}
