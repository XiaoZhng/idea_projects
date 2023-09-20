package com.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Alonso
 */
public class JDKProxy {
    public static void main(String[] args) {

        //创建接口实现类代理对象
        Class[] interfaces = {UserDAO.class};
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });

        UserDAO userDAO = new UserDAOImpl();
        UserDAO dao = (UserDAO) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDAOProxy(userDAO));
        dao.update("22");
    }
}


//创建代理对象代码
class UserDAOProxy implements  InvocationHandler{

    //谁创建的代理对象，就把它传递进来
    //有参构造传递
    private Object obj;
    public UserDAOProxy(Object obj){
        this.obj = obj;
    }

    //增加的功能
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //执行方法之前
        System.out.println("执行方法之前.." + method.getName() + ".." + Arrays.toString(args));

        //执行方法
        Object invoke = method.invoke(obj, args);

        //执行方法之后
        System.out.println("执行方法之后..");

        return invoke;
    }
}