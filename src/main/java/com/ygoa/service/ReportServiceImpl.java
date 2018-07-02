package com.ygoa.service;

import com.ygoa.dao.ReportMapper;
import com.ygoa.pojo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("reportService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class ReportServiceImpl implements ReportService{
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<Report> displayReport() {
        return reportMapper.getReport();
    }

    @Override
    public List<Report> displayReportByMY(int month , int year) {
        return reportMapper.getReportByMY(month , year);
    }
}
