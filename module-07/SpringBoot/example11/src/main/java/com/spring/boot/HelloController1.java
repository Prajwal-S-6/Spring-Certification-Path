package com.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController1 {

    private final Logger logger = LoggerFactory.getLogger(HelloController1.class);

    @GetMapping("/hello1")
    public String hello() {
        logger.trace("TRACE");
        logger.debug("DEBUG");
        logger.info("INFO");
        logger.warn("WARN");
        logger.error("ERROR");

        return "Hello1";
    }
}
