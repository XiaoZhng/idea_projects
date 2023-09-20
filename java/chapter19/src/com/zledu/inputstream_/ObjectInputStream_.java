package com.zledu.inputstream_;

import com.zledu.outputstream_.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @author Alonso
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //指定反序列化的文件
        String FilePath = "e:\\date.dat";
        //创建 ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FilePath));

        //读取
        //1.读取(反序列化)的顺序需要和保存数据(序列化)的顺序一致
        //2.否则会出现异常
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());

        //dog 的编译类型是 Object，dog 的运行类型是 Dog
        Object dog = ois.readObject(); //底层 Object -> Dog
        System.out.println("运行类型=" + dog.getClass());
        System.out.println("dog的信息=" + dog);

        //这里是特别重要的细节：
        //1.如果我们希望调用Dog的方法，需要向下转型
        //2.需要我们将Dog类的定义，放在可以引用的位置
        Dog dog2 = (Dog)dog;
        System.out.println(dog2.getName());

        //关闭流
        ois.close();
    }
}

