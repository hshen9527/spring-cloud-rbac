package org.boss.rbac.persistence;

import org.apache.ibatis.annotations.Param;
import org.boss.rbac.pojo.po.MenuPO;

import java.util.List;

public interface RoleMapper {

    // 根据用户角色role获得用户可操作的menu信息
    List<MenuPO> menuList(@Param("role") String role);

    // 根据用户角色role获得用户可进行的操作信息
//    List<OpreatePO> operateList(@Param("role") String role);

    // 根据用户角色role获得用户可访问的url信息
//    List<UrlPO> urlList(@Param("role") String role);
}
