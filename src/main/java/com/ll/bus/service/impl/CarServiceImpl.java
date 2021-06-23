package com.ll.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.ll.bus.domain.Car;
import com.ll.bus.mapper.CarMapper;
import com.ll.bus.service.CarService;
import com.ll.bus.vo.CarVo;
import com.ll.sys.constant.SysConstant;
import com.ll.sys.utils.AppFileUtils;
import com.ll.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 10:47
 */

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    /**
     * 查询所有车辆信息
     * @param carVo
     * @return
     * */
    @Override
    public DataGridView queryAllCar(CarVo carVo) {
        Page<Object> page = PageHelper.startPage(carVo.getPage(),carVo.getLimit());
        List<Car> data = this.carMapper.queryAllCar(carVo);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加车辆
     * @param carVo
     * */
    @Override
    public void addCar(CarVo carVo) {
        this.carMapper.insertSelective(carVo);
    }

    /**
     * 修改车辆
     * @param carVo
     * */
    @Override
    public void updateCar(CarVo carVo) {
        this.carMapper.updateByPrimaryKeySelective(carVo);
    }

    /**
     * 删除车辆
     * @param carnumber
     * */
    @Override
    public void deleteCar(String carnumber) {
        Car car = this.carMapper.selectByPrimaryKey(carnumber);
        if (!car.getCarimg().equals(SysConstant.DEFAULT_CAR_IMG)){
            AppFileUtils.deleteFileUsePath(car.getCarimg());
        }
        this.carMapper.deleteByPrimaryKey(carnumber);
    }

    /**
     * 批量删除车辆
     * @param carnumbers
     * */
    @Override
    public void deleteBatchCar(String[] carnumbers) {
        for (String carnumber : carnumbers){
            this.deleteCar(carnumber);
        }
    }

    /**
     * 根据车牌号查询信息
     * @param carnumber
     * @return
     * */
    @Override
    public Car queryCarByCarNumber(String carnumber) {
        return this.carMapper.selectByPrimaryKey(carnumber);
    }
}
