package org.boss.rbac.pojo.dto;

import org.boss.rbac.pojo.po.RoleMenu;
import org.boss.rbac.pojo.po.UserPO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {

    private String username;

    private String password;

    private String role;

    private List<String> menus = new ArrayList<>();

    public UserDTO(UserPO userPO){
        this.username = userPO.getUsername();
        this.password = userPO.getPassword();
        this.role = userPO.getRole();
    }

    public UserDTO(UserPO userPO, List<RoleMenu> roleMenus){
        this.username = userPO.getUsername();
        this.password = userPO.getPassword();
        this.role = userPO.getRole();
        // 增加判断， 防止下标溢出
        if(roleMenus.size() != 0){
            for (int i=0; i<roleMenus.size(); i++){
                menus.add(String.valueOf(roleMenus.get(i).getMenu()));
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getMenus() {
        return menus;
    }

    public void setMenus(List<String> menus) {
        this.menus = menus;
    }
}
