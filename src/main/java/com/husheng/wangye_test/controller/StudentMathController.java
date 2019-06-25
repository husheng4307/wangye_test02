package com.husheng.wangye_test.controller;


import com.github.pagehelper.PageInfo;
import com.husheng.wangye_test.model.StudentMathDomain;
import com.husheng.wangye_test.service.studentMath.StudentMathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;


@Controller
public class StudentMathController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentMathController.class);

    @Autowired
    private StudentMathService studentMathService;


    @GetMapping("/stu/{id}")
    public StudentMathDomain getStudentById(@PathVariable("id") Integer id){
        return studentMathService.getStudentMathById(id);
    }

    @GetMapping("/studentInfo")
    public String list(HttpServletRequest request,
                       @RequestParam(name = "pageNum",required = false,defaultValue = "1")
                       int pageNum,
                       @RequestParam(name = "pageSize",required = false,defaultValue = "2")
                       int pageSize){

        PageInfo<StudentMathDomain> studentInfo = studentMathService.getStudentMathAll(pageNum,pageSize);
        System.out.println(studentInfo);
        request.setAttribute("student",studentInfo);
        return "studentInfo";
    }

}
