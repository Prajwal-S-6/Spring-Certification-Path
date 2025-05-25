package com.certification.spring.preparation.beans2.readers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("database")
public class DbDataReader implements DataReader {
}
