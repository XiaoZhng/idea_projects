package com.node;

/**
 * @author Alonso
 */
public class Node01 {
    /**
     * 删除链表中的节点
     */
    public static void main(String[] args) {
        //链表 2 ——> 4 ——> 6
        Node n1 = new Node(2);
        //前一个节点指向后一个结点
        n1.next = new Node(4);
        //前一个节点指向后一个结点
        n1.next.next = new Node(6);
        System.out.print("链表n1= ");
//        showNode(n1);
        
        //在节点 4 后面 插入节点 9
        Node newNode = new Node(9);
        //因为要插入节点，所以要遍历到 6 节点处
        Node pre = n1;
        //判断条件：当节点的value不是 4时，就继续向后遍历
        while (pre.value != 4){
            //把遍历完的节点的后一个节点赋给要遍历的节点
            pre = pre.next;
        }
        //遍历到 4节点处
        //先指后一个节点
        newNode.next = pre.next;//9节点的下一个节点 连接到 4节点的下一个节点（6节点）
        pre.next = newNode;//4节点的下一个节点 连接到 9节点

        System.out.print("插入后的链表n1= ");
//        showNode(n1);


        System.out.println("=====================");
        //删除 4节点
        deleteNode(n1, 4);
//        showNode(n1);
    }

    static class Node {
        int value; //存放的值
        Node next; //结点指向

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

//    public static void showNode(Node node){
//        while (node != null){
//            System.out.print(node.value + "  ");
//            node = node.next;
//        }
//    }

    public static Node deleteNode(Node node, int i){
        //定义双指针
        Node n1 = node;
        Node n2 = node;
        //循环节点
        while (n1.next != null){
            //先判断有没有找到要删除的节点
            if (n1.value == i){
                n2.next = n1.next;
                break;
            }

            //没找到，就记录当前节点
            n2 = n1;
            //并且继续遍历下一个节点
            n1 = n1.next;
        }
        return node;
    }
}


