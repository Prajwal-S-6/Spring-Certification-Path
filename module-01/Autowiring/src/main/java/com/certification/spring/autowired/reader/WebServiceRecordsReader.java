package com.certification.spring.autowired.reader;

import com.certification.spring.RecordsReaderCustomQualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
//@Priority(2)
// @Order(1)
@RecordsReaderCustomQualifier(RecordsReaderCustomQualifier.RecordsReaders.WEB_SERVICE)
public class WebServiceRecordsReader implements RecordsReader {
    @Override
    public Collection<Record> readRecords() {
        return null;
    }
}
