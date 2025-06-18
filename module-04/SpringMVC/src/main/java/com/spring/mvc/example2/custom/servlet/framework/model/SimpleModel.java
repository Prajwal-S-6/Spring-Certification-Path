package com.spring.mvc.example2.custom.servlet.framework.model;

import java.util.HashMap;
import java.util.Map;

public class SimpleModel implements Model{

    Map<String, String> model = new HashMap<>();
    @Override
    public void set(String name, String value) {
        model.put(name, value);
    }

    @Override
    public String get(String name) {
        return model.get(name);
    }
}
