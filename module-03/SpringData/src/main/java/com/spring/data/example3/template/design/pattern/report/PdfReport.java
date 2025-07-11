package com.spring.data.example3.template.design.pattern.report;

public class PdfReport extends AbstractReport {
    @Override
    void appendHeader() {
        System.out.println("Appending Pdf Header");
    }

    @Override
    void appendText(String text) {
        System.out.println("Appending Pdf Text");
    }

    @Override
    void appendFooter() {
        System.out.println("Appending Pdf Text");
    }
}
