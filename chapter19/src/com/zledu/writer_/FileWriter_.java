package com.zledu.writer_;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Alonso
 */
class FileWrite{
    public static void main(String[] args) {
        String filePath = "e:\\note.txt";
        FileWriter fileWriter = null;
        //定义字符数组
        char[] chars = {'a', 'b', 'c'};
        try {
            fileWriter = new FileWriter(filePath);
//            1. write(int)：写入单个字符
            fileWriter.write('A');
//            2. write(char[])：写入指定数组
            fileWriter.write(chars);
//            3. write(char[], off, len)：写入指定数组的指定部分
            fileWriter.write(chars, 0, 2);
//            4. write(String)：写入整个字符串
            fileWriter.write("你好，深圳");
//            5. write(String, off, len)：写入字符串的指定部分
            fileWriter.write("北京上海", 0, 2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //对应FileWriter，一定要关闭流，或者flush才能真正的把数据写入到文件
            try {
                fileWriter.close();
                //fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序结束...");
        /*
            close()源码：
            private void writeBytes() throws IOException {
                this.bb.flip();
                int var1 = this.bb.limit();
                int var2 = this.bb.position();

                assert var2 <= var1;

                int var3 = var2 <= var1 ? var1 - var2 : 0;
                if (var3 > 0) {
                    if (this.ch != null) {
                        assert this.ch.write(this.bb) == var3 : var3;
                    } else {
                        this.out.write(this.bb.array(), this.bb.arrayOffset() + var2, var3);
                    }
                }

                this.bb.clear();
            }

            flush()源码：底层也是调用 writeBytes()
         */
    }
}
