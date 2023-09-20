package com.node;

import java.util.List;

public class Node11 {
    /**
     * 奇偶链表
     *
     * 给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     *
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
     *
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     */

    /**
     * 拉链解法
     * 1.定义两个指针，一个指向 head，一个指向 head.next
     * 2.循环链表的条件是 指针的指向 != null && 指针的next指向 != null && 指针的next的next指向 != null
     * 3.让 one.next = one.next.next，two.next = two.next.next
     *  然后继续往后走 one = one.next，two = two.next
     * 4.其实 one = one.next 这里的 one.next是指向 one.next.next，不是指向 后面 two指针的位置
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        //如果满足这三个条件，说明链表的长度小于3，不能进行奇偶链表
        if (head == null || head.next == null || head.next.next == null){
            return head;
        }
        //定义两个指针
        ListNode ouHead = head;
        ListNode jiHead = head.next;
        //定义指针的位置
        ListNode one = ouHead;
        ListNode two = jiHead;
        while (ouHead != null && ouHead.next != null && ouHead.next.next != null){
            ouHead.next = ouHead.next.next;
            jiHead.next = jiHead.next.next;
            //指针向后移动
            //这里向后移动并不是指向后面指针的位置，因为 ouHead.next = ouHead.next.next
            //所以 ouHead.next = ouHead.next.next，jiHead指针也一样
            ouHead = ouHead.next;
            jiHead = jiHead.next;
        }
        //最后 奇数的指针指向偶数指针的位置
        ouHead.next = two;
        //返回 奇数指针的位置
        return one;
    }
}
