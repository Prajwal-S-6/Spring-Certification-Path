package com.spring.mvc.example11.controllers;

import com.spring.mvc.example11.ds.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

import static com.spring.mvc.example11.utils.SleepUtil.sleep;

@Controller
public class Type11Callable {

    private Logger logger = LoggerFactory.getLogger(Type11Callable.class);

    @GetMapping("actionK")
    @ResponseBody
    public Callable<Person> actionK() {
        return () -> {
            logger.info("Sleeping for some seconds");
            sleep();
            logger.info("Finished sleeping, producing result");
            return new Person("Praj", "S");
        };
    }
}
