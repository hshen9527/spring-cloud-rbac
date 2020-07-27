package org.boss.rbac.persistence;

import org.apache.ibatis.annotations.Param;
import org.boss.rbac.pojo.po.UserPO;

public interface UserMapper {

    UserPO getUser(@Param("username") String username);

}
