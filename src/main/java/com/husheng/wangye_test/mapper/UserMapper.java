package com.husheng.wangye_test.mapper;


import com.husheng.wangye_test.model.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    public UserDomain getUserById(Integer id);

    @Select("select * from user where username=#{username} and password=#{password}")
    public UserDomain getUserByNameAndPassword(String username ,String password);
}
