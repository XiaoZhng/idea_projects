package com.zledu.properties_;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Alonso
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        //创建
        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "汤姆");//注意保存时，是中文的 unicode码值
        properties.setProperty("pwd", "123456");
        //如果该文件没有key，则创建
        //如果有，则修改
        /*
        Properties 父类是 hashtable，底层就是hashtable 核心方法
        public synchronized V put(K key, V value) {
            // Make sure the value is not null
            if (value == null) {
                throw new NullPointerException();
            }

            // Makes sure the key is not already in the hashtable.
            Entry<?,?> tab[] = table;
            int hash = key.hashCode();
            int index = (hash & 0x7FFFFFFF) % tab.length;
            @SuppressWarnings("unchecked")
            Entry<K,V> entry = (Entry<K,V>)tab[index];
            for(; entry != null ; entry = entry.next) {
                if ((entry.hash == hash) && entry.key.equals(key)) {
                    V old = entry.value;
                    entry.value = value;//如果key 存在，就替换
                    return old;
                }
            }

            addEntry(hash, key, value, index);//如果是新的key，就addEntry
            return null;
        }
         */
        properties.setProperty("pwd", "root");
        //把创建信息存入指定文件中
        //字节流会把中文转换成 Unicode码，字符流会显示中文
        //store构造器中的 comments是注释
//        properties.store(new FileWriter("src\\mysql2.properties"), null);
        properties.store(new FileOutputStream("src\\mysql2.properties"), null);
        //关闭流
//        properties.clone();
    }
}
