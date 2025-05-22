package com.certification.spring.autowired.service;

import com.certification.spring.autowired.bls.RecordsProcessor;
import com.certification.spring.autowired.reader.RecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceUsingQualifier {

    @Autowired
    @Qualifier("dbRecordsProcessor")
    private RecordsProcessor recordsProcessor;

    @Autowired
    @Qualifier("file-record-reader")
    private RecordsReader recordsReader;
}
