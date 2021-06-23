package com.ll.bus.mapper;


import com.ll.bus.domain.Car;
import com.ll.bus.vo.CarVo;


import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 10:13
 */

public interface CarMapper {

    int deleteByPrimaryKey(String carnumber);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(String carnumber);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    List<Car> queryAllCar(CarVo carVo);

}
