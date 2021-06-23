package com.ll.sys.task;


import com.ll.sys.constant.SysConstant;
import com.ll.sys.utils.AppFileUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 9:14
 *
 * @EnableScheduling
 * 开启定时器任务
 *
 * @Scheduled
 * 声明执行的定时认为
 */

@Component
@EnableScheduling
public class RecycleTempFileTask {
    /**
     * 每天晚上12点执行
     *
     * */
    @Scheduled(cron = "0 0 0 * * ?")
    public void recycleTempFile(){
        File file = new File(AppFileUtils.PATH);
    }

    /**
     * 删除图片
     *
     * */
    public void deleteFile(File file){
        if (null != file){
            File[] listFile = file.listFiles();
            if (null != listFile && listFile.length>0){
                for (File file1 : listFile){
                    if (file1.getName().endsWith(SysConstant.FILE_UPLOAD_TEMP)){
                        file1.delete();
                    }else {
                        deleteFile(file1);
                    }
                }
            }
        }
    }

}
