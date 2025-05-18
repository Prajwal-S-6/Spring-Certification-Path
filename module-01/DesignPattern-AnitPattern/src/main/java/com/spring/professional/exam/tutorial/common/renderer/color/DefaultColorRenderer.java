package com.spring.professional.exam.tutorial.common.renderer.color;

public class DefaultColorRenderer implements FontColorRenderer {
    @Override
    public String render(String text) {
        return "<default-color>" + text + "</default-color>";
    }
}
