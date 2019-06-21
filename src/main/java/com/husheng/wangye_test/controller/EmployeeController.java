package com.husheng.wangye_test.controller;

import com.husheng.wangye_test.dao.DepartmentDao;
import com.husheng.wangye_test.dao.EmployeeDao;
import com.husheng.wangye_test.entities.Department;
import com.husheng.wangye_test.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;


    //查询所有员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {

        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        //themeleaf默认拼串
        return "emp/list";
    }


    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }


    @PostMapping("/emp")
    public String addEmp(Employee employee) {

        System.out.println("保存的信息" + employee);
        employeeDao.save(employee);
        //redirect:重定向到一个地址
        //forward：转发到一个地址
        return "redirect:/emps";

    }


    @GetMapping("/emp/{id}")
    public String roEditPage(@PathVariable("id") Integer id, Model model) {

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        return "emp/add";
    }


    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {

        employeeDao.save(employee);
        return "redirect:/emps";
    }


    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);

        return "redirect:/emps";
    }

}
