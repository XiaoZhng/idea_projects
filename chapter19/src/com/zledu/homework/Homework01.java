package com.zledu.homework;

import java.io.*;

/**
 * @author Alonso
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {

        //判断e盘下是否有文件夹mytemp，没有就创建
        String directoryPath = "e:\\mytemp";
        File file = new File(directoryPath);
        //判断目录是否存在
        if (!(file.exists())){
            //不存在，则创建
            if (file.mkdir()){
                System.out.println(file + "创建成功");
            }else {
                System.out.println(file + "创建失败");
            }
        }else {
            System.out.println(file + " 已经存在，不能再重复创建了...");
            return;
        }

        //mytemp目录创建成功后，就创建文件hello.txt
        String filePath = "e:\\mytemp\\hello.txt";
        File file1 = new File(filePath);
        BufferedWriter bw = null;
        //判断文件是否存在
        if (!file1.exists()){
            //不存在，则创建
            bw = new BufferedWriter(new FileWriter(file1));
            //并在hello.txt中写入 hello,world
            bw.write("hello,world");
            System.out.println("写入内容成功...");
        }else {
            System.out.println(file1 + " 已经存在，不要再重复创建了...");
        }
        //关闭流
        bw.close();
    }
}
