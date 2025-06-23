package com.spring.mvc.example11.controllers;

import com.spring.mvc.example11.ds.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import static com.spring.mvc.example11.utils.SleepUtil.sleep;

@Controller
public class Type10DeferredResult {

    private Logger logger = LoggerFactory.getLogger(Type10DeferredResult.class);

    @Autowired
    private TaskExecutor taskExecutor;

    @GetMapping("/actionJ")
    @ResponseBody
    public DeferredResult<Person> actionJ() {
        DeferredResult<Person> personDeferredResult = new DeferredResult<>();
        taskExecutor.execute(() -> {
            logger.info("Sleeping for some seconds");
            try {
                sleep();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("Finished sleeping, giving results");
            personDeferredResult.setResult(new Person("Praj", "S"));

        });
        return personDeferredResult;
    }
}
