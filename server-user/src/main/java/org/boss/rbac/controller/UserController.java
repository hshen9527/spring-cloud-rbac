package org.boss.rbac.controller;

import lombok.extern.slf4j.Slf4j;
import org.boss.rbac.pojo.dto.UserDTO;
import org.boss.rbac.pojo.vo.LoginFormVO;
import org.boss.rbac.pojo.vo.RegisterFormVO;
import org.boss.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.rmi.log.LogInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到index.html
     * 判断session中存了用户登录信息没
     * 存了只填username
     *
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/login")
    public String login(Model model, HttpSession session){
        // index.html需要一个loginForm来存储登录信息
        model.addAttribute("loginForm", new LoginFormVO());
        return "/login";
    }

    /**
     * 实现用户注册
     *
     * @param model
     * @return
     */
    @GetMapping("/register")
    public String register(Model model){
        // register.html需要一个registerForm来存储注册信息
        model.addAttribute("registerForm", new RegisterFormVO());
        return "/register";
    }


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
    public String login(@ModelAttribute("loginForm") LoginFormVO loginForm, Model model, HttpSession session){
        if (!(loginForm.getUsername().equals("") || loginForm.getPassword().equals(""))){
            UserDTO userDTO = userService.query(loginForm.getUsername());
            if (userDTO.getPassword().equals(loginForm.getPassword())){
                model.addAttribute("user", userDTO);
                session.setAttribute("user", userDTO);
                return "/main";
            } else {
                return "/test";
            }
        } else {
            return "/test";
        }
    }

    /**
     * 实现用户注册功能
     *
     * @param registerForm
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/account/register")
    public String register(@ModelAttribute("registerForm") RegisterFormVO registerForm, Model model, HttpSession session){
        System.out.println(registerForm.getRole());

        return "/login";
    }
}
