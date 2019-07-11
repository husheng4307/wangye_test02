package com.husheng.wangye_test.controller;


import com.husheng.wangye_test.model.UserDomain;
import com.husheng.wangye_test.service.user.UserService;
import com.husheng.wangye_test.utils.utils;
import io.swagger.annotations.Api;
import org.apache.ibatis.jdbc.Null;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@Api("用户注销接口")
@Controller
public class LogonController {


    @Autowired
    UserService userService;

    @RequiresRoles("xxx")
    @GetMapping("/user/logon")
    public String logon(Model model) {
        Subject subject = SecurityUtils.getSubject();

        if (subject.hasRole("xxx")) {
            return "logon";
        }
        model.addAttribute("msg","没有角色xxx");
        return "login";
    }

    @PostMapping("/user/logon")
    public String toLogon(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = "username", required = true)
                    String username,
            @RequestParam(name = "password", required = true)
                    String password
    ) {
        if (password.isEmpty() || username.isEmpty()) {
            request.setAttribute("msg", "用户名密码错误");
//            map.put("msg", "用户名密码错误");
//            map.put("msg", "用户名密码错误");
            return "login";
        }

        String pwd = utils.MD5encode(username + password);
        if (userService.setUserByNameAndPassword(username, pwd)) {
            try {
                response.sendRedirect("/user/logout");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "sss";
    }

}
