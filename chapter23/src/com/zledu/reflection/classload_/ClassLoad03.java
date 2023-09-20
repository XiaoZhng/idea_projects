package com.zledu.reflection.classload_;

/**
 * @author Alonso
 * 演示类加载-初始化阶段
 */
public class ClassLoad03 {
    public static void main(String[] args) {
        //分析：
        //1.加载B类，并生成 B的class对象
        //2.连接 static int num = 0;
        //3.初始化阶段
        // 依次自动收集类中所有静态变量的赋值动作和静态代码块中的语句，并合并
        /*
            clinit(){ //收集
                System.out.println("B的静态代码块..");
                num = 300;
                static int num = 100;
            }
            合并:
            clinit(){ //收集
                System.out.println("B的静态代码块..");
                num = 100;
            }
         */
        //System.out.println(B.num);//100

        //看源码：看看加载类的时候，是有同步机制控制
        B b = new B();
        /*
            protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
            { //正因为有这个机制，才能保证某个类在内存中只有一份Class对象
                synchronized (getClassLoadingLock(name)) {
                    // First, check if the class has already been loaded
                    Class<?> c = findLoadedClass(name);
                    if (c == null) {
                        long t0 = System.nanoTime();
                        try {
                            if (parent != null) {
                                c = parent.loadClass(name, false);
                            } else {
                                c = findBootstrapClassOrNull(name);
                            }
                        } catch (ClassNotFoundException e) {
                            // ClassNotFoundException thrown if class not found
                            // from the non-null parent class loader
                        }

                        if (c == null) {
                            // If still not found, then invoke findClass in order
                            // to find the class.
                            long t1 = System.nanoTime();
                            c = findClass(name);

                            // this is the defining class loader; record the stats
                            sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                            sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                            sun.misc.PerfCounter.getFindClasses().increment();
                        }
                    }
                    if (resolve) {
                        resolveClass(c);
                    }
                    return c;
                }
            }
         */
    }
}

class B{
    static {
        System.out.println("B的静态代码块..");
        num = 300;
    }
    static int num = 100;
    public B(){
        System.out.println("B的构造器..");
    }
}