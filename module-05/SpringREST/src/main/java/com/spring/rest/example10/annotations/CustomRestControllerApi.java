package com.spring.rest.example10.annotations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ResponseBody
public @interface CustomRestControllerApi {
}
