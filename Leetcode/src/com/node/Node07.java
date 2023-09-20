package com.node;

public class Node07 {
    /**
     * 环形链表 II
     *
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     */

    /**
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode n = head;
        ListNode j = head;
        boolean temp = false;
        while (j.next != null && j.next.next != null){
            n = n.next;
            j = j.next.next;
            if (n == j){
                temp = true;
                break;
            }
        }

        //如果有环
        if (temp){
            ListNode m = head;
            while (n != m){
                n = n.next;
                m = m.next;
            }
            return m;
        }else {
            return null;
        }
    }
}
