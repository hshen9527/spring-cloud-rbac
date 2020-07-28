package org.boss.rbac.pojo.vo;

import lombok.Data;

@Data
public class RegisterFormVO {
    private String username;
    private String password;
    private String rpassword;
    private String role;
}
