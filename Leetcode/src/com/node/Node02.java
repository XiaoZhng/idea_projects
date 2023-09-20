package com.node;

import static jdk.nashorn.internal.objects.ArrayBufferView.length;

public class Node02 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */

    /**
     * 1.先计算 Node的长度
     * 2.如果 length - n 等于0，表示删除的是头节点，就返回 head.next
     * 3.用获取到的 length 通过 for循环获取到删除节点的前一个节点
     * 4.让前一个节点指向被删除节点的下一个节点
     */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = head;
            // -n 可以得到正向删除的节点数
            int length = length(pre) - n;
            //链表长度也是从0开始计算
            //如果length等于0，表示删除的是头节点，就返回head.next
            if (length == 0){
                return head.next;
            }
            //获取到删除节点的前一个节点
            //length是当前要删除的节点，前一个节点就是 length -1
            for (int i = 0; i < length - 1; i++) {
                pre = pre.next;
            }
            //让前一个节点指向被删除节点的下一个节点
            pre.next = pre.next.next;
            return head;
        }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
