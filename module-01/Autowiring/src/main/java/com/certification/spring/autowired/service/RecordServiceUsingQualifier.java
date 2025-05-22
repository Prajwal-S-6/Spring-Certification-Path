package com.certification.spring.autowired.service;

import com.certification.spring.RecordsReaderCustomQualifier;
import com.certification.spring.autowired.reader.RecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.certification.spring.RecordsReaderCustomQualifier.RecordsReaders.SOCKET;
import static com.certification.spring.RecordsReaderCustomQualifier.RecordsReaders.WEB_SERVICE;

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

    @Autowired
    @RecordsReaderCustomQualifier(WEB_SERVICE)
    private RecordsReader recordsReader3;
}
