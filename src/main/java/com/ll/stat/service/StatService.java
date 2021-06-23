package com.ll.stat.service;

import com.ll.stat.domain.BaseEntity;

import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 14:22
 *
 * 统计分析数据服务接口
 */

public interface StatService {
    /**
     * 查询客户地区数据
     * @return
     */
    List<BaseEntity> loadCustomerAreaStatList();

    /**
     * 查询客户地区性别数据
     * @return
     * @param area
     */
    List<BaseEntity> loadCustomerAreaSexStatList(String area);

    /**
     * 业务员年度销售额数据
     * @return
     */
    List<BaseEntity> loadOpernameYearGradeStatList(String year);

    /**
     * 公司年度月份销售数据
     * @param year
     * @return
     */
    List<Double> loadCompanyYearGradeStatList(String year);
}
