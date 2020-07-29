package org.boss.rbac.pojo.dto;

import org.boss.rbac.pojo.po.MenuPO;
import org.boss.rbac.pojo.vo.UserAddVO;
import org.boss.rbac.pojo.vo.UserEditVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {

    private String username;
    private String password;
    private String role;

    private List<MenuPO> menus = new ArrayList<>();

    public UserDTO(){}

    public UserDTO(UserAddVO userAddVO){
        this.username = userAddVO.getUsername();
        this.password = userAddVO.getPassword();
        this.role = userAddVO.getRole();
    }

    public UserDTO(UserEditVO userEditVO){
        this.username = userEditVO.getUsername();
        this.password = userEditVO.getPassword();
        this.role = userEditVO.getRole();
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

    public List<MenuPO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuPO> menus) {
        this.menus = menus;
    }
}
