package com.ll.bus.service;


import com.ll.bus.domain.Car;
import com.ll.bus.vo.CarVo;
import com.ll.sys.utils.DataGridView;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 9:38
 *
 * 车辆服务管理的接口
 */

public interface CarService {
    /**
     * 查询所有车辆
     * @param carVo
     * @return
     * */
    DataGridView queryAllCar(CarVo carVo);

    /**
     * 添加车辆
     * @param carVo
     * */
    void addCar(CarVo carVo);

    /**
     * 修改车辆
     * @param carVo
     * */
    void updateCar(CarVo carVo);

    /**
     * 根据id删除车辆
     * @param carnumber
     * */
    void deleteCar(String carnumber);

    /**
     * 批量删除车辆
     * @param carnumbers
     * */
    void deleteBatchCar(String[] carnumbers);

    /**
     * 根据车牌号查询
     * @param carnumber
     * @return
     * */
    Car queryCarByCarNumber(String carnumber);

}
