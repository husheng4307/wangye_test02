package com.husheng.wangye_test.controller;


import com.husheng.wangye_test.model.UserDomain;
import com.husheng.wangye_test.service.user.UserService;
import com.husheng.wangye_test.utils.utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @ApiOperation(value = "登录",httpMethod = "POST",response = String.class)
    @PostMapping("/user/login")
    public String toLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = "username", required = true)
                    String username,
            @RequestParam(name = "password", required = true)
                    String password,
            Map<String, Object> map,
                        HttpSession session
    ){
        String pwd = utils.MD5encode(username+password);
        UserDomain userInfo = userService.getUserByNameAndPassword(username,pwd);
        if (userInfo==null){
            map.put("msg", "用户名密码错误");
            map.put("msg", "用户名密码错误");
            return "login";
        }else{
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }
    }

    @ApiOperation(value = "登出",httpMethod = "GET")
    @GetMapping(value = "/user/logout")
    public void toLogout(  HttpServletRequest request,
                           HttpServletResponse response
                           ){
        request.getSession().removeAttribute("loginUser");
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("注销失败",e);
        }
    }
}
