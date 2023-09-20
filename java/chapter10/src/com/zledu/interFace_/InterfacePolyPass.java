package com.zledu.interFace_;

/**
 * 实现接口多态传递现象
 */
public class InterfacePolyPass {
    public static void main(String[] args) {
        //接口类型的变量可以指向，实现了该接口的类的对象实例
        IG ig = new teacher();
        /**
         * 如果IG 继承了 IH接口，而teacher类 实现了 IG接口
         * 那么，实际上就相当于 teacher类 也实现了 IH接口
         * 这就是所谓的接口动态传递现象
         */
        IH ih = new teacher();
    }
}

interface IH{}
interface IG extends IH{}
class teacher implements IG{}