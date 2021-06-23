package com.ll.sys.controller;

import com.ll.sys.constant.SysConstant;
import com.ll.sys.utils.AppFileUtils;
import com.ll.sys.utils.DataGridView;
import com.ll.sys.utils.RandomUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 20:16
 *
 * 文件上传下载控制器
 */

@Controller
@RequestMapping("file")
public class FileController {
    /**
     * 上传
     * @throws IllegalStateException
     * @throws IOException
     * */
    @RequestMapping("uploadFile")
    @ResponseBody
    public DataGridView uploadFile(MultipartFile multipartFile) throws IllegalStateException,IOException {
        //文件上传的父目录
        String parentPath = AppFileUtils.PATH;
        //得到当前日期作为文件夹的名称
        String dirName = RandomUtils.getCurrentDateForString();
        //构造文件夹对象
        File dirFile = new File(parentPath,dirName);
        if (!dirFile.exists()){
            dirFile.mkdirs();//创建文件夹
        }
        //获取文件原名
        String oldName = multipartFile.getOriginalFilename();
        //根据文件原名获取新名
        String newName = RandomUtils.createFileNameUseTime(oldName, SysConstant.FILE_UPLOAD_TEMP);
        File dest = new File(dirFile,newName);
        multipartFile.transferTo(dest);

        Map<String,Object> map = new HashMap<>();
        map.put("src",dirName+"/"+newName);
        return new DataGridView(map);
    }

    /**
     * 未设置下载(有显示)
     * */
    @RequestMapping("downloadShowFile")
    public ResponseEntity<Object> downloadShowFile(String path, HttpServletResponse response){
        return AppFileUtils.downloadFile(response,path,"");
    }

    /**
     * 下载图片
     *
     * */
    public ResponseEntity<Object> downloadFile(String path,HttpServletResponse response){
        return AppFileUtils.downloadFile(response,path,"");
    }

}
