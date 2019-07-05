package com.husheng.wangye_test.service.studentMath.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.husheng.wangye_test.dao.StudentMathDao;
import com.husheng.wangye_test.model.StudentMathDomain;
import com.husheng.wangye_test.service.studentMath.StudentMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMathServiceImpl implements StudentMathService {

    @Autowired
    StudentMathDao studentMathDao;


    @Override
    public PageInfo<StudentMathDomain> getStudentMathAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StudentMathDomain> studentinfo = studentMathDao.getStudentMathAll();
        PageInfo<StudentMathDomain> pageInfo = new PageInfo<>(studentinfo);
        return pageInfo;
    }

    @Override
    public StudentMathDomain getStudentMathById(Integer id) {
        return studentMathDao.getStudentMathById(id);
    }
}
