package com.ygoa.service;

import com.ygoa.pojo.Report;

import java.util.List;

public interface ReportService {
    List<Report> displayReport();
    List<Report> displayReportByMY(int month,int year);
}
