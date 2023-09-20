package com.zledu.writer_;

import java.io.*;

/**
 * @author Alonso
 * 演示 Buffered 拷贝
 */
public class BufferedCopy_ {
    public static void main(String[] args) {

        /**
         * 强调说明：
         * 1.BufferedReader 和 BufferedWriter 是安装字符操作
         * 2.不要去操作二进制文件【声音、视频、doc、pdf...】，可能造成文件损坏
         */

//        BufferedInputStream
//        BufferedOutputStream
        //拷贝文件
        String srcFilePath = "e:\\story.java";
        String destFilePath = "e:\\a.java";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));
            //readLine 读取一行内容，但是没有换行
            while ((line = br.readLine()) != null){
                //读取一行，就加入一行
                bw.write(line);
                //换行
                bw.newLine();
            }
            System.out.println("拷贝成功...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (br != null){
                    br.close();
                }
                if (bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
