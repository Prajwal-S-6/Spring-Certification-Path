package com.certification.spring.preparation.beans1;

import com.certification.spring.preparation.beans1.mappers.DataMapper;
import com.certification.spring.preparation.beans1.processors.DataProcessor;
import com.certification.spring.preparation.beans1.processors.MultiSourceDataProcessor;
import com.certification.spring.preparation.beans1.readers.DataReader;
import com.certification.spring.preparation.beans1.readers.DbDataReader;
import com.certification.spring.preparation.beans1.readers.FileDataReader;
import com.certification.spring.preparation.beans1.writer.DataWriter;
import com.certification.spring.preparation.beans1.writer.DevDataWriter;
import com.certification.spring.preparation.beans1.writer.ProdDataWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan
public class ApplicationConfiguration1 {

    @Bean
    public DataMapper dataMapper() {
        return new DataMapper();
    }

    @Bean
    @Profile({"database", "file"})
    public DataProcessor multiSourceDataProcessor() {
        return new MultiSourceDataProcessor();
    }

    @Bean
    @Profile("database")
    public DataReader dbDataReader() {
        return new DbDataReader();
    }

    @Bean
    @Profile("file")
    public DataReader fileDataReader() {
        return new FileDataReader();
    }

    @Bean
    @Profile("!prod")
    public DataWriter devDataWriter() {
        return new DevDataWriter();
    }

    @Bean
    @Profile("!dev")
    public DataWriter prodDataWriter() {
        return new ProdDataWriter();
    }
}
