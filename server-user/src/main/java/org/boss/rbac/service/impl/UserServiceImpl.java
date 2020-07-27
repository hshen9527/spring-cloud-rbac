package org.boss.rbac.service.impl;

import org.boss.rbac.persistence.RoleMapper;
import org.boss.rbac.persistence.UserMapper;
import org.boss.rbac.persistence.UserRoleMenuMapper;
import org.boss.rbac.pojo.dto.UserDTO;
import org.boss.rbac.pojo.po.RoleMenu;
import org.boss.rbac.pojo.po.UserPO;
import org.boss.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMenuMapper userRoleMenuMapper;

    /**
     * 获得加密用户信息
     *
     * @param username 用户名
     * @return 这里用DTO中加密后的UserDTO
     */
//    @Override
//    public UserDTO getUser(String username) {
//        // 假设这里取出的账号密码是加密的
//        // 在后续加入加密功能
//        return new UserDTO(userMapper.getUser(username));
//    }

    /**
     * 获得用户基本信息及所代表的角色
     *
     * @param username 用户名称
     * @return
     */
    @Override
    public UserPO getUser(String username) {
        return userMapper.getUser(username);
    }

    /**
     * 获得角色可见的Menu菜单
     *
     * @param role 角色名称
     * @return
     */
    @Override
    public List<RoleMenu> getlist(String role) {
        return roleMapper.getlist(role);
    }

//    @Override
//    public UserDTO getUserRoleMenu(String username, String role) {
//        return userRoleMenuMapper.getUserRoleMenu(username, role);
//    }
}
