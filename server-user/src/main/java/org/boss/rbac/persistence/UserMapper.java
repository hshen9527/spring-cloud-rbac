package org.boss.rbac.persistence;

import org.apache.ibatis.annotations.Param;
import org.boss.rbac.pojo.po.UserPO;

/**
 * 定义用户接口
 */
public interface UserMapper {

    // 增加用户信息
    boolean add(@Param(("user")) UserPO user);

    // 根据用户名获得用户登录信息
    UserPO query(@Param("username") String username);

    // 修改用户信息
    boolean edit(@Param("user") UserPO user);

}
