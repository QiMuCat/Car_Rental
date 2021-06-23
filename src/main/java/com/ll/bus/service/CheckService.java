package com.ll.bus.service;



import com.ll.bus.vo.CheckVo;
import com.ll.sys.utils.DataGridView;

import java.util.Map;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 9:47
 *
 * 检查单服务管理接口
 */

public interface CheckService {
    /**
     * 根据出租车单号加载检测单的表单数据
     * @param rentid
     * @return
     * */
    Map<String,Object> initCheckFormData(String rentid);

    /**
     * 保存检查单数据
     * @param checkVo
     * */
    void addCheck(CheckVo checkVo);

    /**
     * 查询所有检查单
     * @param checkVo
     * @return
     * */
    DataGridView queryAllCheck(CheckVo checkVo);

    /**
     * 删除检查单
     * @param checkVo
     * */
    void deleteCheck(CheckVo checkVo);

    /**
     * 批量删除检查单
     * @param ids
     * */
    void deleteBatchCheck(String[] ids);

    /**
     * 修改检查单
     * @param checkVo
     * */
    void updateCheck(CheckVo checkVo);




}
