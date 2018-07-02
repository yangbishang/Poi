package com.ygoa.controller;

import com.ygoa.util.ExtractExcel;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;

@Controller
public class FileController {
    @Autowired
    private ExtractExcel extractExcel;

    @RequestMapping("/downloadExcel")
    public ResponseEntity<byte[]> create(HttpSession httpSession) throws Exception {
        //先检查文件库是否有上月报表，如果有上月报表，就提示上月报表已经生成

        String[] results = extractExcel.createExcel(httpSession);

        String loadPath = results[0];
        String existExcel = results[1];
        System.out.println(loadPath+existExcel);

        //定义下载的文件对象
        File file=new File(loadPath);
        //响应头部数据对象
        HttpHeaders headers=new HttpHeaders();
        //定义响应内容类型为流
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //通知浏览器以附件形式保存文件
        String fileName = StringUtils.substringAfterLast(loadPath,"\\");
        System.out.println(fileName);
        headers.setContentDispositionFormData("attachment",fileName);

        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);

    }




    @RequestMapping(value = "/getReportInfo",method= RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> getReportInfo(HttpSession httpSession){
        HashMap<String, Object> modelMap = new HashMap<>();
        int flag = 0;
        //获得保存文件目录的绝对路径
        String excelPath = httpSession.getServletContext().getRealPath("excel");
        File file = new File(excelPath);
        String[] fileNames = file.list();
        for(int n=0; n<fileNames.length ; n++){

            int point = fileNames[n].indexOf(".");
            String year = fileNames[n].substring(0,4);
            String month = fileNames[n].substring(4,point);
            //判断是否是10,11,12月份

            Calendar cal = Calendar.getInstance();
            int lastMonth = cal.get(Calendar.MONTH+1-1);
            String lastMonthS = String.valueOf(lastMonth);
            if(year.equals("2018") && month.equals(lastMonthS)){     //要实测month
                flag = 1;
                System.out.println(year+","+month);   //test
                break;
            }
        }
        //在session中放入flag
        httpSession.setAttribute("flag",flag);
        modelMap.put("flag",flag);
        return  modelMap;
    }



    @RequestMapping(value="/createExcel",method= RequestMethod.POST)
    @ResponseBody
    public HashMap<String,String> downLoad(HttpSession httpSession) throws Exception {
        HashMap<String,String> modelMap = new HashMap<>();


        //先检查文件库是否有上月报表，如果有上月报表，就提示上月报表已经生成
        String[] results = extractExcel.createExcel(httpSession);

        String loadPath = results[0];
        String existExcel = results[1];
        modelMap.put("mess",results[1]);

        return modelMap;

    }


    @RequestMapping("/downloadByMonth")
    public ResponseEntity<byte[]> downloadByMonth(@RequestParam("month") int month, @RequestParam("year") int year, HttpSession httpSession) throws Exception {

        String path = httpSession.getServletContext().getRealPath("excel");

        String fileName = String.valueOf(year).trim()+String.valueOf(month).trim()+".xlsx";
        String loadPath = path+"\\"+fileName;

        System.out.println("哈哈哈"+loadPath);  //test

/*        //判断是否有此文件,有flag=1，没有flag=0
        File file1 = new File(path);
        String[] files = file1.list();
        System.out.println(fileName);    //test
        for(int i=0 ;i<files.length;i++ ){
            if(files[i].trim().equals(fileName.trim())){
                flag = 1;
                break;
            }
        }

        if(flag == 0){
            modelMap.put("mess","no");
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }*/

        //定义下载的文件对象
        File file=new File(loadPath);
        //响应头部数据对象
        HttpHeaders headers=new HttpHeaders();
        //定义响应内容类型为流
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //通知浏览器以附件形式保存文件
        fileName = StringUtils.substringAfterLast(loadPath,"\\");
        System.out.println(fileName);   //test
        headers.setContentDispositionFormData("attachment",fileName);
        System.out.println("到这一步了");//test
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);

    }


    //下载方法


}
