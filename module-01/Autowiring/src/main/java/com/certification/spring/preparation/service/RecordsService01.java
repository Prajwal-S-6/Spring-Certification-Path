package com.certification.spring.preparation.service;

import com.certification.spring.preparation.backup.DbRecordsBackup;
import com.certification.spring.preparation.bls.DbRecordsProcessor;
import com.certification.spring.preparation.non.beans.RecordsHash;
import com.certification.spring.preparation.non.beans.RecordsUtil;
import com.certification.spring.preparation.non.beans.RecordsValidator;
import com.certification.spring.preparation.reader.DbRecordsReader;
import com.certification.spring.preparation.writer.DbRecordsWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class RecordsService01 {
    @Autowired
    public DbRecordsReader recordsReader;
    @Autowired
    protected DbRecordsBackup recordsBackup;
    @Autowired
    private DbRecordsProcessor recordsProcessor;
    @Autowired
    DbRecordsWriter recordsWriter;
    @Autowired
    private Optional<RecordsHash> recordsHash;
    @Autowired
    @Nullable
    private RecordsUtil recordsUtil;
    @Autowired(required = false)
    private RecordsValidator recordsValidator;

    public RecordsService01() {
        System.out.println(
                getClass().getSimpleName() + " recordsReader = " + recordsReader + "\n" +
                        getClass().getSimpleName() + " recordsBackup = " + recordsBackup + "\n" +
                        getClass().getSimpleName() + " recordsProcessor = " + recordsProcessor + "\n" +
                        getClass().getSimpleName() + " recordsWriter = " + recordsWriter + "\n" +
                        getClass().getSimpleName() + " recordsHash = " + recordsHash + "\n" +
                        getClass().getSimpleName() + " recordsUtil = " + recordsUtil + "\n" +
                        getClass().getSimpleName() + " recordsValidator = " + recordsValidator + "\n"
        );
    }

    @PostConstruct
    public void init() {
        System.out.println(
                getClass().getSimpleName() + " recordsReader = " + recordsReader + "\n" +
                        getClass().getSimpleName() + " recordsBackup = " + recordsBackup + "\n" +
                        getClass().getSimpleName() + " recordsProcessor = " + recordsProcessor + "\n" +
                        getClass().getSimpleName() + " recordsWriter = " + recordsWriter + "\n" +
                        getClass().getSimpleName() + " recordsHash = " + recordsHash + "\n" +
                        getClass().getSimpleName() + " recordsUtil = " + recordsUtil + "\n" +
                        getClass().getSimpleName() + " recordsValidator = " + recordsValidator + "\n"
        );
    }
}
