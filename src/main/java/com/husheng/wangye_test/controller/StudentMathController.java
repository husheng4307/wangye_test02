package com.husheng.wangye_test.controller;


import com.github.pagehelper.PageInfo;
import com.husheng.wangye_test.model.StudentMathDomain;
import com.husheng.wangye_test.service.studentMath.StudentMathService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Api("Student类相关接口")
@Controller
public class StudentMathController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentMathController.class);

    @Autowired
    private StudentMathService studentMathService;


    @ApiOperation("按照id号查询")
    @GetMapping("/stu/{id}")
    public StudentMathDomain getStudentById(@PathVariable("id") Integer id){
        return studentMathService.getStudentMathById(id);
    }

    @ApiOperation("查询所有studentMath信息")
    @GetMapping("/studentInfo")
    public String list(HttpServletRequest request,
                       @ApiParam(name = "pageNum",value = "页数",required = false)
                       @RequestParam(name = "pageNum",required = false,defaultValue = "1")
                       int pageNum,
                       @ApiParam(name = "pageSize",value = "每页条数",required = false)
                       @RequestParam(name = "pageSize",required = false,defaultValue = "2")
                       int pageSize){

        PageInfo<StudentMathDomain> studentInfo = studentMathService.getStudentMathAll(pageNum,pageSize);
        System.out.println(studentInfo);
        request.setAttribute("student",studentInfo);
        return "studentInfo";
    }

}
