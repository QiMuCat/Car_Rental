package com.ll.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.ll.sys.constant.SysConstant;
import com.ll.sys.domain.Role;
import com.ll.sys.domain.User;
import com.ll.sys.mapper.RoleMapper;
import com.ll.sys.mapper.UserMapper;
import com.ll.sys.service.UserService;
import com.ll.sys.utils.DataGridView;
import com.ll.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 19:39
 *
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 用户登录
     * @param userVo
     * */
    @Override
    public User login(UserVo userVo) {
        //明文
        //生成密文
        String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
        userVo.setPwd(pwd);
        return userMapper.login(userVo);
    }

    /**
     * 查询所有用户
     * @param userVo
     * @return
     * */
    @Override
    public DataGridView queryAllUser(UserVo userVo) {
        Page<Object> page = PageHelper.startPage(userVo.getPage(),userVo.getLimit());
        List<User> data = this.userMapper.queryAllUser(userVo);
        return new DataGridView(page.getTotal(),data);
    }

    /**
     * 添加用户
     * @param userVo
     * */
    @Override
    public void addUser(UserVo userVo) {
        //设置默认密码
        userVo.setPwd(DigestUtils.md5DigestAsHex(SysConstant.USER_DEFAULT_PWD.getBytes()));
        //设置用户类型都是普通用户type=2
        userVo.setType(SysConstant.USER_TYPE_NORMAL);
        this.userMapper.insertSelective(userVo);
    }

    /**
     * 修改用户
     * @param userVo
     * */
    @Override
    public void updateUser(UserVo userVo) {
        this.userMapper.updateByPrimaryKeySelective(userVo);
    }

    /**
     * 删除用户
     * @param userid
     * */
    @Override
    public void deleteUser(Integer userid) {
        //先删除用户
        this.userMapper.deleteByPrimaryKey(userid);
        //根据用户id删除sys_role_user
        this.roleMapper.deleteRoleUserByRid(userid);
    }

    /**
     * 批量删除用户
     * @param ids
     * */
    @Override
    public void deleteBatchUser(Integer[] ids) {
        for (Integer uid : ids){
            this.deleteUser(uid);
        }
    }

    /**
     * 重置用户密码
     * @param userid
     * */
    @Override
    public void resetUserPwd(Integer userid) {
        User user = new User();
        user.setUserid(userid);
        //设置默认密码
        user.setPwd(DigestUtils.md5DigestAsHex(SysConstant.USER_DEFAULT_PWD.getBytes()));
        //设置完成后更新
        this.userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 加载用户管理的分配角色的数据
     * @param userid
     * @return
     * */
    @Override
    public DataGridView queryUserRole(Integer userid) {
        //查询所有可用的角色
        Role role = new Role();
        role.setAvailable(SysConstant.AVAILABLE_TRUE);
        List<Role> allRole = this.roleMapper.queryAllRole(role);
        //根据用户id查询已有的角色
        List<Role> userRole = this.roleMapper.queryRoleByUid(SysConstant.AVAILABLE_TRUE,userid);

        List<Map<String,Object>> data = new ArrayList<>();
        for (Role role1 : allRole){
            Boolean LAY_CHECKED = false;
            for (Role role2 : userRole){
                if (role1.getRoleid() == role2.getRoleid()){
                    LAY_CHECKED = true;
                }
            }
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("roleid",role1.getRoleid());
            map.put("rolename",role1.getRolename());
            map.put("roledesc",role1.getRoledesc());
            map.put("LAY_CHECKED",LAY_CHECKED);
        }
        return new DataGridView(data);
    }

    /**
     * 保存用户和角色的关系
     * */
    @Override
    public void saveUserRole(UserVo userVo) {
        Integer userid = userVo.getUserid();
        Integer[] roleIds = userVo.getIds();
        //根据用户id删除sys_role_user里面的数据
        this.roleMapper.deleteRoleUserByRid(userid);
        //保存关系
        if (roleIds != null && roleIds.length>0){
            for (Integer rid : roleIds){
                this.userMapper.insertUserRole(userid,rid);
            }
        }
    }

}
