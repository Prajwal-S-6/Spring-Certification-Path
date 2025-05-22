package com.certification.spring.autowired.service;

import com.certification.spring.autowired.backup.DbRecordsBackup;
import com.certification.spring.autowired.bls.DbRecordsProcessor;
import com.certification.spring.autowired.reader.DbRecordsReader;
import com.certification.spring.autowired.writer.DbRecordsWriter;
import org.springframework.stereotype.Service;

@Service
public class RecordsService02 {
    // @Autowired redundant
    public RecordsService02(DbRecordsReader recordsReader, DbRecordsBackup recordsBackup, DbRecordsProcessor recordsProcessor, DbRecordsWriter recordsWriter) {
        System.out.println(
                getClass().getSimpleName() + " recordsReader = " + recordsReader + "\n" +
                        getClass().getSimpleName() + " recordsBackup = " + recordsBackup + "\n" +
                        getClass().getSimpleName() + " recordsProcessor = " + recordsProcessor + "\n" +
                        getClass().getSimpleName() + " recordsWriter = " + recordsWriter + "\n"
        );
    }
}
