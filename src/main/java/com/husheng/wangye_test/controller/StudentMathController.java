package com.husheng.wangye_test.controller;


import com.husheng.wangye_test.mapper.StudentMathMapper;
import com.husheng.wangye_test.model.StudentMathDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class StudentMathController {

    @Autowired
    StudentMathMapper studentMathMapper;

    @GetMapping("/stu/{id}")
    public StudentMathDomain getStudentById(@PathVariable("id") Integer id){
        return studentMathMapper.getStudentMathById(id);
    }

    @GetMapping("/studentInfo")
    public String list(Model model){
        List<StudentMathDomain> studentMathAll = studentMathMapper.getStudentMathAll();
        model.addAttribute("student",studentMathAll);
        return "/studentInfo";
    }

    @GetMapping("sss")
    public String sss(){
        return "/sss";
    }
}
