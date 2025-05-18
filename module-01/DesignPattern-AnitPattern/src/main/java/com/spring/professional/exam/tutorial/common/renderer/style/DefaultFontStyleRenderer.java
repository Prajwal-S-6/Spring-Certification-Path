package com.spring.professional.exam.tutorial.common.renderer.style;

public class DefaultFontStyleRenderer implements FontStyleRenderer {
    @Override
    public String render(String text) {
        return "<default-style>" + text + "</default-style>";
    }
}
