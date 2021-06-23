package com.ll.sys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 9:42
 * 随机工具类
 */
public class RandomUtils {
    private static SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
    private static Random random = new Random();

    /**
     * 得到当前日期
     * */
    public static String getCurrentDateForString(){
        return simpleDateFormat1.format(new Date());
    }

    /**
     * 生成文件使用时间+4位随机数
     * @param fileName  文件名称
     * */
    public static String createFileNameUseTime(String fileName){
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        String time = simpleDateFormat2.format(new Date());
        Integer num = random.nextInt(9000)+1000;
        return time+num+fileSuffix;
    }

    /**
     * 生成文件名使用时间+4位随机数
     * @param fileName  文件名称
     * @param suffix    临时文件的后缀
     * */
    public static String createFileNameUseTime(String fileName,String suffix){
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        String time = simpleDateFormat2.format(new Date());
        Integer num = random.nextInt(9000)+1000;
        return time+num+fileSuffix+suffix;
    }

    /**
     * 生成文件名的UUID
     * @param fileName  文件名称
     * */
    public static String createFileNameUseUUID(String fileName){
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        return UUID.randomUUID().toString().replace("-","").toUpperCase()+fileSuffix;
    }

    /**
     * 根据时间+5位随机数生产字符串
     * @param preffx
     * @return
     * */
    public static String createRandomStringUseTime(String preffx){
        return preffx+"_"+simpleDateFormat3.format(new Date())+"_"+(random.nextInt(90000)+10000);
    }


}
