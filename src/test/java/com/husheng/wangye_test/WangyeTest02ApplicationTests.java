package com.husheng.wangye_test;

import com.husheng.wangye_test.utils.utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WangyeTest02ApplicationTests {

    @Test
    public void contextLoads() {

//        @Autowired
//        UserMapper userMapper;
        String s="admin11"+"sss";
        System.out.println(s);
        String pwd = utils.MD5encode(s);
        System.out.println(pwd);
    }

}
