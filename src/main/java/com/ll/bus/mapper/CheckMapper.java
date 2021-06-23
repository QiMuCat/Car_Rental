package com.ll.bus.mapper;


import com.ll.bus.domain.Check;


import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 10:22
 */

public interface CheckMapper {
    int deleteByPrimaryKey(String checkid);

    int insert(Check record);

    int insertSelective(Check record);

    Check selectByPrimaryKey(String checkid);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);

    List<Check> queryAllCheck(Check check);


}
