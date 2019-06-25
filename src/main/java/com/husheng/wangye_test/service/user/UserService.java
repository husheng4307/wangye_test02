package com.husheng.wangye_test.service.user;

import com.husheng.wangye_test.model.UserDomain;
import org.apache.ibatis.annotations.Select;

public interface UserService {


    public UserDomain getUserById(Integer id);

    public UserDomain getUserByNameAndPassword(String username ,String password);
}
