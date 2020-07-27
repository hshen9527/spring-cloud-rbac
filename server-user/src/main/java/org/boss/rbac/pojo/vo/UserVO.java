package org.boss.rbac.pojo.vo;

import org.boss.rbac.pojo.dto.UserDTO;

import java.util.List;

public class UserVO {
    public String username;
    public String password;
    public List<String> menus;

    public UserVO(UserDTO userDTO){
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.menus = userDTO.getMenus();
    }
}
