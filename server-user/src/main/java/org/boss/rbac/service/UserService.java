package org.boss.rbac.service;

import org.apache.ibatis.annotations.Param;
import org.boss.rbac.pojo.dto.RoleDTO;
import org.boss.rbac.pojo.dto.UserDTO;
import org.boss.rbac.pojo.po.MenuPO;
import org.boss.rbac.pojo.po.UserPO;

import java.util.List;

public interface UserService {

    // 增加用户信息
    boolean addUser(UserDTO user);

    // 根据用户名获得用户登录信息
    UserDTO queryUser(String username);

    // 修改用户信息
    boolean editUser(UserDTO user);
}
