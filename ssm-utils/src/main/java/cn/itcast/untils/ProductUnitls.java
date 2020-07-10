package cn.itcast.untils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductUnitls {


    /* 日期转换成字符串的形式*/
    public static String dateString(Date date, String patt)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
       /* 转换成字符串的形式*/
        String format = sdf.format(date);
        return format;
    }
    /*字符串转换成日期的形式*/
    public Date dateString(String str,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        /*强制转换成时间的形式*/
        Date parse = sdf.parse(str);
        return parse;
    }
}
