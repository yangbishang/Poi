package com.ygoa.util;

import com.ygoa.dao.EmpMapper;
import com.ygoa.dao.ReportMapper;
import com.ygoa.pojo.Employees;
import com.ygoa.pojo.Report;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ExtractExcel {

    @Autowired
    private  EmpMapper empMapper;

    @Autowired
    private ReportMapper reportMapper;

    public  String[] createExcel(HttpSession httpSession) throws Exception {

        String[] results = new String[2];

        //获取存入数据库的date
        long millis = System.currentTimeMillis()-2147483646;

        /**
         * 手动设置数据库存入时间
         */
        //millis = millis-450000000;


        Date nowTime = new Date(millis-450000000);       //因为要存上个月的时间，所以要减30天（2592000000毫秒）
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String time = simpleDateFormat.format(nowTime);
        Date rDate = simpleDateFormat.parse(time);  //util.data的类型



        //时间信息
        Calendar cal = Calendar.getInstance();
        int yyyy = cal.get(Calendar.YEAR);
        yyyy=yyyy+0;
        int mm = cal.get(Calendar.MONTH)+1; //当前月份
        int lastmm ;
        if(mm-1==0){               //当前月份为1月时，上月为12
            lastmm = 12;
        }else{
            lastmm = mm-1;
        }

        /**
         * 手动改变excel报表生成月份
         */
        //lastmm = 5;


        //excel名字以时间名字命名
        String timeName = String.valueOf(yyyy)+String.valueOf(lastmm)+".xlsx";
        //获得保存文件目录的绝对路径
        String path=httpSession.getServletContext().getRealPath("excel");

        //先查看保存位置是否已经有上月报表，有就不再生成表，直接return文件地址，没有就生成表
        File file = new File(path);
        String[] files = file.list();
        for(int j = 1 ; j<files.length; j++){
            if(files[j].equals(timeName)){
                System.out.println("拦截啦"); //
                results[0] = path+"\\"+timeName;
                results[1] = "yes";
                return results;
            }
        }

        System.out.println("没有拦截啊！");
        //生成excel类的内容
        Workbook wb = new XSSFWorkbook();             //定义一个新的工作薄
        XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();   //样式
        Sheet sheet = wb.createSheet("第一个sheet页");
        sheet.setColumnWidth(4, 3400);         //设置第4列宽度
        sheet.setColumnWidth(5, 2500);         //设置第5列宽度
        sheet.setColumnWidth(7, 4000);         //设置第7列宽度
        sheet.setColumnWidth(8, 4000);         //设置第8列宽度

        //第一行
        Row row = sheet.createRow(0);
        row.createCell(4).setCellValue(lastmm+"月考勤报表");
        sheet.addMergedRegion(new CellRangeAddress(0,0,4,5 ));  //合并单元格




        //第二行
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        int handTime = 0;
        /**
         * 手动改变excel报表生成时间
         */
        //handTime = 1728000000;

        sheet.createRow(1).createCell(0).setCellValue("表生成时间："+simpleDateFormat1.format(new Date(System.currentTimeMillis()-handTime)));


        //第三行
        String[] header = new String[]{
                "员工编号","员工姓名","员工部门","打卡次数","正常打卡次数","迟到次数","早退次数","请假天数(半天)","批准天数(半天)"
        };

        row = sheet.createRow(2); //创建一个行
        for(int n=0; n<header.length ; n++){
            row.createCell(n).setCellValue(header[n]);
        }

       //第四行开始向excel表(0,1 列)和数据库report表中添加数据 (empno,ename,rDate)

        List<Employees> empList ;
        empList = empMapper.findAll01();
        //建一个数组专门存empno;
        List<Integer> empnos = new ArrayList<Integer>();

        for(int n=0+3 ; n<empList.size()+3;n++){

            System.out.println("1循环第"+(n-2));//test
            //获取Empno和ename和deptno
            int empno = empList.get(n-3).getEmpNo();
            String ename = empList.get(n-3).geteName();
            int deptno = empList.get(n-3).getDeptNo();

            empnos.add(empno);

            //向第 0,1,2 列输入数据empno和ename;
            row = sheet.createRow(n);
            row.createCell(0).setCellValue(empno);
            row.createCell(1).setCellValue(ename);
            row.createCell(2).setCellValue(deptno);
            reportMapper.addEmpnoEname(empno,ename,deptno,rDate);    //同时输入到数据库中

            //向第 3 列输入数据ClockIn

            int intMonth = lastmm;     //获得上一个月---5
            //根据传入员工编号和月份得到此编号员工在此月的打卡次数
            int clockIn = reportMapper.getClockIn(empno, lastmm);
            row.createCell(3).setCellValue(clockIn);


            //向第 4 列输入数据normalClockIn
            int normalClockIn = reportMapper.getNormalClockIn(empno,lastmm);
            row.createCell(4).setCellValue(normalClockIn);


            //向第 5 列输入数据later
            int later = reportMapper.getLater(empno,lastmm);
            row.createCell(5).setCellValue(later);

            //向第 6 列输入数据leaveEarlier
            int leaveEarlier = reportMapper.getLeaveEarlier(empno,lastmm);
            row.createCell(6).setCellValue(leaveEarlier);

            //向第 7 列输入数据leaveTime
            //先判断是否有请假，有请假就计算请假天数然后注入，否则注入0
            int flag = reportMapper.isLeaveTime(empno,lastmm);
            int leaveTime = 0;
            if(flag>0){
                leaveTime = reportMapper.gerLeaveTime(empno,lastmm);
                row.createCell(7).setCellValue(leaveTime);
            }else{
                row.createCell(7).setCellValue(leaveTime);
            }


            //向第 8 列输入数据approvalTime
            //先判断是否有批准，有批准就计算批准天数然后注入，否则注入0
            flag = reportMapper.isLeaveApproval(empno,lastmm);
            int approvalTime = 0;
            if(flag>0){
                approvalTime = reportMapper.getApprovalTime(empno,lastmm);
                row.createCell(8).setCellValue(approvalTime);
            }else{

                row.createCell(8).setCellValue(0);
            }
            System.out.println("2循环第"+(n-2));//test
            //将数据更新到数据库
            reportMapper.updateReport(clockIn,normalClockIn,later,leaveEarlier,leaveTime,approvalTime,empno,rDate);
            System.out.println("3循环第"+(n-2));//test
        }

        //基本的信息输入完成后，就把excel导出到target的excel下
        path = path+"\\"+timeName;
        FileOutputStream fileOut = new FileOutputStream(path);
        wb.write(fileOut);
        fileOut.close();

        results[0] = path;
        results[1] ="no";
        return results;

/*


        //从表格里面获取empno,然后再查其他数据,把数据更新到excel和数据库中
        InputStream in = new FileInputStream(path);
        XSSFWorkbook wb01 = new XSSFWorkbook(in);
        XSSFSheet sheet01 = wb01.getSheetAt(0);

        for(int rowNum=3 ; rowNum < sheet01.getLastRowNum() ; rowNum++){
            XSSFRow row01 = sheet01.getRow(rowNum);
            if(row01 == null){
                continue;
            }
            XSSFCell cell01 = row01.getCell(0);
            String empnoS = String.valueOf(cell01);    //String.valueOf(cell01)会得到xxxx.0,因为cell01就是xxx.0
            empnoS = StringUtils.substringBeforeLast(empnoS,".");
            int empno = Integer.valueOf(empnoS);       //获得员工编号
            String month = timeName.substring(5,7);   //获得月份String---06
            int intMonth = Integer.valueOf(month)-1;     //获得上一个月---5
            month = String.valueOf(intMonth);
            //根据传入员工编号和月份得到此编号员工在此月的打卡次数
            int ClockIn = reportMapper.getClockIn(empno,intMonth);

*/
/*            //将打卡次数导入excel---1,2,3,4步骤
            sheet.createRow(rowNum).createCell(2).setCellValue(ClockIn);
           // 1）首先要创建一个原始Excel文件的输出流对象！
            FileOutputStream out = new FileOutputStream(path);
            // 2）将最新的 Excel 文件写入到文件输出流中，更新文件信息！

            wb.write(out);
            out.flush();
            out.close();*//*

        }
*/














    }


}
