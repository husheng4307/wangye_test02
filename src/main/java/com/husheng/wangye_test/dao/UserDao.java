package com.husheng.wangye_test.dao;


import com.husheng.wangye_test.model.UserDomain;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where id=#{id}")
    public UserDomain getUserById(Integer id);

    @Select("select * from user where username=#{username} and password=#{password}")
    public UserDomain getUserByNameAndPassword(String username ,String password);

    @Insert("insert into user(username,password) values (#{username},#{password})")
    public void setUserByNameAndPassword(String username, String password);
}
