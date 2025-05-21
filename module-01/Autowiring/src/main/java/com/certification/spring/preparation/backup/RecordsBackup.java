package com.certification.spring.preparation.backup;


import java.util.Collection;

public interface RecordsBackup {
    void backupRecords(Collection<Record> records);
}
