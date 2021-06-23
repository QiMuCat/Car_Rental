package com.ll.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.ll.sys.domain.LogInfo;
import com.ll.sys.mapper.LogInfoMapper;
import com.ll.sys.service.LogInfoService;
import com.ll.sys.utils.DataGridView;
import com.ll.sys.vo.LogInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 14:26
 */

@Service
public class LogInfoServiceImpl implements LogInfoService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    /**
     * 查询所有日志
     * @param logInfoVo
     * @return
     * */
    @Override
    public DataGridView queryAllLogInfo(LogInfoVo logInfoVo) {
        Page<Object> page = PageHelper.startPage(logInfoVo.getPage(),logInfoVo.getLimit());
        List<LogInfo> data = this.logInfoMapper.queryAllLogInfo(logInfoVo);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加日志
     * @param logInfoVo
     * */
    @Override
    public void addLogInfo(LogInfoVo logInfoVo) {
        this.logInfoMapper.insertSelective(logInfoVo);
    }

    /**
     * 删除日志
     * @param logInfoid
     * */
    @Override
    public void deleteLogInfo(Integer logInfoid) {
        this.logInfoMapper.deleteByPrimaryKey(logInfoid);
    }

    /**
     * 批量删除日志
     * @param ids
     * */
    @Override
    public void deleteBatchLogInfo(Integer[] ids) {
        for (Integer id:ids){
            deleteLogInfo(id);
        }
    }
}
