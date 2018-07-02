package com.ygoa.controller;

import com.ygoa.dao.ReportMapper;
import com.ygoa.pojo.Report;
import com.ygoa.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value="/displayReport")
    @ResponseBody
    public Map<String,List<Report>> getReport(){
        Map<String,List<Report>> modelMap = new HashMap<>();
        //获取report链表
        List<Report> reports = new ArrayList();
        reports = reportService.displayReport();

        modelMap.put("reports",reports);
        return modelMap;
    }

    @RequestMapping(value="/displayReportByMY")
    @ResponseBody
    public Map<String,List<Report>> getReportByMY(@RequestParam("month") int month, @RequestParam("year") int year){
        Map<String,List<Report>> modelMap = new HashMap<>();

        //获取report链表
        List<Report> reportList = new ArrayList();
        reportList= reportService.displayReportByMY(month,year);

        modelMap.put("reportList",reportList);
        return modelMap;
    }
}
