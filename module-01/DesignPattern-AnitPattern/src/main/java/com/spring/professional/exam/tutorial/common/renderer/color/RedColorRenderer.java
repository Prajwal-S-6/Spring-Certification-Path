package com.spring.professional.exam.tutorial.common.renderer.color;

public class RedColorRenderer implements FontColorRenderer {
    @Override
    public String render(String text) {
        return "<red-color>" + text + "</red-color>";
    }
}
