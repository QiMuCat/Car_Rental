package com.ll.sys.service;


import com.ll.sys.utils.DataGridView;
import com.ll.sys.vo.LogInfoVo;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 12:07
 *
 * 日志管理服务接口
 */

public interface LogInfoService {
    /**
     * 查询所有日志
     * @param logInfoVo
     * @return
     * */
    DataGridView queryAllLogInfo(LogInfoVo logInfoVo);

    /**
     *添加日志
     * @param logInfoVo
     * */
    void addLogInfo(LogInfoVo logInfoVo);

    /**
     * 根据id删除日志
     * @param logInfoid
     * */
    void deleteLogInfo(Integer logInfoid);

    /**
     * 批量删除日志
     * @param ids
     * */
    void deleteBatchLogInfo(Integer[] ids);



}
