package com.ll.sys.controller;

import com.ll.sys.service.LogInfoService;
import com.ll.sys.utils.DataGridView;
import com.ll.sys.utils.ResultObj;
import com.ll.sys.vo.LogInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 21:29
 *
 * 日志管理控制器
 */

@RestController
@RequestMapping("logInfo")
public class LogInfoController{
    @Autowired
    private LogInfoService logInfoService;

    /**
     * 加载日志列表DataGridView
     * @param logInfoVo
     * @return
     * */
    @RequestMapping("loadAllLogInfo")
    public DataGridView loadAllLogInfo(LogInfoVo logInfoVo){
        return this.logInfoService.queryAllLogInfo(logInfoVo);
    }

    /**
     * 删除一条日志
     * @param logInfoVo
     * @return
     * @throws Exception
     * */
    @RequestMapping("deleteLogInfo")
    public ResultObj deleteLogInfo(LogInfoVo logInfoVo){
        try {
            this.logInfoService.deleteLogInfo(logInfoVo.getId());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除日志
     * */
    @RequestMapping("deleteBatchLogInfo")
    public ResultObj deleteBatchLogInfo(LogInfoVo logInfoVo){
        try {
            this.logInfoService.deleteBatchLogInfo(logInfoVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}
