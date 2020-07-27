package org.boss.rbac.persistence;

import org.apache.ibatis.annotations.Param;
import org.boss.rbac.pojo.po.RoleMenu;

import java.util.List;

public interface RoleMapper {
    List<RoleMenu> getlist(@Param("role") String role);
}
