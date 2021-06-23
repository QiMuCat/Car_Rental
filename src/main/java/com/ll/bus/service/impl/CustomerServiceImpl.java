package com.ll.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ll.bus.mapper.CustomerMapper;
import com.ll.bus.domain.Customer;
import com.ll.bus.service.CustomerService;
import com.ll.bus.vo.CustomerVo;
import com.ll.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 11:18
 *
 * 客户信息管理
 */

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询所有客户信息
     * @param customerVo
     * @return
     * */
    @Override
    public DataGridView queryAllCustomer(CustomerVo customerVo) {
        Page<Object> page = PageHelper.startPage(customerVo.getPage(),customerVo.getLimit());
        List<Customer> data = this.customerMapper.queryAllCustomer(customerVo);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加客户信息
     * @param customerVo
     * */
    @Override
    public void addCustomer(CustomerVo customerVo) {
        this.customerMapper.insertSelective(customerVo);
    }

    /**
     * 修改客户信息
     * @param customerVo
     * */
    @Override
    public void updateCustomer(CustomerVo customerVo) {
        this.customerMapper.updateByPrimaryKeySelective(customerVo);
    }

    /**
     * 删除客户信息
     * @param identity
     * */
    @Override
    public void deleteCustomer(String identity) {
        this.customerMapper.deleteByPrimaryKey(identity);
    }

    /**
     * 批量删除客户信息
     * @param identitys
     * */
    @Override
    public void deleteBatchCustomer(String[] identitys) {
        for (String identity : identitys){
            this.deleteCustomer(identity);
        }
    }

    /**
     * 根据身份证查询客户
     * @param identity
     * @return
     * */
    @Override
    public Customer queryCustomerByIdentity(String identity) {
        return this.customerMapper.selectByPrimaryKey(identity);
    }

    /**
     * 查询所有客户数据
     * @param customerVo
     * @return
     * */
    @Override
    public List<Customer> queryAllCustomerForList(CustomerVo customerVo) {
        return this.customerMapper.queryAllCustomer(customerVo);
    }
}
