package com.ll.sys.mapper;


import com.ll.sys.domain.LogInfo;


import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 14:27
 *
 *
 */

public interface LogInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogInfo record);

    int insertSelective(LogInfo record);

    LogInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogInfo record);

    int updateByPrimaryKey(LogInfo record);

    /**
     * 查询日志
     * @param logInfo
     * @return
     * */
    List<LogInfo> queryAllLogInfo(LogInfo logInfo);

}
