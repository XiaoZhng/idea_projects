package com.node;

import java.util.Stack;

public class Node05 {
    /**
     * 回文链表
     *
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     */

    /**
     * 1.把回文链表存入栈中再取出来，顺序和没存入的一样
     * 2.不是回文：123456   654321    是回文：12321  12321
     * 3.取出来的新链表和旧链表一一比较，相等就是 true，否则 false
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        ListNode oldNode = head;
        //反转链表
        ListNode newNode = reverseList(head);
        //让就链表和新链表比较
        //循环两个链表，判断每个节点是不是相等
        while (oldNode != null && newNode != null){
            //不相等，返回 false
            if (oldNode.val != newNode.val){
                return false;
            }
            //如果相等，就往下继续比较
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return true;
    }

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

    public boolean isPalindromes(ListNode head) {
        if (head == null){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        //存入栈中
        while (node != null){
            stack.push(node.val);
            node = node.next;
        }

        //栈为空，返回 false
        if (stack.isEmpty()){
            return false;
        }

        //从栈中取出，和原链表比较
        while (head != null){
            //如果取出的val不等于 原链表的val，返回false
            if (head.val != stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
