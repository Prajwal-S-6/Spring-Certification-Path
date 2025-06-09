package com.spring.data.example3.template.design.pattern;

import com.spring.data.example3.template.design.pattern.report.PdfReport;
import com.spring.data.example3.template.design.pattern.report.TxtReport;
import com.spring.data.example3.template.design.pattern.report.XlsReport;

import java.nio.file.Paths;

public class Runner {

    public static void main(String[] args) {
        PdfReport pdfReport = new PdfReport();
        pdfReport.generateReport(Paths.get("report.pdf"), "pdf report");

        TxtReport txtReport = new TxtReport();
        txtReport.generateReport(Paths.get("report.txt"), "text report");

        XlsReport xlsReport = new XlsReport();
        xlsReport.generateReport(Paths.get("report.xls"), "xls report");
    }
}
