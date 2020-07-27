package org.boss.rbac.pojo.po;

import java.io.Serializable;

public class RoleMenu implements Serializable {

    private String role;

    private String menu;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
