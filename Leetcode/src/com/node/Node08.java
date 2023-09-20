package com.node;

import java.util.HashSet;

public class Node08 {
    /**
     * 相交链表
     *
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
     * 如果两个链表不存在相交节点，返回 null 。
     */

    /**
     * 1.使用集合
     * 2.比较长度
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1.使用集合
//        if (headA == null || headB == null){
//            return null;
//        }
//        HashSet<ListNode> set = new HashSet<>();
//        //把链表A放入集合
//        while (headA != null){
//            set.add(headA);
//            headA = headA.next;
//        }
//        //然后用链表B比较集合中的值，如果有相等的，就是相交点
//        while (headB != null){
//            if (set.contains(headB)){
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;

        //2.比较长度
        int lenA = length(headA);
        int lenB = length(headB);

        //两个链表长度不相等的情况下，让长的链表先走，直到长度相等，再一起走
        while (lenA != lenB){
            if (lenA > lenB){
                //向后走，并且长度减1
                headA = headA.next;
                lenA--;
            }else {
                //向后走，并且长度减1
                headB = headB.next;
                lenB--;
            }
        }

        //长度相等，两个一起走，并判断值相等就是交点
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public int length(ListNode node){
        int i = 0;
        while (node != null){
            node = node.next;
            i++;
        }
        return i;
    }
}
