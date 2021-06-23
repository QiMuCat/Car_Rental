package com.ll.stat.mapper;

import com.ll.stat.domain.BaseEntity;


import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 14:21
 */

public interface StatMapper {
    /**
     * 查询客户地区的数据
     * @return
     */
    List<BaseEntity> queryCustomerAreaStat();

    /**
     * 查询客户地区性别数据
     * @return
     * @param area
     */
    List<BaseEntity> queryCustomerAreaSexStat(String area);


    /**
     * 查询业务员年度业绩
     * @param year
     * @return
     */
    List<BaseEntity> queryOpernameYearGradeStat(String year);

    /**
     * 查询公司年度业务销售额数据
     * @param year
     * @return
     */
    List<Double> queryCompanyYearGradeStat(String year);
}
