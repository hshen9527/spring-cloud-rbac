package org.boss.rbac.service;

import org.apache.ibatis.annotations.Param;
import org.boss.rbac.pojo.dto.UserDTO;
import org.boss.rbac.pojo.po.RoleMenu;
import org.boss.rbac.pojo.po.UserPO;

import java.util.List;

public interface UserService {

    UserPO getUser(String username);

    List<RoleMenu> getlist(String role);

//    UserDTO getUserRoleMenu(String username, String role);
}
