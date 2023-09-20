package com.node;

public class NodeTest {
    public static void main(String[] args) {
        //链表 2 ——> 4 ——> 6
        ListNode n = new ListNode(2);
        //前一个节点指向后一个结点
        n.next = new ListNode(4);
        //前一个节点指向后一个结点
        n.next.next = new ListNode(6);
        System.out.print("链表n1= ");
        showNode(n);

        //size
        System.out.println();
        System.out.println("链表长度= " + size(n));

        //search
        System.out.println("查询链表val为6的结果= " + search(n, 6));
    }

    /**
     * 长度
     * @param head 链表
     * @return 返回链表长度
     */
    public static int size(ListNode head){
        //如果链表为 null，返回0
        if (head == null){
            return 0;
        }
        //不为 null，从 1 开始计算
        return count(head, 1);
    }

    public static int count(ListNode head, int n){
        //如果下一个为 null，返回当前位置所在的长度
        if (head.next == null){
            return n;
        }
        //继续计算，递归执行，直到 next 为 null
        return count(head.next, n + 1);
    }

    /**
     * 查找
     * @param head 单链表
     * @param n 查找的数
     * @return 返回查询结果，true or false
     */
    public static boolean search(ListNode head, int n){
        //如果链表为 null，返回 false
        if (head == null){
            return false;
        }
        //不为 null，往下继续查询
        return searchNode(head, n);
    }

    public static boolean searchNode(ListNode head, int n){
        //如果当前节点的 val 等于 n，返回 true
        //这个判断必须要写在判断下一个节点为 null前，因为这样才能查询尾节点的 val
        if (head.val == n){
            return true;
        }
        //如果下一个节点为 null，返回 false
        if (head.next == null){
            return false;
        }
        //不等于且下一个节点不为 null，则继续向下查询
        return searchNode(head.next, n);
    }

    /**
     * 遍历输出整个链表
     * @param node 链表
     */
    public static void showNode(ListNode node){
        while (node != null){
            System.out.print(node.val + "  ");
            node = node.next;
        }
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}