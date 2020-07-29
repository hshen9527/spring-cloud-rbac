package org.boss.rbac.pojo.vo;

import lombok.Data;

@Data
public class UpdateFormVO {
    private String username;
    private String password;
    private String role;
}
