package com.husheng.wangye_test.controller;


import com.husheng.wangye_test.model.UserDomain;
import com.husheng.wangye_test.service.user.UserService;
import com.husheng.wangye_test.utils.utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@Api("登录相关接口")
public class LoginControll {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginControll.class);

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录", httpMethod = "POST", response = String.class)
//    @PostMapping("/user/login")
//    public String toLogin(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            @RequestParam(name = "username", required = true)
//                    String username,
//            @RequestParam(name = "password", required = true)
//                    String password,
//            Map<String, Object> map,
//            HttpSession session
//    ) {
//        String pwd = utils.MD5encode(username + password);
//        UserDomain userInfo = userService.getUserByNameAndPassword(username, pwd);
//        if (userInfo == null) {
//            map.put("msg", "用户名密码错误");
//            map.put("msg", "用户名密码错误");
//            return "login";
//        } else {
//            session.setAttribute("loginUser", username);
//            return "redirect:/main.html";
//        }
//    }

    @PostMapping("/user/login")
    public String toLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = "username", required = true)
                    String username,
            @RequestParam(name = "password", required = true)
                    String password,
            Model model,
            HttpSession session
    ) {
//        String pwd = utils.MD5encode(username + password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不存在");
            return "login";

        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }

    @ApiOperation(value = "登出", httpMethod = "GET")
    @GetMapping(value = "/user/logout")
    public void toLogout(HttpServletRequest request,
                         HttpServletResponse response
    ) {
        request.getSession().removeAttribute("loginUser");
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("注销失败", e);
        }
    }

    @ApiOperation(value = "无权限访问", httpMethod = "GET")
    @GetMapping("/noAuth")
    public String noAuth(){
        return "noAuth";
    }

    @GetMapping("/test")
    public String shouye(){
        return "login";
    }
}
