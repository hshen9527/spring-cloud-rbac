package org.boss.rbac.controller;

import org.boss.rbac.pojo.vo.UserQueryVO;
import org.boss.rbac.pojo.vo.UserAddVO;
import org.boss.rbac.pojo.vo.UserEditVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

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
    public String login (Model model, HttpSession session){
        if (session.getAttribute("user") != null){
            model.addAttribute("user", session.getAttribute("user"));
            return "/main";
        }
        // index.html需要一个loginForm来存储登录信息
        model.addAttribute("loginForm", new UserQueryVO());
        return "/login";
    }

    /**
     * 实现用户注册
     *
     * @param model
     * @return
     */
    @GetMapping("/register")
    public String register (Model model){
        // register.html需要一个registerForm来存储注册信息
        model.addAttribute("registerForm", new UserAddVO());
        return "/register";
    }

    /**
     * 实现用户修改
     *
     * @param model
     * @return
     */
    @GetMapping("/update")
    public String update (Model model){
        model.addAttribute("updateForm", new UserEditVO());
        return "/update";
    }


}
