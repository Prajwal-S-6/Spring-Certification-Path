package com.spring.professional.exam.tutorial.common.renderer.style;

public class ItalicStyleRenderer implements FontStyleRenderer {
    @Override
    public String render(String text) {
        return "<italic-style>" + text + "</italic-style>";
    }
}
