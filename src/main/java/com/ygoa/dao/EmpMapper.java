package com.ygoa.dao;

import com.ygoa.pojo.Employees;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMapper {
    @Insert("insert into employees values(null,#{passWord},#{eName}," +
            "#{sex},#{education},#{phone},#{address},#{email},#{roleId}," +
            "#{job},#{deptNo},#{birthday},#{idCard},#{hiredate}," +
            "#{isMarried},#{holiday},#{remarks}")
    int addEmp(Employees employees);

    @Update("update employees set ename=#{eName} where empno=#{empNo}")
    int updataEmp(Employees employees);

    @Delete("delete from employees where empno=#{empNo}")
    int deleteEmp(@Param("empNo") int empNo);

    @Select("select * from employees where empno=#{empNo}")
    Employees findById(@Param("empNo") int empNo);

    @Select("select * from employees")
    List<Employees> findAll();


  /*  List<Employees> findAllByRp();*/

    List<Employees> findAll01();
}
