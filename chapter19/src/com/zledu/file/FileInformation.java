package com.zledu.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author Alonso
 */
public class FileInformation {
    public static void main(String[] args) {

    }

    //获取文件的信息
    @Test
    public void info(){
        //先创建文件对象
        File file = new File("e:\\news1.txt");
        //调用相应的方法，得到对应的信息
        System.out.println("文件名：" + file.getName());

        System.out.println("文件的绝对路径：" + file.getAbsolutePath());
        System.out.println("文件父级目录：" + file.getParent());
        System.out.println("文件大小(字节)：" + file.length());
        System.out.println("文件是否存在：" + file.exists());//true
        System.out.println("是不是一个文件：" + file.isFile());//true
        System.out.println("是不是一个目录：" + file.isDirectory());//False


    }
}
