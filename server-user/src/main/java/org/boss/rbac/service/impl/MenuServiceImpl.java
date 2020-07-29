package org.boss.rbac.service.impl;

import org.boss.rbac.persistence.MenuMapper;
import org.boss.rbac.pojo.dto.MenuDTO;
import org.boss.rbac.pojo.po.MenuPO;
import org.boss.rbac.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 增加menu
     *
     * @param menuDTO
     * @return
     */
    @Override
    public boolean add(MenuDTO menuDTO) {
        // function 1
        for (int i=0; i<menuDTO.getList().size(); i++){
            MenuPO menuPO = new MenuPO();
            menuPO.setMenu(menuDTO.getList().get(i));
            menuMapper.add(menuPO);
        }
        return true;

        // function2
//        List<MenuPO> list = new ArrayList<>(menuDTO.getList().size());
//        for (int i=0; i<list.size(); i++){
//            MenuPO menuPO = new MenuPO();
//            menuPO.setMenu(menuDTO.getList().get(i));
//            list.add(menuPO);
//        }
//        return menuMapper.addList(list);
    }

    @Override
    public boolean delete(String menu) {
        return menuMapper.delete(menu);
    }
}
