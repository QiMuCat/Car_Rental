package com.ll.sys.service;



import com.ll.sys.domain.Role;
import com.ll.sys.utils.DataGridView;
import com.ll.sys.vo.RoleVo;

import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 13:57
 *
 *角色管理接口
 */

public interface RoleService {
    /**
     * 查询所有角色返回
     * @param roleVo
     * @return
     * */
    List<Role> queryAllRoleForList(RoleVo roleVo);

    /**
     * 根据用户id查询用户的可用角色
     * @param roleVo
     * @param userId
     * @return
     * */
    List<Role> queryRoleByUserIdForList(RoleVo roleVo,Integer userId);

    /**
     * 查询所有角色
     * @param roleVo
     * @return
     * */
    DataGridView queryAllRole(RoleVo roleVo);

    /**
     * 添加角色
     * @param roleVo
     * */
    void addRole(RoleVo roleVo);

    /**
     * 修改角色
     * @param roleVo
     * */
    void updateRole(RoleVo roleVo);

    /**
     * 根据id删除角色
     * @param roleid
     * */
    void deleteRole(Integer roleid);

    /**
     * 批量删除角色
     * @param ids
     * */
    void deleteBatchRole(Integer[] ids);

    /**
     * 加载角色管理分配菜单的json
     * @param roleid
     * @return
     * */
    DataGridView initRoleMenuTreeJson(Integer roleid);

    /**
     * 保存角色和菜单的关系
     * @param roleVo
     * */
    void saveRoleMenu(RoleVo roleVo);




}
