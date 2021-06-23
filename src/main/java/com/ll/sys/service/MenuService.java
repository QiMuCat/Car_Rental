package com.ll.sys.service;


import com.ll.sys.domain.Menu;
import com.ll.sys.utils.DataGridView;
import com.ll.sys.vo.MenuVo;

import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 13:40
 *
 * 菜单管理服务接口
 */

public interface MenuService {
    /**
     * 查询所有的菜单返回List
     * @param menuVo
     * @return
     * */
    List<Menu> queryAllMenuForList(MenuVo menuVo);

    /**
     *根据用户id查询用户可用菜单
     * */
    List<Menu> queryMenuByUserIdForList(MenuVo menuVo,Integer userid);

    /**
     * 查询所有菜单
     * @param menuVo
     * @return
     * */
    DataGridView queryAllMenu(MenuVo menuVo);

    /**
     * 添加菜单
     * */
    void addMenu(MenuVo menuVo);

    /**
     *修改菜单
     * */
    void updateMenu(MenuVo menuVo);

    /**
     *更加pid查询菜单的数量
     * */
    Integer queryMenuByPid(Integer pid);

    /**
     * 删除菜单
     * @param menuVo
     * */
    void deleteMenu(MenuVo menuVo);



}
