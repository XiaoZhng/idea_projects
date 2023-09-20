package com.zledu.homework;

import java.util.ArrayList;

public class Homework01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(new New("新冠确诊病例超千万，数百万印度教徒赴恒河“圣浴”引民众担忧"));
        list.add(new New("男子突然想起两个月前钓的鱼还在网兜里，捞起一看放生"));
        //倒序遍历
        int size = list.size();
        for (int i = size - 1; i >= 0; i--){
            //System.out.println(list.get(i));
            //向下转型成 New，接收get()，使用proc  essHead()
            New head = (New)list.get(i);
            System.out.println(processHead(head.getHead()));

        }

    }
    //新闻标题超过15个字就用 "..."代替，创建个方法实现
    public static String processHead(String head){

        if (head == null){
            return "";
        }

        //如果长度 > 15，就用substring()截取 + "..."，否则返回原来的head
        if (head.length() > 15){
           return head.substring(0, 15) + "...";//substring() 截取
        }else {
            return head;
        }
    }

}

class New{
    private String head;//标题
    private String body;//内容

    public New(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "head= " + head ;
    }
}