package com.spring.stu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Alonso
 */
public class stu {
    //数组类型属性
    private String[] array;
    //List类型属性
    private List<String> list;
    private List<course> courseList;
    //Map类型属性
    private Map<String, String> map;
    //Set类型属性
    private Set<String> set;
    public void setCourseList(List<course> courseList) {
        this.courseList = courseList;
    }
    public void setArray(String[] array) {
        this.array = array;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
    public void setSet(Set<String> set) {
        this.set = set;
    }
    public void add(){
        System.out.println(Arrays.toString(array));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(courseList);
    }
}
