package org.boss.rbac.controller;

import lombok.extern.slf4j.Slf4j;
import org.boss.rbac.pojo.dto.UserDTO;
import org.boss.rbac.pojo.vo.UserQueryVO;
import org.boss.rbac.pojo.vo.UserAddVO;
import org.boss.rbac.pojo.vo.UserEditVO;
import org.boss.rbac.service.RoleService;
import org.boss.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 实现用户登录功能
     * HttpServletRequest request
     *
     * @param loginForm
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/account/login")
    public String login (@ModelAttribute("loginForm") UserQueryVO loginForm,
                        Model model, HttpSession session){
        if (!(loginForm.getUsername().equals("") || loginForm.getPassword().equals(""))){
            UserDTO userDTO = userService.queryUser(loginForm.getUsername());
            if (userDTO.getPassword().equals(loginForm.getPassword())){
                model.addAttribute("user", userDTO);
                session.setAttribute("user", userDTO);
                return "/main";
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }

    /**
     * 实现用户注册功能
     * 用户完成注册后跳转到主界面
     *
     * @param registerForm
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/account/register")
    public String register (@ModelAttribute("registerForm") UserAddVO registerForm,
                           Model model, HttpSession session){
        if (registerForm.getPassword().equals(registerForm.getRpassword())){
            UserDTO userDTO = new UserDTO(registerForm);
            userService.addUser(userDTO);
            userDTO.setMenus(roleService.menuList(userDTO.getRole()));
            model.addAttribute("user", userDTO);
            session.setAttribute("user", userDTO);
            return "/main";
        }else {
            return "/error";
        }
    }

    /**
     * 实现用户修改信息
     * 这里比较粗糙主要书实现修改功能
     *
     * @param updateForm
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/account/update")
    public String update (@ModelAttribute("updateForm") UserEditVO updateForm,
                         Model model, HttpSession session){
        UserDTO userDTO = new UserDTO(updateForm);
        userService.editUser(userDTO);
        userDTO.setMenus(roleService.menuList(userDTO.getRole()));
        model.addAttribute("user", userDTO);
        session.setAttribute("user", userDTO);
        return "/main";
    }
}
