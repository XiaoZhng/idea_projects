package com.zledu.outputstream_;

import java.io.*;

/**
 * @author Alonso
 * 演示 ObjectOutputStream的使用，完成数据的序列化
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后，保存的文件格式，不是纯文本，而是按照它的格式来保存
        String FilePath = "e:\\date.dat";
        //创建 ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FilePath));

        //序列化数据到 e:\date.dat
        oos.writeInt(100);//int -> Integer(实现了Serializable)
        oos.writeBoolean(true);//boolean -> Boolean(实现了Serializable)
        oos.writeChar('a');//char -> Character(实现了Serializable)
        oos.writeDouble(10.0);//double -> Double(实现了Serializable)
        oos.writeUTF("中国");//String
        //保存一个Dog对象
        //因为Dog类没有实现Serializable接口，所以抛出 NotSerializableException
        oos.writeObject(new Dog("jack", 10, "aa", "bb"));

        //关闭流
        oos.close();

        System.out.println("数据保存完毕(序列化形式)");
    }
}

