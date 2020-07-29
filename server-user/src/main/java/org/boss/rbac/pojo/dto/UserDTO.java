package org.boss.rbac.pojo.dto;

import lombok.Data;
import org.boss.rbac.pojo.po.MenuPO;
import org.boss.rbac.pojo.po.UserPO;
import org.boss.rbac.pojo.vo.RegisterFormVO;
import org.boss.rbac.pojo.vo.UpdateFormVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {

    private String username;

    private String password;

    private String role;

    private List<MenuPO> menus = new ArrayList<>();

    public UserDTO(){}

    public UserDTO(RegisterFormVO registerFormVO){
        this.username = registerFormVO.getUsername();
        this.password = registerFormVO.getPassword();
        this.role = registerFormVO.getRole();
    }

    public UserDTO(UpdateFormVO updateFormVO){
        this.username = updateFormVO.getUsername();
        this.password = updateFormVO.getPassword();
        this.role = updateFormVO.getRole();
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
