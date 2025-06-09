package com.spring.data.example4.callback.custom.printer;

public class DecoratedValuePrinter implements ValuePrinter {
    @Override
    public void print(int value) {
        System.out.println(String.format("Value = [%d]", value));
    }
}
