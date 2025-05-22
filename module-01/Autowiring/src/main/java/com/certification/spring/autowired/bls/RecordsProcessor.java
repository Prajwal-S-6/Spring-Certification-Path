package com.certification.spring.autowired.bls;


import java.util.Collection;

public interface RecordsProcessor {
    Collection<Record> processRecords(Collection<Record> records);
}
