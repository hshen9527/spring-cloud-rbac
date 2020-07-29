package org.boss.rbac.pojo.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPO implements Serializable {

    private String username;
    private String password;
    private String role;
}
