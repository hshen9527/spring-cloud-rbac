package org.boss.rbac.service.adapter;

import org.boss.rbac.persistence.RoleMapper;
import org.boss.rbac.pojo.dto.RoleDTO;
import org.boss.rbac.pojo.po.RolePO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RoleUpdateAdapter {

    /**
     * 非批量
     *
     * @param roleMapper
     * @param role
     */
    public static boolean update1(RoleMapper roleMapper, RoleDTO role){
        roleMapper.delete(role.getRole());
        for (int i=0; i<role.getList().size(); i++){
            RolePO rolePO = new RolePO();
            rolePO.setRole(role.getRole());
            rolePO.setMenu(role.getList().get(i));
            roleMapper.add(rolePO);
        }
        return true;
    };

    /**
     * 批量
     *
     * @param roleMapper
     * @param role
     */
    public static boolean update2(RoleMapper roleMapper, RoleDTO role){
        List<RolePO> roleList = new ArrayList<>(role.getList().size());
        for (int i=0; i<role.getList().size(); i++){
            RolePO rolePO = new RolePO();
            rolePO.setRole(role.getRole());
            rolePO.setMenu(role.getList().get(i));
        }
        return (roleMapper.delete(role.getRole()) && roleMapper.addList(roleList));
    };
}
