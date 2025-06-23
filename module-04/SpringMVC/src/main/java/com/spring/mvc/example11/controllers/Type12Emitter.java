package com.spring.mvc.example11.controllers;

import com.spring.mvc.example11.ds.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static com.spring.mvc.example11.utils.SleepUtil.sleep;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Controller
public class Type12Emitter {
    @Autowired
    private TaskExecutor taskExecutor;

    @GetMapping("/actionL1")
    @ResponseBody
    public ResponseBodyEmitter actionL1() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();

        CompletableFuture<Void> completableFuture = CompletableFuture
                .runAsync(() -> {
                    try {
                        emitter.send(new Person("John", "Doe"), APPLICATION_JSON);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .thenRunAsync(() -> {
                    try {
                        emitter.send(new Person("William", "Anderson"), APPLICATION_JSON);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .thenRun(emitter::complete);

        taskExecutor.execute(completableFuture::join);

        return emitter;
    }

    @GetMapping("/actionL2")
    @ResponseBody
    public ResponseBodyEmitter actionL2() {
        SseEmitter emitter = new SseEmitter();

        CompletableFuture<Void> completableFuture = CompletableFuture
                .runAsync(() -> {
                    try {
                        sleep();
                        emitter.send(new Person("John", "Doe"), APPLICATION_JSON);
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .thenRunAsync(() -> {
                    try {
                        sleep();
                        emitter.send(new Person("William", "Anderson"), APPLICATION_JSON);
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .thenRun(emitter::complete);

        taskExecutor.execute(completableFuture::join);

        return emitter;
    }
}
