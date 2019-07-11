package com.husheng.wangye_test.service.ShiroUser.impl;

import com.husheng.wangye_test.dao.ShiroUserDao;
import com.husheng.wangye_test.model.ShiroUserDomain;
import com.husheng.wangye_test.service.ShiroUser.ShiroUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroUserServiceImpl implements ShiroUserService {

    @Autowired
    private ShiroUserDao shiroUserDao;

    @Override
    public ShiroUserDomain findByName(String name) {
        return shiroUserDao.findByName(name);
    }

    @Override
    public ShiroUserDomain findById(Integer id) {
        return shiroUserDao.findById(id);
    }
}
