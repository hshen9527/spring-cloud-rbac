package org.boss.rbac.persistence;

import org.apache.ibatis.annotations.Param;
import org.boss.rbac.pojo.po.MenuPO;

import java.util.List;

/**
 * Menu作为前端可视资源
 */
public interface MenuMapper {

    // 增加Menu
    boolean add(@Param("menu") MenuPO menuPO);

    // 批量增加Menu
    boolean addList(@Param("menuList") List<MenuPO> list);

    // 跟新Menu
    boolean update(@Param("menu") MenuPO menuPO);

    // 删除Menu
    boolean delete(@Param("menu") MenuPO menuPO);
}
