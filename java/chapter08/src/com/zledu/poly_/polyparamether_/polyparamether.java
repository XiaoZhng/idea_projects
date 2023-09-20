package com.zledu.poly_.polyparamether_;

public class polyparamether {
    public static void main(String[] args) {
        Worker tom = new Worker("Tom", 3000);
        Manage tim = new Manage("Tim", 5000, 20000);
        polyparamether polyparamether = new polyparamether();
        polyparamether.showEmpAnnual(tom);
        polyparamether.showEmpAnnual(tim);
        polyparamether.testWork(tom);
        polyparamether.testWork(tim);
    }

    //方法不能写在main方法中
    //showEmpAnnual(Employee e)
    //实现获取任何员工对象的年工资，并在main方法中调用该方法 [e.getAnnual()]
    public void showEmpAnnual(Employee e){
        System.out.println(e.getAnnual());
    }

    //添加一个方法，testWork，如果是普通员工则调用work方法，如果是经理则调用manage方法
    public void testWork(Employee e){
        if(e instanceof Worker){
            ((Worker)e).Work(); //向下转型操作
        }else if(e instanceof Manage) {
            ((Manage) e).manage(); //向下转型操作
        }else{
            System.out.println("运行类型错误");
        }
    }
}
