package com.certification.spring.preparation.bls;


import java.util.Collection;

public interface RecordsProcessor {
    Collection<Record> processRecords(Collection<Record> records);
}
