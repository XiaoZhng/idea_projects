package com.zledu.properties_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Alonso
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {

        //读取 mysql.properties 文件，并得到ip，user和pwd
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        //通过循环得到 mysql.properties中的信息
        String len = "";
        while ((len = br.readLine()) != null){
            String[] split = len.split("=");
            //如果我们要求指定的ip值
            //if ("ip".equals(split[0])) {
                System.out.println(split[0] + "的值为：" + split[1]);
            //}
        }
        //关闭流
        br.close();
    }
}
