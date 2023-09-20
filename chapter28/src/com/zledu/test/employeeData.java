package com.zledu.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alonso
 */
public class employeeData {

    public static List<employee> getEmployee(){

        List<employee> employees = new ArrayList<>();
        employees.add(new employee(1001, "jack", 21, 6000));
        employees.add(new employee(1002, "tom", 12, 7000));
        employees.add(new employee(1003, "jams", 22, 8000));
        employees.add(new employee(1004, "lucy", 23, 9000));
        employees.add(new employee(1005, "king", 11, 7500));
        employees.add(new employee(1006, "sam", 25, 6000));

        return employees;
    }

}
