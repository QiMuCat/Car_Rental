package com.ll.bus.mapper;


import com.ll.bus.domain.Customer;


import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 10:32
 */
public interface CustomerMapper {
    int deleteByPrimaryKey(String identity);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String identity);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> queryAllCustomer(Customer customer);
}
