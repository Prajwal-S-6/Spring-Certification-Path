package com.spring.professional.exam.tutorial.after;

import com.spring.professional.exam.tutorial.after.TextRenderer.TextRendererBuilder;
import com.spring.professional.exam.tutorial.common.renderer.color.RedColorRenderer;
import com.spring.professional.exam.tutorial.common.renderer.weight.BoldFontWeightRenderer;

public class Runner {
    public static void main(String... args) {
        // Using Builder pattern to build the objects
        TextRenderer textRenderer = new TextRendererBuilder().build();
        textRenderer.render("Default Rendering");

        TextRenderer redRenderer = new TextRendererBuilder()
                .withFontColorRenderer(new RedColorRenderer())
                .build();
        redRenderer.render("Red Color Rendering");

        TextRenderer boldRenderer = new TextRendererBuilder()
                .withFontWeightRenderer(new BoldFontWeightRenderer())
                .build();
        boldRenderer.render("Bold Rendering");
    }
}
