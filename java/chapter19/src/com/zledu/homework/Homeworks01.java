package com.zledu.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Alonso
 */
public class Homeworks01 {
    public static void main(String[] args) throws IOException {
        //判断e盘下是否有文件夹tests，没有就创建
        String directoryPath = "e:\\tests";
        File file = new File(directoryPath);
        //目录不存在，则创建
        if (!file.exists()){
            if (file.mkdir()){
                System.out.println(file + " 创建成功");
            }else{
                System.out.println(file + " 创建失败");
            }
        }
        //tests目录创建成功后，就创建文件hello.txt
        String filePath = directoryPath + "\\hello.txt";
        File file1 = new File(filePath);
        if (!file1.exists()){
            if (file1.createNewFile()){
                //hello.txt 写入 hello,world
                BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
                bw.write("hello,world");
                //关闭流
                bw.close();
            }else {
                System.out.println(file1 + " 创建失败");
            }
        }else {
            System.out.println(file1 + " 已经存在，不能重复创建");
        }
    }
}
