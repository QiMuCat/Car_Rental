package com.ll.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ll.bus.mapper.CarMapper;
import com.ll.bus.mapper.RentMapper;
import com.ll.bus.domain.Car;
import com.ll.bus.domain.Rent;
import com.ll.bus.service.RentService;
import com.ll.bus.vo.RentVo;
import com.ll.sys.constant.SysConstant;
import com.ll.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 11:30
 *
 * 出租信息管理
 */

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public void addRent(RentVo rentVo) {
        this.rentMapper.insertSelective(rentVo);
        //更改车辆出租的状态
        Car car = new Car();
        car.setCarnumber(rentVo.getCarnumber());
        //设置状态为已出租
        car.setIsrenting(SysConstant.RENT_BACK_TRUE);
        carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public DataGridView queryAllRent(RentVo rentVo) {
        Page<Object> page = PageHelper.startPage(rentVo.getPage(),rentVo.getLimit());
        List<Rent> data = this.rentMapper.queryAllRent(rentVo);
        return new DataGridView(page.getTotal(),data);
    }


    @Override
    public void updateRent(RentVo rentVo) {
        this.rentMapper.updateByPrimaryKeySelective(rentVo);
    }

    @Override
    public void deleteRent(String rentid) {
        //更改汽车状态，将已出租的状态转换成未出租的状态
        Rent rent = this.rentMapper.selectByPrimaryKey(rentid);
        Car car = new Car();
        car.setCarnumber(rent.getCarnumber());
        //转换成未出租的状态
        car.setIsrenting(SysConstant.RENT_CAR_FALSE);
        carMapper.updateByPrimaryKeySelective(car);
        this.rentMapper.deleteByPrimaryKey(rentid);
    }

    /**
     * 根据出租单好查询出租单信息
     * @param rentid
     * @return
     */
    @Override
    public Rent queryRentByRentId(String rentid) {
        return this.rentMapper.selectByPrimaryKey(rentid);
    }

}
