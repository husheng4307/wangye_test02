package com.husheng.wangye_test.dao;


import com.husheng.wangye_test.model.ShiroUserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ShiroUserDao {

    @Select("select * from shiro_user where name = #{name}")
    public ShiroUserDomain findByName(String name);

    @Select("select * from shiro_user where id = #{id}")
    public ShiroUserDomain findById(Integer id);
}
