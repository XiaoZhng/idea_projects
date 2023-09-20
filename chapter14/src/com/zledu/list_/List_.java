package com.zledu.list_;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        List list = new ArrayList();
        //1.List集合类中元素有序(即添加顺序和去除顺序一致)，且可重复
        list.add("jack");
        list.add("tom");
        list.add("marry");
        list.add("tom");
        System.out.println(list);
        //2.List集合中的每个元素都有其对应的顺序索引，即支持索引
        //  索引是从0开始的
        System.out.println(list.get(2));//marry

    }
}
