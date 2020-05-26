package com.lxf.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间 字符 转换工具类
 */


public class DateUtils {

    // 字符串转时间类型
    public static Date string2Date(String dateStr, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date date = sdf.parse(dateStr);

        return date;
    }
    // 时间类型转字符串
    public static String date2String(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
}
