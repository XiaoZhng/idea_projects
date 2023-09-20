package com.zledu.annotation_;

public class Deprecated_ {
    public static void main(String[] args) {
        A a = new A();
        a.hi();
    }
}

/**
 * 1.@Deprecated 修饰某个元素，表示该元素已经过失
 * 2.即不再推荐使用，但仍可以使用
 * 3.查看 @Deprecated 直接类的源码
 * 4.可以修饰方法、类、字段、包、参数 等等
 *  @Documented
 *  @Retention(RetentionPolicy.RUNTIME)
 *  @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
 *  public @interface Deprecated {
 *  }
 */
@Deprecated
class A{
    @Deprecated
    public void hi(){}
}