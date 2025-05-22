package com.certification.spring.preparation.service;

import com.certification.spring.preparation.bls.DbRecordsProcessor;
import com.certification.spring.preparation.non.beans.RecordsHash;
import com.certification.spring.preparation.non.beans.RecordsUtil;
import com.certification.spring.preparation.non.beans.RecordsValidator;
import com.certification.spring.preparation.reader.DbRecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecordsService03 {

    public RecordsService03() {
        System.out.println(getClass().getSimpleName() + "----------------------- this is normal constructor");
    }

    // @Autowired(required = false)
    @Autowired
    private RecordsService03(DbRecordsReader recordsReader, DbRecordsProcessor recordsProcessor, Optional<RecordsUtil> recordsUtil, @Nullable RecordsHash recordsHash, @Autowired(required = false) RecordsValidator recordsValidator) {
        System.out.println(
                getClass().getSimpleName() + " recordsReader = " + recordsReader + "\n" +
                        getClass().getSimpleName() + " recordsProcessor = " + recordsProcessor + "\n" +
                        getClass().getSimpleName() + " recordsUtil = " + recordsUtil + "\n" +
                        getClass().getSimpleName() + " recordsHash = " + recordsHash + "\n" +
                        getClass().getSimpleName() + " recordsValidator = " + recordsValidator + "\n"
        );
    }

    //@Autowired(required = false)
    RecordsService03(DbRecordsReader recordsReader, DbRecordsProcessor recordsProcessor, RecordsValidator recordsValidator) {
        System.out.println(
                getClass().getSimpleName() + " recordsReader = " + recordsReader + "\n" +
                        getClass().getSimpleName() + " recordsProcessor = " + recordsProcessor + "\n" +
                        getClass().getSimpleName() + " recordsValidator = " + recordsValidator + "\n"
        );

    }


}
