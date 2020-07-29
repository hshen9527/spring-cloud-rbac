package org.boss.rbac.controller;

import lombok.extern.slf4j.Slf4j;
import org.boss.rbac.pojo.dto.RoleDTO;
import org.boss.rbac.pojo.vo.RoleAddVO;
import org.boss.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 增加角色role
     *
     * @param roleAddVO
     * @return
     */
    @PostMapping("/role/add")
    public String addRole (@RequestBody RoleAddVO roleAddVO){
//        roleService.addList(new RoleDTO(roleAddVO));
        // 这里应该用上面的方法
        // 批量增加出了点小问题
        roleService.add(new RoleDTO(roleAddVO));
        return "新增role成功";
    }

    /**
     * 修改role信息
     *
     * @param roleAddVO
     * @return
     */
    @PostMapping("/role/update")
    public String update (@RequestBody RoleAddVO roleAddVO){
//        roleService.update(new RoleDTO(roleAddVO));
        roleService.update(new RoleDTO(roleAddVO));
        return "更新role成功";
    }

    /**
     * 删除role信息
     *
     * @param
     */
    @PostMapping("/role/delete")
    public String delete (@RequestParam("role") String role){
        roleService.deleteRole(role);
        return "删除role成功";
    }
}
