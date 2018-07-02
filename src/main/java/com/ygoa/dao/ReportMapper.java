package com.ygoa.dao;


import com.ygoa.pojo.Report;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportMapper {


    @Update("update report set clockIn=#{clockIn},normalClockIn=#{normalClockIn},later=#{later},leaveEarlier=#{leaveEarlier},leaveTime=#{leaveTime},approvalTime=#{leaveTime} where empno = #{empno} and rDate=#{rDate}")
    int updateReport(@Param("clockIn") int clockIn,@Param("normalClockIn") int normalClockIn,@Param("later") int later,@Param("leaveEarlier") int leaveEarlier,@Param("leaveTime") int leaveTime,@Param("approvalTime") int approvalTime,@Param("empno") int empno,@Param("rDate") java.util.Date rDate);

    //向表report中添加empno，enamel，deptno,rDate
    @Insert("insert into report(empno,ename,deptno,rDate)"
            +" values(#{empno},#{ename},#{deptno},#{rDate}) ")
    int addEmpnoEname(@Param("empno") int empno, @Param("ename") String ename, @Param("deptno") int deptno,@Param("rDate") Date rDate);


    //打卡次数
    @Select("select count(date_format(atteTime,'%d')) from attered where empno = #{empno} and date_format(atteTime,'%m') = #{month}")
    int getClockIn(@Param("empno") int empno ,@Param("month") int month);


    //正常打卡次数
    @Select("select count(date_format(atteTime,'%d')) from attered where empno = #{empno} and date_format(atteTime,'%m') = #{month} and (date_format(atteTime,'%T')<=9 or date_format(atteTime,'%T')>=17 );")
    int getNormalClockIn(@Param("empno") int empno ,@Param("month") int month);


    //迟到次数
    @Select("select count(date_format(atteTime,'%T')) from attered where empno = #{empno} and date_format(atteTime,'%m') = #{month} and (extract(HOUR from atteTime)in (9.001 , 12) )")
    int getLater(@Param("empno") int empno,@Param("month") int month);


    //早退次数
    @Select("select count(date_format(atteTime,'%T')) from attered where empno = #{empno} and date_format(atteTime,'%m') = #{month} and (date_format(atteTime,'%T')>12 and date_format(atteTime,'%T')<17 );")
    int getLeaveEarlier(@Param("empno") int empno,@Param("month") int month);


    //判断员工在此月是否有请假
    @Select("select count(leaveId) from leaves where empno = #{empno} and date_format(leaveTime,'%m') = #{month}")
    int isLeaveTime(@Param("empno") int empno,@Param("month") int month);
    //员工请假天数（半天）
    @Select("select sum(days)*2 from leaves where leaveId in (select leaveId from leaves where empno = #{empno} and date_format(leaveTime,'%m') = #{month})")
    int gerLeaveTime(@Param("empno") int empno,@Param("month") int month);



    //判断员工在此月是否有批准天数
    @Select("select count(leaveId) from leaveapproval where leaveId in (select leaveId  from leaves where empno= #{empno} and date_format(leaveTime,'%m') = #{month}) and state=0")
    int isLeaveApproval(@Param("empno") int empno,@Param("month") int month);
    @Select("select sum(days)*2 from leaves where leaveId in (select leaveId from leaveapproval where leaveId in (select leaveId  from leaves where empno= #{empno} and date_format(leaveTime,'%m') = #{month}) and state=0)")
    //传入empno得到---员工请假批准天数（半天）
    int getApprovalTime(@Param("empno") int empno,@Param("month") int month);




    //获得report表中的所有信息
    @Select("select empno,ename,deptno,clockIn,normalClockIn,later,leaveEarlier,later,approvalTime" +
            " from report")
    List<Report> getReport();

    //获得report表中的所有信息
    @Select("select empno,ename,deptno,clockIn,normalClockIn,later,leaveEarlier,later,approvalTime" +
            " from report where date_format(rDate,'%m') = #{month} and date_format(rDate,'%Y') = #{year}")
    List<Report> getReportByMY(@Param("month") int month, @Param("year") int year);

}
