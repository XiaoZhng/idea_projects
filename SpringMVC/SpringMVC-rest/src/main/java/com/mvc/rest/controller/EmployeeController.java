package com.mvc.rest.controller;

import com.mvc.rest.bean.Employee;
import com.mvc.rest.dao.EmployeeDAO;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Alonso
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    //查看所有员工信息
    @GetMapping(value = "/employee")
    public String getAll(Model model){
        Collection<Employee> employeeList = employeeDAO.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_info";
    }

    //删除员工信息
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDAO.delete(id);
        return "redirect:/employee";
    }

    //添加员工信息
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String AddEmp(Employee employee){
        employeeDAO.save(employee);
        return "redirect:/employee";
    }

    //回显员工信息
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDAO.get(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    //修改员工信息
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public String update(Employee employee){
        employeeDAO.save(employee);
        return "redirect:/employee";
    }
}
