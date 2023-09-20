package com.zledu.homeWork;

//写入四种访问修饰符和各自的访问权限

/*
*               本类          同包         子类          不同包
*   public       √            √            √             √
    protected    √            √            √             ×
    默认          √            √            ×             ×
    private      √            ×            ×             ×
* */

public class homeWork02 {
}

class p{
    public int age;
    private int sal;
    protected int ages;
    int ji;
}