package com.zledu.file;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Alonso
 */
public class Directory_ {
    public static void main(String[] args) {

    }
    //判断 e:\\news1.txt 是否存在，如果存在就删除
    @Test
    public void m1(){
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete()){
                System.out.println(filePath + "删除成功");
            }else{
                System.out.println(filePath + "删除失败");
            }
        }else {
            System.out.println("文件不存在");
        }
    }

    //判断D:\\demo02 是否存在，存在就删除，否则提示不存在
    @Test
    public void m2(){
        String filePath = "D:\\demo02";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete()){
                System.out.println(filePath + "删除成功");
            }else{
                System.out.println(filePath + "删除失败");
            }
        }else {
            System.out.println("目录不存在");
        }
    }

    //判断D:\\demo\\a\\b\\c 目录是否存在，如果存在就提示已存在，否则就创建
    @Test
    public void m3(){
        String dirPath = "D:\\demo\\a\\b\\c";
        File file = new File(dirPath);
        if (file.exists()){
            System.out.println(dirPath + "已存在");
        }else {
            //创建一级目录使用mkdir()，创建多级目录使用mkdirs()
            if(file.mkdirs()){
                System.out.println(dirPath + "创建成功");
            }else {
                System.out.println(dirPath + "创建失败");
            }
        }
    }

    //下面四个都是抽象类
    //使用的时候要创建实现子类才行
    //InputStream
    //OutputStream
    //Reader //字符输入流
    //Writer //字符输出流
}
