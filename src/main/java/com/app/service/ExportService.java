package com.app.service;

import fr.opensagres.xdocreport.core.XDocReportException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ExportService {
    void word(HttpServletResponse response) throws IOException, XDocReportException;
}
