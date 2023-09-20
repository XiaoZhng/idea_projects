package com.tree;

public class tree01 {
    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.insert("A");
        BinaryNode<String> a = tree.root;
        BinaryNode<String> c = tree.insert("C", a, true);
        BinaryNode<String> f = tree.insert("F", a, false);
        BinaryNode<String> g = tree.insert("G", c, true);
        BinaryNode<String> s = tree.insert("S", c, false);
        BinaryNode<String> b = tree.insert("B", s, false);
        BinaryNode<String> z = tree.insert("Z", f, false);

        System.out.println("节点数:"+tree.size());

        System.out.print("叶子节点= ");
        tree.leaf();
        System.out.println("叶子数:"+tree.leafCount());

        System.out.println("高度:"+tree.height());
    }
}

class BinaryNode<T> {
    public T data;
    public BinaryNode<T> left,right;

    public BinaryNode(T data) {
        this.data = data;
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public boolean isLeaf(){
        return left==null && right==null;
    }

    @Override
    public String toString() {
        return  data.toString();
    }
}
class BinaryTree<T> {
    public BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void insert(T x){ //将此节点插入，并且作为根节点 root
        if(x!=null){
            this.root = new BinaryNode<T>(x,this.root,null);
        }
    }

    public BinaryNode<T> insert(T x,BinaryNode<T> p,boolean left){ // 数据 ，被插入到哪个节点下，是否左边插入
        if(x==null || p==null){
            return null;
        }
        if(left){
            return p.left = new BinaryNode<T>(x,p.left,null);
        }
        return p.right = new BinaryNode<T>(x,null,p.right);
    }

    @Override
    public String toString() {
        return toString(this.root);
    }
    public String toString(BinaryNode p) {
        if(p==null) {
            return "";
        }

        if(p.left==null && p==p.right){
            return p.data.toString();
        }
        return p.data.toString() + "(" + toString(p.left) + "," + toString(p.right) + ")";
    }

    //长度
    public int size(){
        return size(this.root);
    }

    public int size(BinaryNode p){
        //如果节点为 null，直接返回 0
        if(p==null){
            return 0;
        }
        //左子树 + 右子树 + 根节点 = 树总结点
        return size(p.left) + size(p.right) + 1 ;
    }

    //叶子节点
    public void leaf(){
        leaf(this.root);
        System.out.println("");
    }
    public void leaf(BinaryNode p){
        //如果节点为 null，直接返回，结束方法
        if(p==null) {
            return;
        }

        if(p.left == null && p.right == null){
            System.out.print(p.data+"  ");
        }

        leaf(p.left);
        leaf(p.right);
    }

    //叶子总数
    public int leafCount(){
        return leafCount(this.root);
    }
    public int leafCount(BinaryNode p){
        //如果节点为 null，直接返回 0
        if(p==null) {
            return 0;
        }

        if(p.right == null && p.left == null){
            return 1;
        }
        return leafCount(p.left) + leafCount(p.right);
    }

    //高度
    public int height(){
        return height(this.root);
    }
    public int height(BinaryNode p){
        //节点为 null，高度为 0
        if(p==null) {
            return 0;
        }
        //左子树高度
        int left = height(p.left);
        //右子树高度
        int right = height(p.right);
        //加上根节点=总高度
        return left + right +1;
    }
}