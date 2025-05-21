package com.certification.spring.preparation.service;

import com.certification.spring.preparation.backup.DbRecordsBackup;
import com.certification.spring.preparation.bls.DbRecordsProcessor;
import com.certification.spring.preparation.reader.DbRecordsReader;
import com.certification.spring.preparation.writer.DbRecordsWriter;
import org.springframework.stereotype.Service;

@Service
public class RecordsService02 {
    public RecordsService02(DbRecordsReader recordsReader, DbRecordsBackup recordsBackup, DbRecordsProcessor recordsProcessor, DbRecordsWriter recordsWriter) {
        System.out.println(
                getClass().getSimpleName() + " recordsReader = " + recordsReader + "\n" +
                        getClass().getSimpleName() + " recordsBackup = " + recordsBackup + "\n" +
                        getClass().getSimpleName() + " recordsProcessor = " + recordsProcessor + "\n" +
                        getClass().getSimpleName() + " recordsWriter = " + recordsWriter + "\n"
        );
    }
}
