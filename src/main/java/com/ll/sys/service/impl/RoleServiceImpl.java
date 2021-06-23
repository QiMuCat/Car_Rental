package com.ll.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.ll.sys.constant.SysConstant;
import com.ll.sys.domain.Menu;
import com.ll.sys.domain.Role;
import com.ll.sys.mapper.MenuMapper;
import com.ll.sys.mapper.RoleMapper;
import com.ll.sys.service.RoleService;
import com.ll.sys.utils.DataGridView;
import com.ll.sys.utils.TreeNode;
import com.ll.sys.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 18:08
 */

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询所有角色返回
     * @param roleVo
     * @return
     * */
    @Override
    public List<Role> queryAllRoleForList(RoleVo roleVo) {
        return roleMapper.queryAllRole(roleVo);
    }

    /**
     * 根据id查询角色
     * @param roleVo
     * @param userId
     * */
    @Override
    public List<Role> queryRoleByUserIdForList(RoleVo roleVo, Integer userId) {
        return roleMapper.queryAllRole(roleVo);
    }

    /**
     * 查询所有角色列表
     * @param roleVo
     * @return
     * */
    @Override
    public DataGridView queryAllRole(RoleVo roleVo) {
        Page<Object> page = PageHelper.startPage(roleVo.getPage(),roleVo.getLimit());
        List<Role> data = this.roleMapper.queryAllRole(roleVo);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加角色
     * @param roleVo
     * */
    @Override
    public void addRole(RoleVo roleVo) {
        this.roleMapper.insertSelective(roleVo);
    }

    /**
     * 修改角色
     * */
    @Override
    public void updateRole(RoleVo roleVo) {
        this.roleMapper.updateByPrimaryKeySelective(roleVo);
    }

    /**
     * 根据角色roleid单个删除角色
     * */
    @Override
    public void deleteRole(Integer roleid) {
        //删除角色表的数据
        this.roleMapper.deleteByPrimaryKey(roleid);
        //根据角色id删除sys_role_menu里面的数据
        this.roleMapper.deleteRoleMenuByRid(roleid);
        //根据角色id删除sys_role_user里面的数据
        this.roleMapper.deleteRoleUserByRid(roleid);
    }

    /**
     * 批量删除角色
     * @param ids
     * */
    @Override
    public void deleteBatchRole(Integer[] ids) {
        for (Integer rid:ids){
            deleteRole(rid);
        }
    }

    /**
     * 加载角色管理分配菜单的json
     * @param roleid
     * */
    @Override
    public DataGridView initRoleMenuTreeJson(Integer roleid) {
        //查询所有的可用菜单
        Menu menu = new Menu();
        menu.setAvailable(SysConstant.AVAILABLE_TRUE);
        List<Menu> allMenu = menuMapper.queryAllMenu(menu);
        //根据角色id查询当前角色拥有的菜单
        List<Menu> roleMenu = menuMapper.queryMenuByRoleId(SysConstant.AVAILABLE_TRUE,roleid);

        List<TreeNode> data = new ArrayList<>();
        for (Menu menu1 : allMenu){
            String checkArr = SysConstant.CODE_ZERO+"";
            for (Menu menu2 : roleMenu){
                if (menu1.getId() == menu2.getId()){
                    checkArr = SysConstant.CODE_ONE+"";
                    break;
                }
            }
            Integer id = menu1.getId();
            Integer pid = menu1.getPid();
            String title = menu1.getTitle();
            Boolean spread = menu1.getSpread() == SysConstant.SPREAD_TRUE ? true : false;
            data.add(new TreeNode(id,pid,title,spread,checkArr));
        }
        return new DataGridView(data);
    }

    /**
     * 保存角色和菜单的关系
     * @param roleVo
     **/
    @Override
    public void saveRoleMenu(RoleVo roleVo) {
        Integer rid = roleVo.getRoleid();
        Integer[] mids = roleVo.getIds();
        //根据rid删除sys_role_menu里面的所有数据
        this.roleMapper.deleteRoleMenuByRid(rid);

        for (Integer mid : mids){
            this.roleMapper.insertRoleMenu(rid,mid);
        }

    }
}
