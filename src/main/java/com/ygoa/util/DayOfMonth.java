package com.ygoa.util;

//一个月有多少天
public class DayOfMonth {
    public static int judge(int year , int month){

        int day=0;
        int leapDay ;

            //判断闰年，是的话leapDay=1，不是为0
            if((year%400)==0) {
                leapDay=1;
            }
            else {
                if((year%4)==0) {
                    if((year%100)!=0) {
                        leapDay=1;
                    }
                    else {
                        leapDay=0;
                    }
                }
                else {
                    leapDay=0;
                }
            }


        switch(month){
            case 1:             //31大
                day=31;
                break;
            case 2:             //28平
                day=28+leapDay;
                break;
            case 3:             //31大
                day=31;
                break;
            case 4:             //30小
                day=30;
                break;
            case 5:             //31大
                day=31;
                break;
            case 6:             //30小
                day=30;
                break;
            case 7:             //31大
                day=31;
                break;
            case 8:             //31大
                day=31;
                break;
            case 9:             //30小
                day=30;
                break;
            case 10:            //31大
                day=31;
                break;
            case 11:            //30小
                day=30;
                break;
            case 12:            //31大
                day=31;
                break;
        }

       return day;
    }
}
