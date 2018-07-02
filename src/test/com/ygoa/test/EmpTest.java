package com.ygoa.test;

import com.ygoa.pojo.Employees;
import com.ygoa.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmpTest {
    @Test
    public  void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        EmpService empService = ctx.getBean("EmpService", EmpService.class);
        List<Employees> all = empService.findAll();
        all.forEach(employees -> System.out.println(employees));


    }
}
