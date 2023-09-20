package com.zledu.outputstream_;

import java.io.*;

/**
 * @author Alonso
 * 使用 BufferedInputStream 和 BufferedOutputStream 对图片进行拷贝
 * 使用他们，可以完成二进制文件拷贝
 * 字节流可以操作二进制文件，也可以操作文本文件
 */
public class BufferedCopy02 {
    public static void main(String[] args) {
        String srcFilePath = "e:\\img1.png";
        String destFilePath = "e:\\img3.png";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        int date = 0;
        //提升读取效率，创建一个缓冲
        byte[] buf = new byte[1024];

        try {
            //创建 BufferedInputStream
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            //创建 BufferedOutputStream
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

            while ((date = bis.read(buf)) != -1){
                //一边读，一边写入
//                bos.write(date);
                bos.write(buf, 0, date);
            }
            System.out.println("拷贝成功...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (bis != null){
                    bis.close();
                }
                if (bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//    ObjectInputStream
//    ObjectOutputStream
}
