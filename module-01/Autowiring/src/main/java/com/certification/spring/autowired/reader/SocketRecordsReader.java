package com.certification.spring.autowired.reader;

import com.certification.spring.RecordsReaderCustomQualifier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Order(8)
@Qualifier("socket-record-reader")
@RecordsReaderCustomQualifier(RecordsReaderCustomQualifier.RecordsReaders.SOCKET)
public class SocketRecordsReader implements RecordsReader {
    @Override
    public Collection<Record> readRecords() {
        return null;
    }
}
