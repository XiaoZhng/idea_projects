package com.zledu.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author Alonso
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws Exception{
        String filePath = "e:\\ok.txt";
        //创建 bufferedWriter
        //说明：
        //1.new FileWriter(filePath, true) 表示以追加的方式写入
        //2.new FileWriter(filePath) 表示以覆盖的方式写入
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
        bufferedWriter.write("hello1, world");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("hello2, world");
        bufferedWriter.newLine();
        bufferedWriter.write("hello3, world");
        bufferedWriter.newLine();

        //关闭外层流即可，传入的fileWriter节点流，会在底层自动关闭
        bufferedWriter.close();
    }
}
