package org.boss.rbac.service;

import org.apache.ibatis.annotations.Param;
import org.boss.rbac.pojo.dto.MenuDTO;
import org.boss.rbac.pojo.po.MenuPO;

import java.util.List;

public interface MenuService {

    // 增加Menu
    boolean add(MenuDTO menuDTO);

    // 删除Menu
    boolean delete(String menu);
}
