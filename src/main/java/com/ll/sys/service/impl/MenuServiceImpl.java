package com.ll.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.ll.sys.domain.Menu;
import com.ll.sys.mapper.MenuMapper;
import com.ll.sys.service.MenuService;
import com.ll.sys.utils.DataGridView;
import com.ll.sys.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 17:47
 */

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询全部菜单
     * @param menuVo
     * @return
     * */
    @Override
    public List<Menu> queryAllMenuForList(MenuVo menuVo) {
        return menuMapper.queryAllMenu(menuVo);
    }

    /**
     * 权限管理完成后回来操作
     * @param userid
     * @param menuVo
     * @return
     * */
    @Override
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userid) {
        return menuMapper.queryMenuByUid(menuVo.getAvailable(),userid);
    }

    /**
     * 查询所有菜单的实现类
     * @param menuVo
     * @return
     * */
    @Override
    public DataGridView queryAllMenu(MenuVo menuVo) {
        Page<Object> page = PageHelper.startPage(menuVo.getPage(),menuVo.getLimit());
        List<Menu> data = this.menuMapper.queryAllMenu(menuVo);
        System.out.println("data = " + data);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加菜单
     * @param menuVo
     * */
    @Override
    public void addMenu(MenuVo menuVo) {
        this.menuMapper.insertSelective(menuVo);
    }

    /**
     * 修改菜单
     * @param menuVo
     * */
    @Override
    public void updateMenu(MenuVo menuVo) {
        this.menuMapper.updateByPrimaryKeySelective(menuVo);
    }

    /**
     * 根据pid查询菜单的数量
     * @param pid
     * */
    @Override
    public Integer queryMenuByPid(Integer pid) {
        return this.menuMapper.queryMenuByPid(pid);
    }

    /**
     * 删除菜单
     * @param menuVo
     * */
    @Override
    public void deleteMenu(MenuVo menuVo) {
        //删除菜单的数据
        this.menuMapper.deleteByPrimaryKey(menuVo.getId());
        //根据id删除sys_role_menu里面的数据
        this.menuMapper.deleteRoleMnuByMid(menuVo.getId());
    }
}
