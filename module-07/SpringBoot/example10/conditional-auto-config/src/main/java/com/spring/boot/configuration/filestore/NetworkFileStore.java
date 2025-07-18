package com.spring.boot.configuration.filestore;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@AutoConfiguration
@ConditionalOnProperty(value = "file.store", havingValue = "network")
public class NetworkFileStore implements FileStore{
    @Override
    public void print() {
        System.out.println("This is Network FileStore");
    }
}
