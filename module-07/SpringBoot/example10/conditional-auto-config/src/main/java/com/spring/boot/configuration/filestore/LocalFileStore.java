package com.spring.boot.configuration.filestore;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@AutoConfiguration
@ConditionalOnProperty(value = "file.store", havingValue = "local")
public class LocalFileStore implements FileStore{
    @Override
    public void print() {
        System.out.println("This is Local FileStore");
    }
}
