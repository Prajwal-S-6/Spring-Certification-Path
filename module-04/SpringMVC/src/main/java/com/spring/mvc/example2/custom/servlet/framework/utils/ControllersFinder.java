package com.spring.mvc.example2.custom.servlet.framework.utils;

import com.spring.mvc.example2.custom.servlet.framework.controller.CustomController;
import com.spring.mvc.example2.custom.servlet.framework.controller.IController;
import org.reflections.Reflections;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ControllersFinder {

    public Map<String, IController> findControllers() {
        return new Reflections()
                .getTypesAnnotatedWith(CustomController.class)
                .stream()
                .map(this::getAsControllerClass)
                .map(this::getControllerInstance)
                .collect(Collectors.toMap(this::getUri, Function.identity()));
    }

    private Class<IController> getAsControllerClass(Class<?> controller) {
        return (Class<IController>) controller;
    }

    private IController getControllerInstance(Class<IController> controller) {
        try {
            return controller.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("Error occured while creating instance of controller %s: %s", controller.getSimpleName(), e.getMessage()), e
            );
        }
    }

    private String getUri(IController controller) {
        return controller.getClass().getAnnotation(CustomController.class).value();
    }
}
