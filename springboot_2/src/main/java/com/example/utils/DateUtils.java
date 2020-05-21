package com.example.utils;


import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtils {

    // 时间字符转时间格式
    public static Date String2Date(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date date = sdf.parse(str);

        return date;
    }

    // 时间格式转字符
    public static String Date2String(Date date, String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String dateStr = sdf.format(date);

        return dateStr;
    }

}
