package org.boss.rbac.pojo.dto;

import org.boss.rbac.pojo.vo.RoleAddVO;

import java.util.Arrays;
import java.util.List;

public class RoleDTO {

    private String role;
    private List<String> list;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public RoleDTO(RoleAddVO roleAdd){
        this.role = roleAdd.getRole();
        this.list = Arrays.asList(roleAdd.getMenus().split(","));
    }
}
