package org.boss.rbac.service.impl;

import org.boss.rbac.persistence.RoleMapper;
import org.boss.rbac.pojo.dto.RoleDTO;
import org.boss.rbac.pojo.po.MenuPO;
import org.boss.rbac.pojo.po.RolePO;
import org.boss.rbac.service.RoleService;
import org.boss.rbac.service.adapter.RoleUpdateAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 增加角色信息
     *
     * @param role 角色信息
     * @return
     */
    @Override
    public boolean add(RoleDTO role) {
        for (int i=0; i<role.getList().size(); i++){
            RolePO rolePO = new RolePO();
            rolePO.setRole(role.getRole());
            rolePO.setMenu(role.getList().get(i));
            roleMapper.add(rolePO);
        }
        return true;
    }

    /**
     * 批量增加角色信息
     *
     * @param role 角色信息
     * @return
     */
    @Override
    public boolean addList(RoleDTO role) {
        List<RolePO> list = new ArrayList<>(role.getList().size());
        for (int i=0; i<list.size(); i++){
            RolePO rolePO = new RolePO();
            rolePO.setRole(role.getRole());
            rolePO.setMenu(role.getList().get(i));
            list.add(rolePO);
        }
        return roleMapper.addList(list);
    }

    /**
     * 修改角色信息（修改user-role表）
     *
     * @param role 角色信息
     * @return
     */
    @Override
    public boolean update(RoleDTO role) {
        return RoleUpdateAdapter.update1(roleMapper, role);
    }

    /**
     * 删除角色信息
     *
     * @param role 角色信息
     * @return
     */
    @Override
    public boolean deleteRole(String role) {
        return roleMapper.delete(role);
    }

    /**
     * 根据用户角色获得用户menu信息
     *
     * @param role
     * @return
     */
    @Override
    public List<MenuPO> menuList(String role) {
        return roleMapper.menuList(role);
    }
}
