package com.ll.bus.service;


import com.ll.bus.domain.Rent;
import com.ll.bus.vo.RentVo;
import com.ll.sys.utils.DataGridView;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 10:05
 *
 * 出租信息服务接口
 */

public interface RentService {
    /**
     * 查询出租单
     * @param rentVo
     * @return
     * */
    DataGridView queryAllRent(RentVo rentVo);

    /**
     * 添加出租单
     * @param rentVo
     * */
    void addRent(RentVo rentVo);

    /**
     * 修改出租单
     * @param rentVo
     * */
    void updateRent(RentVo rentVo);

    /**
     * 删除出租单
     * @param rentid
     * */
    void deleteRent(String rentid);

    /**
     * 根据出租单号查询出租单信息
     * @param rentid
     * @return s
     * */
    Rent queryRentByRentId(String rentid);


}
