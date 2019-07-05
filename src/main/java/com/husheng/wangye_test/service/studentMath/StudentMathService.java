package com.husheng.wangye_test.service.studentMath;

import com.github.pagehelper.PageInfo;
import com.husheng.wangye_test.model.StudentMathDomain;

import java.util.List;

public interface StudentMathService {

    PageInfo<StudentMathDomain> getStudentMathAll(int pageNum, int pageSize);

    StudentMathDomain getStudentMathById(Integer id);
}
