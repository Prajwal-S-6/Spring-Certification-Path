package com.spring.mvc.example11.controllers;

import com.spring.mvc.example11.ds.Person;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import static com.spring.mvc.example11.utils.SleepUtil.sleep;

@Controller
public class Type14ReactiveTypes {

    @Autowired
    private TaskExecutor taskExecutor;

    @GetMapping("/actionN")
    @ResponseBody
    public Observable<Person> actionN() {
        PublishSubject<Person> publishSubject = PublishSubject.create();

        taskExecutor.execute(() -> {
            try {
                sleep();
                publishSubject.onNext(new Person("Praj", "S"));
                publishSubject.onNext(new Person("John", "Doe"));

                publishSubject.onComplete();
            } catch (Exception e) {
                publishSubject.onError(e);
            }
        });

        return publishSubject;
    }
}
