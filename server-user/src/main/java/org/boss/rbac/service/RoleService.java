package org.boss.rbac.service;

import org.boss.rbac.pojo.dto.RoleDTO;
import org.boss.rbac.pojo.po.MenuPO;

import java.util.List;

public interface RoleService {

    // 增加角色信息
    boolean add(RoleDTO role);

    // 批量增加角色信息
    boolean addList(RoleDTO role);

    // 修改角色信息
    boolean update(RoleDTO role);

    // 删除角色信息
    boolean deleteRole(String role);

    // 根据用户角色role获得用户可操作的menu信息
    List<MenuPO> menuList(String role);

    // 根据用户角色role获得用户可进行的操作信息
//    List<OpreatePO> operateList(String role);

    // 根据用户角色role获得用户可访问的url信息
//    List<UrlPO> urlList(String role);

}
