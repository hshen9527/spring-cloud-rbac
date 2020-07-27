package org.boss.rbac.controller;

import org.boss.rbac.pojo.dto.UserDTO;
import org.boss.rbac.pojo.po.RoleMenu;
import org.boss.rbac.pojo.po.UserPO;
import org.boss.rbac.pojo.vo.UserVO;
import org.boss.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到index.html
     * @return
     */
    @GetMapping("/user")
    public String login(){
        return "/login";
    }

    /**
     * 获取前端表格传来的账号密码信息
     * 进行登录的一个判断
     *
     * @param request
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/user/login")
    public String login(HttpServletRequest request, Model model, HttpSession session){
        // 这里密码应加密
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!(username.equals("") || password.equals(""))){
            if (check(userService.getUser(username).getPassword(), password)){
                // 判断用户角色，取得用户权限
                UserDTO userDTO = new UserDTO(userService.getUser(username), userService.getlist(userService.getUser(username).getRole()));
                UserVO userVO = new UserVO(userDTO);
                model.addAttribute("user", userDTO);
                return "/main";
            } else {
                model.addAttribute("msg", "账号或密码错误");
                return "/login";
            }
        } else {
            model.addAttribute("msg", "账号密码不能为空");
            return "/login";
        }
    }

    // 由于密码进行了加密这里要用function进行判断
    private boolean check(String userPass, String password){
        if (userPass.equals(password)){
            return true;
        } else {
            return false;
        }
    }

//    @ResponseBody
//    @PostMapping("/login2")
//    public String login2(HttpServletRequest request, Model model, HttpSession session) {
//        // 这里密码应加密
//
//        UserDTO userDTO = userService.getUserRoleMenu("张三", "employee");
//        return String.valueOf(JSONObject.parseObject(String.valueOf(userDTO)));
//    }
}
