package com.husheng.wangye_test.service.user.impl;

import com.husheng.wangye_test.dao.UserDao;
import com.husheng.wangye_test.model.UserDomain;
import com.husheng.wangye_test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDomain getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public UserDomain getUserByNameAndPassword(String username, String password) {
        return userDao.getUserByNameAndPassword(username, password);
    }

    @Override
    public boolean setUserByNameAndPassword(String username, String password) {
        userDao.setUserByNameAndPassword(username, password);
        return true;
    }
}
