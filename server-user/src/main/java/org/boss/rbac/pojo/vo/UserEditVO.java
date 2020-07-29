package org.boss.rbac.pojo.vo;

import lombok.Data;

@Data
public class UserEditVO {
    private String username;
    private String password;
    private String role;
}
