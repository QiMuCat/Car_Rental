package com.ll.bus.service;



import com.ll.bus.domain.Customer;
import com.ll.bus.vo.CustomerVo;
import com.ll.sys.utils.DataGridView;

import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 9:58
 *
 * 客户信息接口
 */

public interface CustomerService {
    /**
     * 查询所有客户
     * @param customerVo
     * @return
     * */
    DataGridView queryAllCustomer(CustomerVo customerVo);

    /**
     * 添加客户
     * @param customerVo
     * */
    void addCustomer(CustomerVo customerVo);

    /**
     * 修改客户
     * @param customerVo
     * */
    void updateCustomer(CustomerVo customerVo);

    /**
     * 删除客户
     * @param identity
     * */
    void deleteCustomer(String identity);

    /**
     * 批量删除客户
     * @param identitys
     * */
    void deleteBatchCustomer(String[] identitys);

    /**
     * 根据身份证号码查询客户信息
     * @param identity
     * @return
     * */
    Customer queryCustomerByIdentity(String identity);

    /**
     * 查询客户数据返回集合
     * @param customerVo
     * @return
     * */
    List<Customer> queryAllCustomerForList(CustomerVo customerVo);
}
