package org.boss.rbac.service.impl;

import org.boss.rbac.persistence.RoleMapper;
import org.boss.rbac.persistence.UserMapper;
import org.boss.rbac.pojo.dto.RoleDTO;
import org.boss.rbac.pojo.dto.UserDTO;
import org.boss.rbac.pojo.po.MenuPO;
import org.boss.rbac.pojo.po.RolePO;
import org.boss.rbac.pojo.po.UserPO;
import org.boss.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 前端传入UserDTO, 将其转换成PO，进入持久化层
     * 实现增加用户的功能
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public boolean addUser(UserDTO user) {
        UserPO userPO = new UserPO();
        userPO.setUsername(user.getUsername());
        userPO.setPassword(user.getPassword());
        userPO.setRole(user.getRole());
        return userMapper.add(userPO);
    }

    /**
     * 实现查询功能
     *
     * @param username 用户名称
     * @return
     */
    @Override
    public UserDTO queryUser(String username) {
        UserPO userPO = userMapper.query(username);
        List<MenuPO> list = roleMapper.menuList(userPO.getRole());
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(userPO.getUsername());
        userDTO.setPassword(userPO.getPassword());
        userDTO.setRole(userPO.getRole());
        userDTO.setMenus(list);
        return userDTO;
    }

    /**
     * 实现用户修改
     *
     * @param user 用户修改后的信息
     * @return
     */
    @Override
    public boolean editUser(UserDTO user) {
        UserPO userPO = new UserPO();
        userPO.setUsername(user.getUsername());
        userPO.setPassword(user.getPassword());
        userPO.setRole(user.getRole());
        return userMapper.edit(userPO);
    }
}
