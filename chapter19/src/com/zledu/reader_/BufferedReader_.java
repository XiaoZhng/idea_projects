package com.zledu.reader_;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Alonso
 * 演示 bufferedReader 使用
 */
public class BufferedReader_ {
    public static void main(String[] args) throws Exception{
        String readPath = "e:\\story.java";
        //创建 bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(readPath));
        String line;//按行执行，效率高
        //说明：
        //1.bufferedReader.readLine() 是按行读取文件
        //2.当返回Null时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        //关闭流，这里注意，只需要关闭 bufferedReader，因为底层会自动去关闭 节点流
        /*
            阅读源码
            public void close() throws IOException {
                synchronized (lock) {
                    if (in == null)
                        return;
                    try {
                        in.close();//in 就是我们传入的 new FileReader(readPath),关闭
                    } finally {
                        in = null;
                        cb = null;
                    }
                }
            }
         */
        bufferedReader.close();
    }
}
