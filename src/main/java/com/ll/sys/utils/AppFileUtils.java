package com.ll.sys.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Properties;

/**
 * @author: 柒木Cat
 * @date: 2021/6/10 12:44
 */

public class AppFileUtils {
    /**
     * 文件上传路径
     * */
    public static String PATH="E:/大三下/软件工程/upload/";
    static {
        InputStream stream = AppFileUtils.class.getClassLoader().getResourceAsStream("file.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
            PATH = properties.getProperty("path");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 文件下载
     * @param response
     * @param path
     * @param oldName
     * @return
     * */
    public static ResponseEntity<Object> downloadFile(HttpServletResponse response,String path,String oldName){
        //使用绝对路径+相对路径去查找文件对象
        File file = new File(AppFileUtils.PATH,path);
        //判断文件是否存在
        if (file.exists()){
            try {
                try {
                    //如果有中文 要处理编码
                    oldName = URLEncoder.encode(oldName,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //把file转换成一个bytes
                byte[] bytes = FileUtils.readFileToByteArray(file);
                HttpHeaders httpHeaders = new HttpHeaders();
                //封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
                httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                //设置下载的文件的名称
                httpHeaders.setContentDispositionFormData("attachment", oldName);
                //创建ResponseEntity对象
                ResponseEntity<Object> entity=
                        new ResponseEntity<Object>(bytes,httpHeaders,HttpStatus.CREATED);
                return entity;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }else{
            PrintWriter out;
            try {
                out = response.getWriter();
                out.write("文件不存在");
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * 根据相对路径删除文件
     * @param path
     * */
    public static void deleteFileUsePath(String path) {
        String realPath=PATH+path;
        //根据文件
        File file=new File(realPath);
        if(file.exists()) {
            file.delete();
        }
    }

    /**
     * 更改文件名
     * @param carimg
     * @param suffix
     */
    public static String updateFileName(String carimg,String suffix) {
        //找到文件
        try{
            File file = new File(PATH,carimg);
            if (file.exists()){
                file.renameTo(new File(PATH,carimg.replace(suffix,"")));
                return carimg.replace(suffix,"");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据路径删除图片
     * @param carimg
     */
    public static void removeFileByPath(String carimg) {
        //找到文件
        try{
            File file = new File(PATH,carimg);
            if (file.exists()){
                file.delete();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
