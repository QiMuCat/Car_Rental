package com.ll.bus.mapper;


import com.ll.bus.domain.Rent;

import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 10:39
 */

public interface RentMapper {
    int deleteByPrimaryKey(String identity);

    int insert(Rent record);

    int insertSelective(Rent record);

    Rent selectByPrimaryKey(String identity);

    int updateByPrimaryKeySelective(Rent record);

    int updateByPrimaryKey(Rent record);

    List<Rent> queryAllRent(Rent rent);
}
