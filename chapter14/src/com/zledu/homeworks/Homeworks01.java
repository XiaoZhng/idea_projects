package com.zledu.homeworks;

import java.util.ArrayList;

public class Homeworks01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        //将新闻对象添加到ArrayList集合中
        list.add(new news("新冠确诊病例超千万，数百万印度教徒赴恒河“圣浴”引民众担忧"));
        list.add(new news("男子突然想起两个月前钓的鱼还在网兜里，捞起一看放生"));
        //进行倒序遍历 (反过来遍历)
        for (int i = list.size() - 1; i >= 0; i--){ //从集合最后一个数开始遍历，当i遍历到0时结束遍历
            //System.out.println(list.get(i));
            //因为 xiu()传入的是 String类型对象，所以要向下转型
            news news = (news)list.get(i);
            System.out.println(xiu(news.getHead()));
        }

    }
    public static String xiu(String news){

        //先判断传入的 news是否为Null
        if (news == null){
            return "";
        }

        //新闻标题长度 > 15，保留前15个字，后面加 "..."
        if (news.length() > 15){
            return news.substring(0, 15) + "..."; //substring()截取
        }else{ //不超过15的情况，返回未被修改的 news
            return news;
        }
    }
}

class news{
    private String head;
    private String body;

    public news(String head) {
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
        return "head = " + head;
    }
}