package org.boss.rbac.pojo.vo;

import lombok.Data;

@Data
public class UpdatePassFormVO {
    private String username;
    private String password;
    private String rpassword;
    private String vcode; // 验证码
}
