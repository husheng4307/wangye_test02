package com.husheng.wangye_test.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControll {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
