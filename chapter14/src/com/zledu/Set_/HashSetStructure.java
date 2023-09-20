package com.zledu.Set_;

public class HashSetStructure {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //模拟一个HashSet的底层(HashMap 的底层结构)

        //1. 创建一个数组，数组的类型是 Node[]
        //2. Node[] 也可以称为 表(table)
        Node[] table = new Node[16];
        System.out.println(table);
        //3. 创建结点
        Node john = new Node("john", null);
        table[2] = john;
        Node jack = new Node("jack", null);
        john.next = jack;//将jack结点，挂载到john后面
        Node rose = new Node("Rose", null);
        jack.next = rose;//将rose结点，挂载到jack后面
        Node lucy = new Node("lucy", null);
        table[3] = lucy;//吧lucy放在table表索引为3的位置
        System.out.println(table);
    }
}
class Node{ //结点，存储数据，可以指向下一个结点，从而形成链表
    Object item;//存放数据
    Node next;//指向下一个结点

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}