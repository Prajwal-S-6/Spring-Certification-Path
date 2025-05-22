package com.certification.spring.autowired.service;

import com.certification.spring.autowired.bls.RecordsProcessor;
import com.certification.spring.autowired.reader.RecordsReader;
import com.certification.spring.autowired.writer.RecordsWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceUsingQualifier {

    @Autowired
    @Qualifier("dbRecordsReader")
    private RecordsReader recordsReader;

    @Autowired
    @Qualifier("file-record-reader")
    private RecordsReader recordsReader1;

    @Autowired
    @Qualifier("socket-record-reader")
    private RecordsReader recordsReader2;
}
