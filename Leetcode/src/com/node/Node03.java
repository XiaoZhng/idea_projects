package com.node;


import java.util.Stack;

public class Node03 {
    /**
     * 反转链表
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */

    /**
     * 1.栈是先进后出的，所以可以实现反转
     * 2.把链表的 val 存入栈中 stack.push()
     * 3.判断如果栈为 null（stack.isEmpty()），就返回 null
     * 4.把栈取出来的数放入新链表
     * 5.取完后，就把尾节点设置为 null
     * 6.返回新链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        //创建一个存放链表的栈
        Stack<ListNode> stack = new Stack<>();
        //先把链表的节点放入栈中
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        //判断栈是否为null
        if (stack.isEmpty()){
            return null;
        }
        //把栈取出来的数放入链表中，组成新链表
        //先从栈中取出头节点放入 node中（5）
        ListNode newNode = stack.pop();
        //指向当前节点
        ListNode node = newNode;
        //栈不为空时就继续循环，逐个取出节点
        while (!stack.isEmpty()){
            //放入临时链表
            ListNode temp = stack.pop();
            //把取出的节点，连在新节点后面（5——>4）
            node.next = temp;
            //再把位置往后移
            node = node.next;
        }
        //取完后，就把尾节点设置为 null
        node.next = null;
        //返回新链表
        return newNode;
    }

//    public static ListNode reverseList1(ListNode head) {
//        Stack<ListNode> stack = new Stack<>();
//        while (head != null){
//            stack.push(head);
//            head = head.next;
//        }
//
//        if (stack.isEmpty()){
//            return null;
//        }
//
//        //从栈中取出一个节点作为头节点
//        ListNode node = stack.pop();
//        ListNode newNode = node;
//
//        //从栈中取 node
//        while (!stack.isEmpty()){
//            ListNode temp = stack.pop();
//            newNode.next = temp;
//            newNode = newNode.next;
//        }
//
//        //最后一个节点指向 null
//        newNode.next = null;
//        return node;
//    }

}
