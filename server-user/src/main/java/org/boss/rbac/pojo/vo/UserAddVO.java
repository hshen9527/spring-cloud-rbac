package org.boss.rbac.pojo.vo;

import lombok.Data;

@Data
public class UserAddVO {
    private String username;
    private String password;
    private String rpassword;
    private String role;
}
