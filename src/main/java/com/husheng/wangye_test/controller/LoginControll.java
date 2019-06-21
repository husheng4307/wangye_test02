package com.husheng.wangye_test.controller;


import com.husheng.wangye_test.mapper.UserMapper;
import com.husheng.wangye_test.model.UserDomain;
import com.husheng.wangye_test.utils.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller

public class LoginControll {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginControll.class);

    @Autowired
    UserMapper userMapper;

//    @PostMapping("/user/login")
//    public String login(@RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        Map<String, Object> map,
//                        HttpSession session) {
//
//        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
//            session.setAttribute("loginUser", username);
//            return "redirect:/main.html";
//        } else {
//
//            map.put("msg", "用户名密码错误");
//            map.put("msg", "用户名密码错误");
//        }
//
//    }

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
        UserDomain userInfo = userMapper.getUserByNameAndPassword(username,pwd);
        if (userInfo==null){
            map.put("msg", "用户名密码错误");
            map.put("msg", "用户名密码错误");
            return "login";
        }else{
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }
    }


    @RequestMapping("/user/logout")
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
