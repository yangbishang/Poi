package com.ygoa.service;

import com.ygoa.dao.EmpMapper;
import com.ygoa.dao.ReportMapper;
import com.ygoa.pojo.Employees;
import com.ygoa.pojo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("EmpService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpMapper dao;
    @Autowired
    private ReportMapper reportMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int addEmp(Employees employees) {
        return dao.addEmp(employees);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int updataEmp(Employees employees) {
        return dao.updataEmp(employees);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int deleteEmp(int empNo) {
        return dao.deleteEmp(empNo);
    }

    @Override
    public Employees findById(int empNo) {
        return dao.findById(empNo);
    }

    @Override
    public List<Employees> findAll() {
        return dao.findAll();
    }


}
