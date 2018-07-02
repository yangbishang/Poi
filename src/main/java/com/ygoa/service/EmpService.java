package com.ygoa.service;

import com.ygoa.pojo.Employees;
import com.ygoa.pojo.Report;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmpService {
    int addEmp(Employees employees);

    int updataEmp(Employees employees);

    int deleteEmp(@Param("empNo") int empNo);

    Employees findById(@Param("empNo") int empNo);

    List<Employees> findAll();


}
