package com.ll.sys.service;


import com.ll.sys.domain.User;
import com.ll.sys.utils.DataGridView;
import com.ll.sys.vo.UserVo;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 14:13
 *
 * 用户服务接口
 */

public interface UserService {
    /**
     * 用户登录
     * @param userVo
     * @return
     * */
    User login(UserVo userVo);
    /**
     * 查询所有用户
     * @param userVo
     * */
    DataGridView queryAllUser(UserVo userVo);
    /**
     * 添加用户
     * @param userVo
     * */
    void addUser(UserVo userVo);

    /**
     * 修改用户
     * @param userVo
     * */
    void updateUser(UserVo userVo);
    /**
     * 根据id删除用户
     * @param userid
     * */
    void deleteUser(Integer userid);

    /**
     * 批量删除用户
     * @param ids
     * */
    void deleteBatchUser(Integer[] ids);

    /**
     * 重置密码
     * @param userid
     * */
    void resetUserPwd(Integer userid);
    /**
     * 加载用户管理分配角色数据
     * @param userid
     * @return
     * */
    DataGridView queryUserRole(Integer userid);

    /**
     * 保存用户和角色关系
     * @param userVo
     * */
    void saveUserRole(UserVo userVo);

}
