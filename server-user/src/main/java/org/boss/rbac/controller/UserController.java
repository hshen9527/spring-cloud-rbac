package org.boss.rbac.controller;

import lombok.extern.slf4j.Slf4j;
import org.boss.rbac.pojo.dto.UserDTO;
import org.boss.rbac.pojo.vo.LoginFormVO;
import org.boss.rbac.pojo.vo.RegisterFormVO;
import org.boss.rbac.pojo.vo.UpdateFormVO;
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
        if (session.getAttribute("user") != null){
            model.addAttribute("user", session.getAttribute("user"));
            return "/main";
        }
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
     * 实现用户修改
     *
     * @param model
     * @return
     */
    @GetMapping("/update")
    public String update(Model model){
        model.addAttribute("updateForm", new UpdateFormVO());
        return "/update";
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
    public String login(@ModelAttribute("loginForm") LoginFormVO loginForm,
                        Model model, HttpSession session){
        if (!(loginForm.getUsername().equals("") || loginForm.getPassword().equals(""))){
            UserDTO userDTO = userService.query(loginForm.getUsername());
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
    public String register(@ModelAttribute("registerForm") RegisterFormVO registerForm,
                           Model model, HttpSession session){
        if (registerForm.getPassword().equals(registerForm.getRpassword())){
            UserDTO userDTO = new UserDTO(registerForm);
            userService.add(userDTO);
            userDTO.setMenus(userService.menuList(userDTO.getRole()));
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
     */
    @PostMapping("/account/update")
    public String update(@ModelAttribute("updateForm") UpdateFormVO updateForm,
                         Model model, HttpSession session){
        UserDTO userDTO = new UserDTO(updateForm);
        userService.edit(userDTO);
        userDTO.setMenus(userService.menuList(userDTO.getRole()));
        model.addAttribute("user", userDTO);
        session.setAttribute("user", userDTO);
        return "/main";
    }
}
