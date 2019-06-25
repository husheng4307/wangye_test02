package com.husheng.wangye_test.dao;

import com.husheng.wangye_test.model.StudentMathDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMathDao {

    @Select("select * from StudentMat")
    public List<StudentMathDomain> getStudentMathAll();

    @Select("select * from StudentMat where id =#{id}")
    public StudentMathDomain getStudentMathById(Integer id);
}
