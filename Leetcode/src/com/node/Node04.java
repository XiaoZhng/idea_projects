package com.node;

public class Node04 {
    /**
     * 合并两个有序链表
     *
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */

    /**
     * 1.因为两张链表是升序的，所以就从头遍历链表
     * 2.遍历两张链表时判断哪个数小就存入新链表中，直到有一个链表为 null
     * 3.就把不为 null的链表，直接存入新链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //如果有一个链表为 null，就返回另一个链表
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode newNode = new ListNode(0);
        ListNode node = newNode;
        //循环两张链表（都不等于 null的情况，如果有张表等于 null，退出循环
        // ，直接把不为 null的链表，拼接到新链表后）
        while (list1 != null && list2 != null){
            //两张链表作比较
            if (list1.val <= list2.val){
                //小的放入新链表
                node.next = list1;
                //然后往后一步，继续比较
                list1 = list1.next;
            }else {
                //小的放入新链表
                node.next = list2;
                //然后往后一步，继续比较
                list2 = list2.next;
            }
            //记住写循环条件
            node = node.next;
        }
        //当一张表为 null时，停止循环，直接把不为 null的链表拼接到新链表后
        //三目运算符：如果 list1==null，则拼接 list2，否则拼接 list1
        node.next = list1 == null ? list2 : list1;
        //因为 newNode的头节点是0，他的 newNode.next才是合并后的链表，所以返回  newNode.next
        return newNode.next;
    }

}
