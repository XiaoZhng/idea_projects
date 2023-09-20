package com.node;

import java.util.HashSet;
import java.util.Stack;

public class Node10 {
    /**
     * 移除链表元素
     *
     * 给你一个链表的头节点 head 和一个整数 val ，
     * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     */
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(1);
        set.add(3);
        System.out.println(set);
    }

//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null){
//            return null;
//        }
//        ListNode node = head;
//        //循环整个链表
//        while (node != null && node.next != null){
//            //如果 node.next.val 是要删除的，就断开链接，链接到 node.next.next链表上
//            if (node.next.val == val){
//                node.next = node.next.next;
//                //这个 continue很关键，防止出现多个目标时漏删的情况
//                //如果不写 continue，那么就无法判断（新链接上的这个节点） node.next.next这个节点
//                //而是从 node.next.next这个节点开始的 next节点，就忽略了 node.next.next这个节点
//                continue;
//            }
//            node = node.next;
//        }
//        //最后再处理头部节点
//        if (head.val == val){
//            head = head.next;
//        }
//        return head;
//    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        //把链表存入栈中
        while (head != null){
            //不等于删除的元素才能存入栈中
            if (head.val != val){
                stack.push(head);
            }
            head = head.next;
        }

        ListNode newNode = new ListNode();
        //将栈中的链表取出，这是反转后的链表
        while (!stack.isEmpty()){
            stack.peek().next = newNode;
            newNode = stack.pop();
        }
        return newNode;
    }
}
