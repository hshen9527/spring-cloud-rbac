package org.boss.rbac.service;

import org.apache.ibatis.annotations.Param;
import org.boss.rbac.pojo.dto.UserDTO;
import org.boss.rbac.pojo.po.MenuPO;
import org.boss.rbac.pojo.po.UserPO;

import java.util.List;

public interface UserService {

    // 增加用户信息
    boolean add(UserDTO user);

    // 根据用户名获得用户登录信息
    UserDTO query(String username);

    // 修改用户信息
    boolean edit(UserDTO user);

    // 根据用户角色role获得用户可操作的menu信息
    List<MenuPO> menuList(String role);

    // 根据用户角色role获得用户可进行的操作信息
//    List<OpreatePO> operateList(String role);

    // 根据用户角色role获得用户可访问的url信息
//    List<UrlPO> urlList(String role);

}
