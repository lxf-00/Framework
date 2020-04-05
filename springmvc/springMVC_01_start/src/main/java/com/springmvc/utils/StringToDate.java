package com.springmvc.utils;

import com.sun.tools.javac.util.Convert;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器
 */
public class StringToDate implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if(source == null){
            // 数据为空
            throw new RuntimeException("数据为空.....");
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
