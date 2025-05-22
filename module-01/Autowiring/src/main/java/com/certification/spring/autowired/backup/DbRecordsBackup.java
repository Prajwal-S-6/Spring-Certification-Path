package com.certification.spring.autowired.backup;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DbRecordsBackup implements RecordsBackup {
    @Override
    public void backupRecords(Collection<Record> records) {

    }
}
