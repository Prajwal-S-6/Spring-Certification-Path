package com.spring.professional.exam.tutorial.common.renderer.weight;

public class BoldFontWeightRenderer implements FontWeightRenderer {
    @Override
    public String render(String text) {
        return "<bold-weight>" + text + "</bold-weight>";
    }
}
