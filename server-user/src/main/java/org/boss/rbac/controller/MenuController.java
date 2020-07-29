package org.boss.rbac.controller;

import lombok.extern.slf4j.Slf4j;
import org.boss.rbac.pojo.dto.MenuDTO;
import org.boss.rbac.pojo.po.MenuPO;
import org.boss.rbac.pojo.vo.MenuAddVO;
import org.boss.rbac.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 添加menu
     *
     * @param menuAddVO
     * @return
     */
    @PostMapping("/menu/add")
    public String add(@RequestBody MenuAddVO menuAddVO){
        menuService.add(new MenuDTO(menuAddVO));
        return "添加Menu成功";
    }

    /**
     * 删除menu
     *
     * @param menu
     * @return
     */
    @PostMapping("/menu/delete")
    public String delete(@RequestParam("menu") String menu){
        menuService.delete(menu);
        return "删除Menu"+menu+"成功";
    }

}
