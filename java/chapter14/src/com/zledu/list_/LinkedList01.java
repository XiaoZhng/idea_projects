package com.zledu.list_;

public class LinkedList01 {
    public static void main(String[] args) {

        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node Jams = new Node("Jams");

        //连接三个结点，形成双向链表
        //jack -> tom -> Jams
        jack.next = tom;
        tom.next = Jams;
        //Jams -> tom -> jack
        Jams.pre = tom;
        tom.pre = jack;

        Node first = jack;//让first引用指向jack，就是双向链表的头节点
        Node last = Jams;//让last引用指向Jams，就是双向链表的尾节点

        System.out.println("===从头到尾进行遍历");
        //演示，从头到尾进行遍历
        while (true){
            if (first == null){
                break;
            }
            //输出first信息
            System.out.println(first);
            first = first.next;
        }

        System.out.println("===从尾到头进行遍历");
        //演示，从尾到头进行遍历
        while (true){
            if (last == null){
                break;
            }
            //输出first信息
            System.out.println(last);
            last = last.pre;
        }

        //演示链表的添加对象/数据
        //要求 在 tom --- Jams之间，插入一个对象 king

        //先创建一个 Node结 点，name 就是 king
        Node king = new Node("king");
        //下面就把king加入到双向链表了
        tom.next = king;
        king.next = Jams;
        Jams.pre = king;
        king.pre = tom;

        System.out.println("===从头到尾进行遍历");
        first = jack;//重置，让first再次指向jack
        //演示，从头到尾进行遍历
        while (true){
            if (first == null){
                break;
            }
            //输出first信息
            System.out.println(first);
            first = first.next;
        }

        last = Jams;//重置，让last再次指向Jams
        System.out.println("===从尾到头进行遍历");
        //演示，从尾到头进行遍历
        while (true){
            if (last == null){
                break;
            }
            //输出first信息
            System.out.println(last);
            last = last.pre;
        }

    }
}

//定义一个Node类，Node对象 表示双向链接的一个结点
class Node{
    public Object item; //真正存放数据
    public Node next; //指向后一个结点
    public Node pre; //指向前一个结点

    public Node(Object name) {
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node name=" + item;
    }
}