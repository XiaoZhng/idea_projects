package com.node;

public class Node09 {
    /**
     * 删除链表的倒数第N个节点
     *
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */

    /**
     * 1.删除倒数第N个节点，就是正数第 （总长度-N的节点）
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {//5  2
        ListNode node = head;
        int length = length(head) - n;//3
        //n < 0 或者 长度 - n 的值也小于 0，直接返回原链表
        if (length < 0){
            return head;
        }
        //等于0，要删除的是头节点
        if (length == 0){
            return head.next;
        }

        //拿到要删除节点的前一个节点 (i < length 是获取要删除的节点，前一个节点就是 -1)
        for (int i = 0; i < length - 1; i++) {
            node = node.next;
        }

        node.next = node.next.next;
        return head;
    }

    //计算 ListNode长度
    public static int length(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}
