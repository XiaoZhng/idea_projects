package com.zledu.mhl.service;

import com.zledu.mhl.dao.EmployeeDAO;
import com.zledu.mhl.domain.Employee;

/**
 * @author Alonso
 * 业务层
 */
public class EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //验证empId 和 pwd
    //验证成功返回 Employee对象，否则null
    public Employee getEmployee(String loginId, String pwd){
        Employee employee =
                employeeDAO.QuerySingle("select * from login where loginId = ? and pwd = MD5(?)", Employee.class, loginId, pwd);
        return employee;
    }
}
