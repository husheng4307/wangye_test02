package com.husheng.wangye_test.service.ShiroUser;

import com.husheng.wangye_test.model.ShiroUserDomain;

public interface ShiroUserService {

    ShiroUserDomain findByName(String name);
    ShiroUserDomain findById(Integer id);

}
