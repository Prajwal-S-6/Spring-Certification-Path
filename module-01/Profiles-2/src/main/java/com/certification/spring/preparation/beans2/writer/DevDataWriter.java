package com.certification.spring.preparation.beans2.writer;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class DevDataWriter implements DataWriter {
}
