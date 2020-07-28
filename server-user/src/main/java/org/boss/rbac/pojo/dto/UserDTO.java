package org.boss.rbac.pojo.dto;

import lombok.Data;
import org.boss.rbac.pojo.po.MenuPO;
import org.boss.rbac.pojo.po.UserPO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO implements Serializable {

    private String username;

    private String password;

    private String role;

    private List<MenuPO> menus = new ArrayList<>();

}
