package com.ll.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ll.bus.mapper.CarMapper;
import com.ll.bus.mapper.CheckMapper;
import com.ll.bus.mapper.CustomerMapper;
import com.ll.bus.mapper.RentMapper;
import com.ll.bus.domain.Car;
import com.ll.bus.domain.Check;
import com.ll.bus.domain.Customer;
import com.ll.bus.domain.Rent;
import com.ll.bus.service.CheckService;
import com.ll.bus.vo.CheckVo;
import com.ll.sys.constant.SysConstant;
import com.ll.sys.domain.User;
import com.ll.sys.utils.DataGridView;
import com.ll.sys.utils.RandomUtils;
import com.ll.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 10:57
 *
 * 检查单
 */

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    private CheckMapper checkMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private RentMapper rentMapper;

    @Autowired
    private CarMapper carMapper;

    /**
     * 根据出租车单号加载检测单的表单数据
     * @param rentid
     * @return
     * */
    @Override
    public Map<String, Object> initCheckFormData(String rentid) {
        //查询出租单
        Rent rent = this.rentMapper.selectByPrimaryKey(rentid);
        //查询客户
        Customer customer = this.customerMapper.selectByPrimaryKey(rent.getIdentity());
        //查询车辆
        Car car = this.carMapper.selectByPrimaryKey(rent.getCarnumber());
        //组装Check
        Check check = new Check();
        check.setCheckid(RandomUtils.createRandomStringUseTime(SysConstant.CAR_ORDER_JC));
        check.setRentid(rentid);
        check.setCheckdate(new Date());
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        check.setOpername(user.getRealname());
        Map<String,Object> map = new HashMap<>();
        map.put("rent",rent);
        map.put("customer",customer);
        map.put("car",car);
        map.put("check",check);
        return map;
    }

    /**
     * 添加检查单数据
     * @param checkVo
     * */
    @Override
    public void addCheck(CheckVo checkVo) {
        this.checkMapper.insertSelective(checkVo);
        //更改出租单状态
        Rent rent = this.rentMapper.selectByPrimaryKey(checkVo.getCheckid());
        //更改为已归还
        rent.setRentflag(SysConstant.RENT_BACK_TRUE);
        this.rentMapper.updateByPrimaryKeySelective(rent);
        //更改汽车状态
        Car car = this.carMapper.selectByPrimaryKey(rent.getCarnumber());
        //更改汽车状态为未出租
        car.setIsrenting(SysConstant.RENT_CAR_FALSE);
        this.carMapper.updateByPrimaryKeySelective(car);

    }

    /**
     * 查询所有出租单
     * @param checkVo
     * */
    @Override
    public DataGridView queryAllCheck(CheckVo checkVo) {
        Page<Object> page = PageHelper.startPage(checkVo.getPage(),checkVo.getLimit());
        List<Check> data = this.checkMapper.queryAllCheck(checkVo);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 删除检查单
     * @param checkVo
     * */
    @Override
    public void deleteCheck(CheckVo checkVo) {
        this.checkMapper.deleteByPrimaryKey(checkVo.getCheckid());
    }

    /**
     * 批量删除检查单
     * @param ids
     * */
    @Override
    public void deleteBatchCheck(String[] ids) {
        for (String id : ids){
            this.checkMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 修改检查单
     * @param checkVo
     * */
    @Override
    public void updateCheck(CheckVo checkVo) {
        this.checkMapper.updateByPrimaryKeySelective(checkVo);
    }
}
