package com.node;

public class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    int size;
    Node head;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    /**
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size || head == null) {
            return -1;
        }
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    /**
     * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
     *
     * @param val
     */
    public void addAtHead(int val) {
        //把新的 val 存入 Node中
        Node node = new Node(val);
        //新的 node 指向原来的头节点
        node.next = this.head;
        //头节点变为 node
        this.head = node;
        //链表长度+1
        size++;
    }

    /**
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     *
     * @param val
     */
    public void addAtTail(int val) {
        //如果链表长度等于 0，就把 head指向新的node
        if (size == 0) {
            this.head = new Node(val);
            head.next = null;
            size++;
        }
        //把新的 val 存入 Node中
        Node node = new Node(val);
        Node temp = this.head;
        //找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }
        //把新节点的下一个节点指向 null
        node.next = null;
        //temp就是尾节点，新节点就成为了尾节点
        temp.next = node;
        //链表长度+1
        size++;
    }

    /**
     * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        //index 大于链表长度，不插入节点
        if (index > this.size) {
            return;
        }
        //index小于等于0，添加头节点
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        //index等于链表的长度，添加尾节点
        if (index == this.size) {
            addAtTail(val);
            return;
        }
        Node node = this.head;
        Node newNode = new Node(val);
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        //此时 node就是当前要插入的节点的前一个节点（for循环中的index是按下标计算的，所以要 -1）
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    /**
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     * @param index
     */
    public void deleteAtIndex(int index) {
        //index 大于等于链表长度，和小于 0 代表无效
        if (index < 0 || index >= this.size) {
            return;
        }
        if (index == 0) {
            if (size != 1) {
                //要删除头节点，直接把头节点的下一个节点设为头节点即可
                Node temp = this.head.next;
                this.head = temp;
                size--;
                return;
            } else {
                //要删除头节点，链表长度等于1的情况，直接将头节点设为 null
                this.head = null;
                size--;
                return;
            }
        }
        Node temp = this.head;
        //拿到当前 index的前一个节点
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node node = temp.next;
        temp.next = node.next;
        size--;
    }
}
